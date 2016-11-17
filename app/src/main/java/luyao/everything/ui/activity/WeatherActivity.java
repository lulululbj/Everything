package luyao.everything.ui.activity;

import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;

import java.util.List;

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

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        title_tv.setText(R.string.weather_forecast);
    }

    @Override
    protected void setListener() {

        LocationUtil.getInstance().startLocation(new LocationUtil.LocationCallBack() {
            @Override
            public void locationCallBack(AMapLocation location) {

                getWeather(location);

                LogUtils.e("weather",location.toString());
            }
        });

        Subscriber<List<Province>> subscriber = new BaseSubscriber<List<Province>>() {

            @Override
            public void onNext(List<Province> listHttpResult) {
               ToastUtil.showToast(listHttpResult.size()+"");
            }
        };
        Api.getInstance().getcityList(subscriber);



    }

    private void getWeather(AMapLocation location){
        String city=location.getDistrict();
        if (city.endsWith("区")){
           city=city.substring(0,city.length()-1);
        }
        String province=location.getDistrict();
        Api.getInstance().getWeather(subscriber, city, province);
    }

    @Override
    protected void clickBack() {
        finish();
    }

    Subscriber<List<WeatherEnity>> subscriber = new BaseSubscriber<List<WeatherEnity>>() {

        @Override
        public void onNext(List<WeatherEnity> listHttpResult) {
            WeatherEnity weatherEnity=listHttpResult.get(0);
            LogUtils.e("weather",weatherEnity.toString());
        }
    };
}
