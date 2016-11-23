package luyao.everything.ui.activity;

import luyao.everything.R;
import luyao.everything.base.BaseActivity;

/**
 * Created by Lu
 * on 2016/11/23 13:50.
 */

public class TrainActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_train;
    }

    @Override
    protected void initView() {
        title_tv.setText(R.string.train_search);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
