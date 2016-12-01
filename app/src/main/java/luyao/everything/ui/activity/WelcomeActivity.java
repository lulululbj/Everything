package luyao.everything.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.squareup.haha.perflib.Main;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.area.Province;
import luyao.everything.utils.Constants;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.PreferencesUtils;
import rx.Subscriber;

/**
 * 欢迎页
 * Created by Lu
 * on 2016/11/14 17:55.
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.welcome_tv)
    TextView welcome_tv;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        timer.start();
    }

    @Override
    protected void initData() {
        if (PreferencesUtils.get(PreferencesUtils.IS_FIRST, true)) {
            //首次登陆时，获取部分所需数据
            Api.getInstance().getcityList(subscriber);//城市列表

        }
    }

    @OnClick({R.id.welcome_tv})
    public void stopTimer() {
        timer.cancel();
        startActivity();
    }

    private CountDownTimer timer = new CountDownTimer(1 * 1000, 1000) {
        @SuppressLint("DefaultLocale")
        @Override
        public void onTick(long l) {
            welcome_tv.setText(String.format("%ds", l / 1000));
        }

        @Override
        public void onFinish() {
            startActivity();
        }
    };

    Subscriber<List<Province>> subscriber = new BaseSubscriber<List<Province>>() {
        @Override
        public void onNext(List<Province> provinces) {
            LogUtils.e("weather", provinces.size() + "  welcome");
            EverythingApplication.mACache.put(Constants.CITY_LIST, (Serializable) provinces);
        }
    };

    private void startActivity() {
        if (PreferencesUtils.get(PreferencesUtils.IS_FIRST, true)) {
            startActivity(GuideActivity.class);

        } else {
            startActivity(MenuActivity.class);
        }
        PreferencesUtils.set(PreferencesUtils.IS_FIRST, false);
        finish();
    }
}
