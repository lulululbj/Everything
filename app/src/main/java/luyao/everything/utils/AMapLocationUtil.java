package luyao.everything.utils;

import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import luyao.everything.EverythingApplication;

/**
 * TODO    高德地图定位工具类
 * Created by luyao
 * on 2016/5/5 19:47
 */
public class AMapLocationUtil {

    private static AMapLocationUtil single = null;

    private AMapLocationClient locationClient = null;

    private AMapLocationClientOption locationOption = null;

    private AMapLocationListener locationListener = new MyLocationListener();

    private LocationCallBack locationCallBack = null;

    public AMapLocationUtil() {

        if (locationClient == null) {
            initClient();
        }
    }

    private void initClient() {
        locationClient = new AMapLocationClient(EverythingApplication.CONTEXT);
        initOption();
    }

    private void initOption() {
        locationOption = new AMapLocationClientOption();
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        locationOption.setOnceLocation(true);
//        locationOption.setInterval(60 * 1000);
        locationClient.setLocationOption(locationOption);
        locationClient.setLocationListener(locationListener);
    }

    public void startLocation(LocationCallBack locationCallBack) {

        this.locationCallBack = locationCallBack;

        if (locationClient == null) {
            initClient();
        }

        if (locationOption == null) {
            initOption();
        }

        if (locationListener == null) {
            locationListener = new MyLocationListener();
        }

        locationClient.startLocation();
    }

    private class MyLocationListener implements AMapLocationListener {

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {

//            UserService userService=new UserService(ForeSeeApplication.context);
//            userService.getWeather(aMapLocation.getCity(), new UserService.GetWheatherCallBack() {
//                @Override
//                public void getWheatherCallBack(Weather weather) {
////                    Helper.showTosat(weather.toString());
//                }
//            });

//            Constants.LONGITUDE = aMapLocation.getLongitude() ;
//            Constants.LATITUDE = aMapLocation.getLatitude() ;
//            Helper.set(ForeSeeApplication.context, Constants.LONGITUDE+"",aMapLocation.getLongitude());
//            Helper.set(ForeSeeApplication.context, Constants.LATITUDE+"",aMapLocation.getLatitude());
            Log.e("location", "type=" + aMapLocation.getLocationType() + "");
            Log.e("location", "longitude=" + aMapLocation.getLongitude() + "");
            Log.e("location", "latitude=" + aMapLocation.getLatitude() + "");
            Log.e("location", "city=" + aMapLocation.getCity() + "");
            locationCallBack.locationCallBack(aMapLocation);
        }
    }

    public interface LocationCallBack {
        void locationCallBack(AMapLocation location);
    }


    public void destroyLocation() {
        if (locationClient != null) {
            locationClient.stopLocation();
            locationClient.onDestroy();
        }
        locationOption = null;
        locationListener = null;
    }
}
