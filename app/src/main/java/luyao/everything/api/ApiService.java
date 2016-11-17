package luyao.everything.api;

import java.util.List;

import luyao.everything.enity.HttpResult;
import luyao.everything.enity.TodayFortuneEnity;
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

interface ApiService {

    @GET("v1/weather/query")
    Observable<HttpResult<List<WeatherEnity>>> getWeather(@Query("key") String key, @Query("city") String city, @Query("province") String province);

    @GET("v1/weather/citys")
    Observable<HttpResult<List<Province>>> getCity(@Query("key")String key);

    @GET("appstore/calendar/day")
    Observable<HttpResult<TodayFortuneEnity>> getTodayFortune(@Query("key") String key, @Query("date") String date);
}
