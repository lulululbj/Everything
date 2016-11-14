package luyao.everything.ui.activity;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.base.BaseActivity;

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
    protected void setListener() {

    }

    @OnClick({R.id.welcome_tv})
    public void stopTimer() {
        timer.cancel();
        startActivity(MainActivity.class);
        finish();
    }

    private CountDownTimer timer = new CountDownTimer(4 * 1000, 1000) {
        @SuppressLint("DefaultLocale")
        @Override
        public void onTick(long l) {
            welcome_tv.setText(String.format("%ds", l / 1000));
        }

        @Override
        public void onFinish() {
            startActivity(MainActivity.class);
            finish();
        }
    };
}
