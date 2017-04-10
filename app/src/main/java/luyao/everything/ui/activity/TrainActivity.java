package luyao.everything.ui.activity;

import luyao.everything.R;
import luyao.everything.base.BaseWebViewActivity;
import luyao.everything.utils.Constants;

/**
 * Created by Lu
 * on 2016/11/23 13:50.
 */

public class TrainActivity extends BaseWebViewActivity {

    @Override
    protected void initView() {
        super.initView();
        title_tv.setText(R.string.train_search);
    }

    @Override
    protected void initData() {
        super.initData();
        webView.loadUrl(Constants.TUNIU_TRAIN_URL);
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
