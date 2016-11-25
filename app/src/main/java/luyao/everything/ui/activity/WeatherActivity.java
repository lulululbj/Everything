package luyao.everything.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.FutureWeatherAdapter;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.message.ChooseCityMessage;
import luyao.everything.utils.Constants;
import luyao.everything.utils.LocationUtil;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.PreferencesUtils;
import luyao.everything.utils.TimeUtils;
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
    @BindView(R.id.futureWeatherRecycle)
    RecyclerView futureWeatherRecycle;
    @BindView(R.id.weather_refresh)
    SwipeRefreshLayout weather_refresh;
    @BindView(R.id.rl_weather_root)
    RelativeLayout rl_weather_root;

    private FutureWeatherAdapter weatherAdapter;

    SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            String district = PreferencesUtils.get(PreferencesUtils.DISTRICT, "");
            if (TextUtils.isEmpty(district)) {
                LocationUtil.getInstance().startLocation(new LocationUtil.LocationCallBack() {
                    @Override
                    public void locationCallBack(AMapLocation location) {

                        getWeather(location);

                    }
                });
            } else {
                getWeather(district);
            }

        }
    };

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        futureWeatherRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        if (weatherAdapter == null) weatherAdapter = new FutureWeatherAdapter();
        futureWeatherRecycle.setAdapter(weatherAdapter);
    }

    @Override
    protected void initData() {

        WeatherEnity weatherEnity = (WeatherEnity) EverythingApplication.mACache.getAsObject(Constants.WEATHER_DATA);
        if (weatherEnity != null) {
            setWeatherData(weatherEnity);
        } else {
            rl_weather_root.setVisibility(View.GONE);
        }

        weather_refresh.post(new Runnable() {
            @Override
            public void run() {
                weather_refresh.setRefreshing(true);
            }
        });
        refreshListener.onRefresh();

        ((ScrollView) ButterKnife.findById(this, R.id.weather_scrollview)).smoothScrollTo(0, 20);
    }

    private void getWeather(AMapLocation location) {
        if (location.getErrorCode() == 0) {
            String city = location.getCity();
            if (city.endsWith("市")) {
                city = city.substring(0, city.length() - 1);
            }
            String province = location.getCity();
            Api.getInstance().getWeather(subscriber, city, province);
        }
    }

    private void getWeather(String location) {
        Api.getInstance().getWeather(subscriber, location, location);
    }


    Subscriber<List<WeatherEnity>> subscriber = new BaseSubscriber<List<WeatherEnity>>() {

        @Override
        public void onNext(List<WeatherEnity> listHttpResult) {

            if (listHttpResult != null && listHttpResult.size() != 0) {
                closeRefresh();
                WeatherEnity weatherEnity = listHttpResult.get(0);
                weatherEnity.getFuture().remove(0);
                LogUtils.e("weather", weatherEnity.toString());
                setWeatherData(weatherEnity);
                EverythingApplication.mACache.put(Constants.WEATHER_DATA, weatherEnity);
            }
        }
    };

    private void setWeatherData(WeatherEnity weatherData) {
        rl_weather_root.setVisibility(View.VISIBLE);
        weather_city.setText(weatherData.getDistrct());
        weather_today.setText(weatherData.getWeather());
        weather_tem.setText(weatherData.getTemperature());
        weather_weekday.setText(weatherData.getWeek());
        weather_tem_range.setText(TimeUtils.LongToTime(weatherData.getUpdateTime(), "HH:mm"));
        weather_sunrise.setText(weatherData.getSunrise());
        weather_sunoff.setText(weatherData.getSunset());
        weather_wind_speed.setText(weatherData.getWind());
        weather_humidity.setText(weatherData.getHumidity());
        weather_airCondition.setText(weatherData.getAirCondition());
        weather_exerciseIndex.setText(weatherData.getExerciseIndex());
        weather_coldIndex.setText(weatherData.getColdIndex());
        weather_dressingIndex.setText(weatherData.getDressingIndex());
        weather_washIndex.setText(weatherData.getWashIndex());
        weather_pollutionIndex.setText(weatherData.getPollutionIndex());

        weatherAdapter.setData(weatherData.getFuture());
    }

    private void closeRefresh() {
        weather_refresh.post(new Runnable() {
            @Override
            public void run() {
                weather_refresh.setRefreshing(false);
            }
        });
    }


    @OnClick({R.id.edit_city})
    public void editCity() {
        startActivity(ChooseProvinceActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void chooseCity(ChooseCityMessage cityMessage){
        onBackPressed();
    }
}
