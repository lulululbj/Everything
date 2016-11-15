package luyao.everything.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EverythingApplication.addActivity(this);
        mContext = this;
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        ScreenUtil.initScale(ButterKnife.findById(this, android.R.id.content));
        initView();
        setListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EverythingApplication.removeActivity(this);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void setListener();

    protected void startActivity(Class z){
        startActivity(new Intent(this,z));
        overridePendingTransition(R.anim.slide_in_form_right,R.anim.slide_out_from_left);
    }
}
