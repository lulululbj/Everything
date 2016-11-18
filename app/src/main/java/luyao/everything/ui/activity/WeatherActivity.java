package luyao.everything.ui.activity;

import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;

import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.area.Province;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.utils.LocationUtil;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.ToastUtil;
import luyao.everything.utils.Util;
import rx.Subscriber;

/**
 * 天气
 * Created by Lu
 * on 2016/11/17 11:03.
 */

public class WeatherActivity extends BaseActivity {

    @BindView(R.id.weather_city)
    TextView weather_city;
    @BindView(R.id.weather_today)
    TextView weather_today;
    @BindView(R.id.weather_tem)
    TextView weather_tem;
    @BindView(R.id.weather_weekday)
    TextView weather_weekday;
    @BindView(R.id.weather_tem_range)
    TextView weather_tem_range;
    @BindView(R.id.weather_sunrise)
    TextView weather_sunrise;
    @BindView(R.id.weather_sunoff)
    TextView weather_sunoff;
    @BindView(R.id.weather_wind_speed)
    TextView weather_wind_speed;
    @BindView(R.id.weather_humidity)
    TextView weather_humidity;
    @BindView(R.id.weather_airCondition)
    TextView weather_airCondition;
    @BindView(R.id.weather_exerciseIndex)
    TextView weather_exerciseIndex;
    @BindView(R.id.weather_coldIndex)
    TextView weather_coldIndex;
    @BindView(R.id.weather_dressingIndex)
    TextView weather_dressingIndex;
    @BindView(R.id.weather_washIndex)
    TextView weather_washIndex;
    @BindView(R.id.weather_pollutionIndex)
    TextView weather_pollutionIndex;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
//        title_tv.setText(R.string.weather_forecast);
    }

    @Override
    protected void initData() {

        LocationUtil.getInstance().startLocation(new LocationUtil.LocationCallBack() {
            @Override
            public void locationCallBack(AMapLocation location) {

                getWeather(location);

                LogUtils.e("weather", location.toString());
            }
        });

//        Subscriber<List<Province>> subscriber = new BaseSubscriber<List<Province>>() {
//
//            @Override
//            public void onNext(List<Province> listHttpResult) {
//                ToastUtil.showToast(listHttpResult.size() + "");
//            }
//        };
//        Api.getInstance().getcityList(subscriber);


    }

    private void getWeather(AMapLocation location) {
        if (location.getErrorCode() == 0) {
            String city = location.getDistrict();
            if (city.endsWith("区")) {
                city = city.substring(0, city.length() - 1);
            }
            String province = location.getDistrict();
            Api.getInstance().getWeather(subscriber, city, province);
        }
    }

//    @Override
//    protected void clickBack() {
//        finish();
//    }

    Subscriber<List<WeatherEnity>> subscriber = new BaseSubscriber<List<WeatherEnity>>() {

        @Override
        public void onNext(List<WeatherEnity> listHttpResult) {
            WeatherEnity weatherEnity = listHttpResult.get(0);
            setWeatherData(weatherEnity);
        }
    };

    private void setWeatherData(WeatherEnity weatherData){
        weather_city.setText(weatherData.getDistrct());
        weather_today.setText(weatherData.getWeather());
        weather_tem.setText(weatherData.getTemperature());
        weather_weekday.setText(weatherData.getWeek());
        weather_tem_range.setText(weatherData.getUpdateTime());
        weather_sunrise.setText(weatherData.getSunrise());
        weather_sunoff.setText(weatherData.getSunset());
        weather_wind_speed.setText(weatherData.getWind());
        weather_humidity.setText(weatherData.getHumidity());
        weather_airCondition.setText(weatherData.getAirCondition());
        weather_exerciseIndex.setText(weatherData.getExerciseIndex());
        weather_coldIndex.setText(weatherData.getColdIndex());
        weather_dressingIndex.setText(weatherData.getDistrct());
        weather_washIndex.setText(weatherData.getWashIndex());
        weather_pollutionIndex.setText(weatherData.getPollutionIndex());

    }
}
