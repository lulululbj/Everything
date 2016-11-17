package luyao.everything.ui.activity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;

import luyao.everything.R;
import luyao.everything.base.BaseActivity;
import luyao.everything.utils.AMapLocationUtil;
import luyao.everything.utils.LocationUtil;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.ToastUtil;

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

//        AMapLocationUtil locationUtil = new AMapLocationUtil();
//        locationUtil.startLocation(new AMapLocationUtil.LocationCallBack() {
//            @Override
//            public void locationCallBack(AMapLocation location) {
//                LogUtils.e("weather", location.toString());
//            }
//        });

        LocationUtil.getInstance().startLocation(new LocationUtil.LocationCallBack() {
            @Override
            public void locationCallBack(AMapLocation location) {
                LogUtils.e("weather", location.toString());
            }
        });

    }

    @Override
    protected void clickBack() {
        finish();
    }
}
