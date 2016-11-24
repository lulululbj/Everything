package luyao.everything.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

import luyao.everything.R;
import luyao.everything.enity.GuideEnity;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.ui.activity.CalendarActivty;
import luyao.everything.ui.activity.CurrencyExchagneActivity;
import luyao.everything.ui.activity.ExpressActivity;
import luyao.everything.ui.activity.GuideActivity;
import luyao.everything.ui.activity.LotteryActivity;
import luyao.everything.ui.activity.TrainActivity;
import luyao.everything.ui.activity.UserfulNumberActivity;
import luyao.everything.ui.activity.WeatherActivity;

/**
 * 业务工具类
 * Created by Lu
 * on 2016/11/16 14:21.
 */

public class Util {

    /**
     * 获取所有服务
     */
    public static List<GuideEnity> getAllGuide(Context context) {
        List<GuideEnity> guideEnities = new ArrayList<>();
        String[] guideNames = context.getResources().getStringArray(R.array.guide_name);
        int[] guideImgs = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        Class[] z = {WeatherActivity.class, CalendarActivty.class, LotteryActivity.class, ExpressActivity.class, TrainActivity.class,
                CurrencyExchagneActivity.class, UserfulNumberActivity.class};

        for (int i = 0; i < guideNames.length; i++) {
            GuideEnity guideEnity = new GuideEnity();
            guideEnity.setName(guideNames[i]);
            guideEnity.setResId(guideImgs[i]);
            guideEnity.setZ(z[i]);
            guideEnities.add(guideEnity);
        }
        return guideEnities;
    }


    public static void callPhone(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        context.startActivity(intent);
    }

}
