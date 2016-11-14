package luyao.everything.utils;

import android.util.Log;

import luyao.everything.BuildConfig;


public class LogUtils {
    public static boolean isDebug = BuildConfig.DEBUG;
    public static String TAG = "com.adskip";

    public static void e(String message) {
        e(TAG, message);
    }

    public static void d(String message) {
        d(TAG, message);
    }

    public static void v(String message) {
        v(TAG, message);
    }

    public static void i(String message) {
        i(TAG, message);
    }

    public static void i(String tag, String message) {
        if (isDebug) {
            Log.i(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (isDebug) {
            Log.e(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (isDebug) {
            Log.d(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (isDebug) {
            Log.v(tag, message);
        }
    }

}
