package luyao.everything.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Lu
 * on 2016/11/21 12:24.
 */

public class TimeUtils {

    public static String LongToTime(String longTime,String format){
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat=new SimpleDateFormat(format);
        Date date=new Date(Long.parseLong(longTime));
        return dateFormat.format(date);
    }
}