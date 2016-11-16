package luyao.everything.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import luyao.everything.enity.HttpResult;
import luyao.everything.enity.TodayFortuneEnity;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.utils.Constants;
import okhttp3.OkHttpClient;
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
    private OkHttpClient.Builder httpClientBuilder;

    private Api() {
        httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
    }

    public static Api getInstance() {
        if (api == null) api = new Api();
        return api;
    }

    private ApiService getApiSerVice(String baseUrl) {

        Retrofit mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

        ApiService mApiService = mRetrofit.create(ApiService.class);
        return mApiService;
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
     * 万年历
     */
    public void getTodayFortune(Subscriber<HttpResult<TodayFortuneEnity>> subscriber, String date) {
        getApiSerVice(MOB_BASE_URL).getTodayFortune(Constants.MOB_APPKEY, date);
    }
}
