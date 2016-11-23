package luyao.everything.ui.activity;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.base.BaseActivity;

/**
 * Created by Lu
 * on 2016/11/23 14:50.
 */

public class CurrencyExchagneActivity extends BaseActivity {

    @BindView(R.id.currency_from)
    TextView currency_from;
    @BindView(R.id.currency_to)
    TextView currency_to;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_currency_exchagne;
    }

    @Override
    protected void initView() {
        title_tv.setText(R.string.cueerncy_exchange);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }

    @OnClick({R.id.currency_from,R.id.currency_to})
    public void choose(View view){

    }

    private void chooseCurrency(TextView v){

    }
}
