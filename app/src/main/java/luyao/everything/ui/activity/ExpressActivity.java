package luyao.everything.ui.activity;

import luyao.everything.R;
import luyao.everything.base.BaseWebViewActivity;
import luyao.everything.utils.Constants;

/**
 * 快递查询
 * Created by Lu
 * on 2016/11/23 12:11.
 */

public class ExpressActivity extends BaseWebViewActivity {

    @Override
    protected void initView() {
        super.initView();
        title_tv.setText(R.string.express_search);
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }

    @Override
    protected void initData() {
        super.initData();
        webView.loadUrl(Constants.EXPRESS_100_URL);
    }
}
