package luyao.everything.utils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import luyao.everything.EverythingApplication;

/**
 * 高德定位工具类
 * Created by Lu
 * on 2016/11/16 16:57.
 */

public class LocationUtil {

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption clientOption = null;
    private LocationCallBack locationCallBack = null;
    private AMapLocationListener locationListener = new MyLocationListener();
    private static LocationUtil mInstance = null;

    private LocationUtil() {
        if (locationClient == null) initClient();
    }

    public static LocationUtil getInstance() {
        if (mInstance == null) mInstance = new LocationUtil();
        return mInstance;
    }

    private void initClient() {
        //初始化client
        locationClient = new AMapLocationClient(EverythingApplication.CONTEXT);
        initOption();

    }

    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void initOption() {
        clientOption = new AMapLocationClientOption();
        clientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        clientOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        clientOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
//        clientOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        clientOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        clientOption.setOnceLocation(true);//可选，设置是否单次定位。默认是false
        clientOption.setOnceLocationLatest(true);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        clientOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        locationClient.setLocationListener(locationListener);
        locationClient.setLocationOption(clientOption);
    }


    private class MyLocationListener implements AMapLocationListener {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
             locationCallBack.locationCallBack(aMapLocation);
        }
    }

    public interface LocationCallBack {
        void locationCallBack(AMapLocation location);
    }

    public void startLocation(LocationCallBack locationCallBack) {

        this.locationCallBack = locationCallBack;

        if (locationClient == null) {
            initClient();
        }

        if (clientOption == null) {
            initOption();
        }

        if (locationListener == null) {
            locationListener = new MyLocationListener();
        }

        locationClient.startLocation();
    }

    public void destroyLocation() {
        if (locationClient != null) {
            locationClient.stopLocation();
            locationClient.onDestroy();
        }
        clientOption = null;
        locationListener = null;
    }


}
