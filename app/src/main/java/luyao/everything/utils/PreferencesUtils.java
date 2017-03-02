package luyao.everything.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import luyao.everything.EverythingApplication;

/**
 * SharedPreferences存储工具类
 * Created by Lu
 * on 2016/11/21 15:27.
 */

public class PreferencesUtils {

    public static final String IS_FIRST = "isFirst";//第一次进入app
    public static final String PROVINCE = "province";//用户选择省份
    public static final String CITY = "city";
    public static final String DISTRICT = "district";
    public static final String IS_FIRST_WEATHER="isFirstWeather";//第一次查询天气


    @SuppressWarnings("unchecked")
    public static synchronized <T> T get(String name, T defaultValue) {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(EverythingApplication.CONTEXT);
        T value = null;
        if (defaultValue instanceof Boolean) {
            value = (T) (Boolean) (prefs.getBoolean(name, (Boolean) defaultValue));
        } else if (defaultValue instanceof Integer) {
            value = (T) (Integer) (prefs.getInt(name, (Integer) defaultValue));
        } else if (defaultValue instanceof String) {
            value = (T) (prefs.getString(name, (String) defaultValue));
        } else if (defaultValue instanceof Long) {
            value = (T) ((Long) prefs.getLong(name, (Long) defaultValue));
        } else if (defaultValue instanceof Float) {
            value = (T) ((Float) prefs.getFloat(name, (Float) defaultValue));
        }
        return value;
    }

    public static synchronized <T> void set(String name, T value) {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(EverythingApplication.CONTEXT);
        SharedPreferences.Editor editor = prefs.edit();
        if (value instanceof Boolean) {
            editor.putBoolean(name, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(name, (Integer) value);
        } else if (value instanceof String) {
            editor.putString(name, (String) value);
        } else if (value instanceof Long) {
            editor.putLong(name, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(name, (Float) value);
        }
        editor.apply();
    }
}
