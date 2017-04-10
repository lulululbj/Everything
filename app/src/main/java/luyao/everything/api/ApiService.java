package luyao.everything.api;


import java.util.List;

import luyao.everything.enity.BingImageBean;
import luyao.everything.enity.CalendarFortune;
import luyao.everything.enity.ExcangeResult;
import luyao.everything.enity.HttpResult;
import luyao.everything.enity.LotteryResult;
import luyao.everything.enity.area.Province;
import luyao.everything.enity.weather.WeatherEnity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * MobApi
 * Created by Lu
 * on 2016/11/15 12:38.
 */

public interface ApiService {

    @GET("v1/weather/query")
    Observable<HttpResult<List<WeatherEnity>>> getWeather(@Query("key") String key, @Query("city") String city, @Query("province") String province);

    @GET("v1/weather/citys")
    Observable<HttpResult<List<Province>>> getCity(@Query("key")String key);

    @GET("appstore/calendar/day")
    Observable<HttpResult<CalendarFortune>> getTodayFortune(@Query("key") String key, @Query("date") String date);

    @GET("lottery/list")
    Observable<HttpResult<List<String>>>  getLotteryList(@Query("key")String key);

    @GET("lottery/query")
    Observable<HttpResult<LotteryResult>> getLotteryResult(@Query("key")String key,@Query("name")String name,@Query("period")String period);

    @GET("exchange/code/query")
    Observable<HttpResult<ExcangeResult>> getExchangeResult(@Query("key")String key,@Query("code")String code);

    @GET("http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&nc=1491805738297&pid=hp")
    Observable<BingImageBean> getBingImage();

}
