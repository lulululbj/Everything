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
    private OkHttpClient.Builder httpClientBuilder;

    private Api() {
        httpClientBuilder= new OkHttpClient.Builder();
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
     * 获取天气
     *
     * @param city     城市名
     * @param province 省份名
     */
    public void getWeather(Subscriber<HttpResult<List<WeatherEnity>>> subscriber, String city, String province) {
        getApiSerVice(MOB_BASE_URL).getWeather(Constants.MOB_APPKEY, city, province)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /**
     * 万年历
     */
    public void getTodayFortune(Subscriber<HttpResult<TodayFortuneEnity>> subscriber,String date){
        getApiSerVice(MOB_BASE_URL).getTodayFortune(Constants.MOB_APPKEY,date);
    }
}
