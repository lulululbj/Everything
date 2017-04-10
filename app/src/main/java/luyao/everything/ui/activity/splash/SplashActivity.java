package luyao.everything.ui.activity.splash;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.base.mvp.BaseMvpActivity;
import luyao.everything.enity.BingImageBean;
import luyao.everything.enity.area.Province;
import luyao.everything.ui.activity.GuideActivity;
import luyao.everything.ui.activity.MenuActivity;
import luyao.everything.utils.Constants;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.PreferencesUtils;
import rx.Subscriber;

/**
 * 欢迎页
 * Created by Lu
 * on 2016/11/14 17:55.
 */

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashConstract.View {

    @BindView(R.id.welcome_tv)
    TextView welcome_tv;
    @BindView(R.id.splashImg)
    ImageView splashImg;


    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter(this);
    }

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
            mPresenter.getCityList();//城市列表

        }

        mPresenter.getBingImg();


    }

    @OnClick({R.id.welcome_tv})
    public void stopTimer() {
        timer.cancel();
        startActivity();
    }

    private CountDownTimer timer = new CountDownTimer(3 * 1000, 1000) {
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

    private void startActivity() {
        if (PreferencesUtils.get(PreferencesUtils.IS_FIRST, true)) {
            startActivity(GuideActivity.class);

        } else {
            startActivity(MenuActivity.class);
        }
        PreferencesUtils.set(PreferencesUtils.IS_FIRST, false);
        finish();
    }

    @Override
    public void getBingImg(BingImageBean bingImage) {
        LogUtils.e("bing", bingImage.getImages().get(0).getUrlbase());
        String url = String.format("http://cn.bing.com/%s_480x800.jpg", bingImage.getImages().get(0).getUrlbase());
        Glide.with(mContext).load(url).into(splashImg);

    }

    @Override
    public void getCityList(List<Province> list) {
        EverythingApplication.mACache.put(Constants.CITY_LIST, (Serializable) list);
    }
}
