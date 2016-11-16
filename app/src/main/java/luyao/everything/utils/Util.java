package luyao.everything.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import luyao.everything.R;
import luyao.everything.enity.GuideEnity;
import luyao.everything.ui.activity.GuideActivity;

/**
 * 业务工具类
 * Created by Lu
 * on 2016/11/16 14:21.
 */

public class Util {

    public static List<GuideEnity> getAllGuide(Context context) {
        List<GuideEnity> guideEnities = new ArrayList<>();
        String[] guideNames = context.getResources().getStringArray(R.array.guide_name);
        int[] guideImgs = {R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        Class[] z = {GuideActivity.class, GuideActivity.class};

        for (int i = 0; i < guideNames.length; i++) {
            GuideEnity guideEnity = new GuideEnity();
            guideEnity.setName(guideNames[i]);
            guideEnity.setResId(guideImgs[i]);
            guideEnity.setZ(z[i]);
            guideEnities.add(guideEnity);
        }

        return guideEnities;
    }

}
