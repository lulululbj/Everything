package luyao.everything;

import android.app.Activity;
import android.app.Application;

//import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;

import java.util.ArrayList;
import java.util.List;

import luyao.everything.utils.Acache;


/**
 * 全局Application
 * Created by Lu
 * on 2016/11/14 17:45.
 */

public class EverythingApplication extends Application {

    public static List<Activity> activities = new ArrayList<>();

    public static Application CONTEXT=null;

    public static Acache mACache;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT=this;
        mACache=Acache.get(this);

        Bugly.init(getApplicationContext(),"a97cec080f",false);

        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);

    }

    public static void addActivity(Activity activity) {
        if (!activities.contains(activity)) activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        if (activities.contains(activity)) activities.remove(activity);
    }
}
