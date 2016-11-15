package luyao.everything;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局Application
 * Created by Lu
 * on 2016/11/14 17:45.
 */

public class EverythingApplication extends Application {

    public static List<Activity> activities = new ArrayList<>();

    public static Application CONTEXT=null;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT=this;
    }

    public static void addActivity(Activity activity) {
        if (!activities.contains(activity)) activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        if (activities.contains(activity)) activities.remove(activity);
    }
}
