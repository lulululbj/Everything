package luyao.everything.utils;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

import luyao.everything.R;
import luyao.everything.enity.GuideEnity;
import luyao.everything.ui.activity.ExpressActivity;
import luyao.everything.ui.activity.TrainActivity;
import luyao.everything.ui.activity.UserfulNumberActivity;
import luyao.everything.ui.activity.WeatherActivity;
import luyao.everything.ui.activity.calendar.CalendarActivty;
import luyao.everything.ui.activity.currencyexchange.CurrencyExchagneActivity;
import luyao.everything.ui.activity.lottery.LotteryActivity;

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
        int[] guideImgs = {R.drawable.weather_forecast, R.drawable.calendar, R.drawable.lottery, R.drawable.express, R.drawable.train,
                R.drawable.currency, R.drawable.number};
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

    public static void givePraise(Context context) {
        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void share(Context context) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "我正在使用百事通，快去应用市场下载吧！");
        shareIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    /**
     * 实现文本复制功能
     */
    public static void copy(String content, Context context) {
        ClipboardManager cmb = (ClipboardManager) context
                .getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
    }

}
