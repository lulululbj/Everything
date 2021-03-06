package luyao.everything.api;


import java.util.List;
import java.util.concurrent.TimeUnit;

import luyao.everything.BuildConfig;
import luyao.everything.enity.CalendarFortune;
import luyao.everything.enity.ExcangeResult;
import luyao.everything.enity.HttpResult;
import luyao.everything.enity.LotteryResult;
import luyao.everything.enity.area.Province;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.utils.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by Lu
 * on 2016/11/15 13:35.
 */

public class Api {

    private String MOB_BASE_URL = "http://apicloud.mob.com/";
    private static final int TIME_OUT = 5;
    private static Api api = null;


    private Api() {

    }

    public static Api getInstance() {
       if (api==null){
           synchronized (Api.class){
               if (api==null)
                   api=new Api();
           }
       }
       return api;
    }

    private OkHttpClient getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }


    private <S> S getService(Class<S> serviceClass, String baseUrl) {
        return new Retrofit.Builder()
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build().create(serviceClass);
    }

    private ApiService getApiSerVice(String baseUrl) {

        return new Retrofit.Builder()
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build().create(ApiService.class);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
//            if (httpResult.get() != 0) {
//                throw new ApiException(httpResult.getResultCode());
//            }
            return httpResult.getResult();
        }
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 获取天气
     *
     * @param city     城市名
     * @param province 省份名
     */
    public void getWeather(Subscriber<List<WeatherEnity>> subscriber, String city, String province) {
        Observable observable = getApiSerVice(MOB_BASE_URL).getWeather(Constants.MOB_APPKEY, city, province)
                .map(new HttpResultFunc<List<WeatherEnity>>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取城市列表
     */
    public void getcityList(Subscriber<List<Province>> subscriber) {
        Observable observable = getApiSerVice(MOB_BASE_URL).getCity(Constants.MOB_APPKEY).map(new HttpResultFunc<List<Province>>());
        toSubscribe(observable, subscriber);
    }


    /**
     * 万年历
     */
    public void getTodayFortune(Subscriber<CalendarFortune> subscriber, String date) {
        Observable o = getApiSerVice(MOB_BASE_URL).getTodayFortune(Constants.MOB_APPKEY, date).map(new HttpResultFunc<CalendarFortune>());
        toSubscribe(o, subscriber);
    }

    /**
     * 获取支持的彩种
     */
    public void getLotteryList(Subscriber<List<String>> subscribe) {
        Observable observable = getApiSerVice(MOB_BASE_URL).getLotteryList(Constants.MOB_APPKEY).map(new HttpResultFunc<List<String>>());
        toSubscribe(observable, subscribe);
    }


    /**
     * 获取开奖结果
     */
    public void getLotteryResult(Subscriber<LotteryResult> subscriber, String name, String period) {
        Observable observable = getApiSerVice(MOB_BASE_URL).getLotteryResult(Constants.MOB_APPKEY, name, period).map(new HttpResultFunc<LotteryResult>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取货币汇率
     */
    public void getExchangeResult(Subscriber<ExcangeResult> subscriber,String code){
        Observable observable=getApiSerVice(MOB_BASE_URL).getExchangeResult(Constants.MOB_APPKEY,code).map(new HttpResultFunc<ExcangeResult>());
        toSubscribe(observable,subscriber);
    }
}
