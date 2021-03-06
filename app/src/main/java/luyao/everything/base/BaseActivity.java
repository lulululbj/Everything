package luyao.everything.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.utils.ScreenUtil;


/**
 * 基类Activity
 * Created by Lu
 * on 2016/11/14 17:26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Nullable
    @BindView(R.id.title_back)
    protected ImageView title_back;
    @Nullable
    @BindView(R.id.title_tv)
    protected TextView title_tv;
    @Nullable
    @BindView(R.id.title_right)
    protected TextView title_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EverythingApplication.addActivity(this);
        mContext = this;
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        ScreenUtil.initScale(ButterKnife.findById(this, android.R.id.content));

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        initView();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    @Optional
    @OnClick(R.id.title_back)
    public void back() {
        clickBack();
    }

    @Optional
    @OnClick(R.id.title_right)
    public void right() {
        clickRight();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EverythingApplication.removeActivity(this);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData();

    protected void clickBack() {
    }

    protected void clickRight() {
    }

    protected void startActivity(Class z) {
        startActivity(new Intent(this, z));
        overridePendingTransition(R.anim.slide_in_form_right, R.anim.slide_out_to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }
}
