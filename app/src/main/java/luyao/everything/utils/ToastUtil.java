package luyao.everything.utils;


import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

import luyao.everything.EverythingApplication;


public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context, String message, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), message, duration);
        } else {
            mToast.setText(message);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void showToast(String message) {
        showToast(EverythingApplication.CONTEXT, message, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, @StringRes int resId, int duration) {
        showToast(context, context.getString(resId), duration);
    }

    public static void showToast(Context context, @StringRes int resId) {
        showToast(context, resId, Toast.LENGTH_SHORT);
    }


}
