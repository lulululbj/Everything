package luyao.everything.ui.activity;

import com.amap.api.location.AMapLocation;

import luyao.everything.R;
import luyao.everything.base.BaseActivity;
import luyao.everything.utils.LocationUtil;
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
        LocationUtil.getInstance().startLocation(new LocationUtil.LocationCallBack() {
            @Override
            public void locationCallBack(AMapLocation location) {
                ToastUtil.showToast(location.getAddress());
            }
        });
    }

    @Override
    protected void clickBack() {
        finish();
    }
}
