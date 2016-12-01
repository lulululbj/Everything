package luyao.everything.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.utils.ScreenUtil;

/**
 * 基类FragmentActivity
 * Created by Lu
 * on 2016/12/1 22:22
 */

public abstract class BaseFragmentActivity extends FragmentActivity {

    protected Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EverythingApplication.removeActivity(this);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData();

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
