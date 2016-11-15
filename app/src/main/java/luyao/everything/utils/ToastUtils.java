package luyao.everything.utils;

import android.widget.Toast;

import luyao.everything.EverythingApplication;

/**
 * Created by Lu
 * on 2016/11/15 18:31.
 */

public class ToastUtils {

    private static Toast mToast;

    public static void showToast(String message) {
        if (mToast == null) mToast = new Toast(EverythingApplication.CONTEXT);
        Toast.makeText(EverythingApplication.CONTEXT, message, Toast.LENGTH_SHORT).show();
    }
}
