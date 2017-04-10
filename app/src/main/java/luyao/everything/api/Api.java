package luyao.everything.api;


import java.util.List;
import java.util.concurrent.TimeUnit;

import luyao.everything.BuildConfig;
import luyao.everything.enity.LotteryResult;
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
        if (api == null) {
            synchronized (Api.class) {
                if (api == null)
                    api = new Api();
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

    public ApiService getApiSerVice() {

        return new Retrofit.Builder()
                .baseUrl(MOB_BASE_URL)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(ApiService.class);
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
        Observable observable = getApiSerVice().getWeather(Constants.MOB_APPKEY, city, province)
                .map(new HttpResultFunc<List<WeatherEnity>>());
        toSubscribe(observable, subscriber);
    }


    /**
     * 获取开奖结果
     */
    public void getLotteryResult(Subscriber<LotteryResult> subscriber, String name, String period) {
        Observable observable = getApiSerVice().getLotteryResult(Constants.MOB_APPKEY, name, period).map(new HttpResultFunc<LotteryResult>());
        toSubscribe(observable, subscriber);
    }
}
