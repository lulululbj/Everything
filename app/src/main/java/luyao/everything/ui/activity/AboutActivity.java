package luyao.everything.ui.activity;

import luyao.everything.R;
import luyao.everything.base.BaseActivity;

/**
 * Created by Lu
 * on 2016/12/2 23:23
 */

public class AboutActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
       title_tv.setText(getString(R.string.about));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
