package luyao.everything.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.Currency;
import luyao.everything.enity.ExcangeResult;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.ToastUtil;
import luyao.everything.view.dialog.ChooseCurrencyPop;

/**
 * 货币汇率查询
 * Created by Lu
 * on 2016/11/23 14:50.
 */

public class CurrencyExchagneActivity extends BaseActivity {

    @BindView(R.id.currency_from)
    TextView currency_from;
    @BindView(R.id.currency_to)
    TextView currency_to;
    @BindView(R.id.currency_buyPic)
    TextView currency_buyPic;
    @BindView(R.id.currency_closePri)
    TextView currency_closePri;
    @BindView(R.id.currency_diffAmo)
    TextView currency_diffAmo;
    @BindView(R.id.currency_diffPer)
    TextView currency_diffPer;
    @BindView(R.id.currency_highPic)
    TextView currency_highPic;
    @BindView(R.id.currency_lowPic)
    TextView currency_lowPic;
    @BindView(R.id.currency_openPri)
    TextView currency_openPri;
    @BindView(R.id.currency_range)
    TextView currency_range;
    @BindView(R.id.currency_sellPic)
    TextView currency_sellPic;
    @BindView(R.id.currency_yesDayPic)
    TextView currency_yesDayPic;
    @BindView(R.id.li_currency_result)
    LinearLayout li_currency_result;


    private Currency currencyFrom, currencyTo = null;

    private ChooseCurrencyPop currencyPop;

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

    @OnClick({R.id.currency_from, R.id.currency_to})
    public void choose(View view) {
        chooseCurrency((TextView) view);
    }

    @OnClick(R.id.currency_confirm)
    public void cueerncy_confirm() {
        getRate();
    }

    private void chooseCurrency(final TextView v) {
        if (currencyPop == null) currencyPop = new ChooseCurrencyPop(CurrencyExchagneActivity.this);
        currencyPop.show(v);
        currencyPop.setOnItemClick(new ChooseCurrencyPop.OnItemClick() {
            @Override
            public void onItemCkick(int position, Currency currency) {
                v.setText(currency.getName());
                if (v.getId() == R.id.currency_from) {
                    currencyFrom = currency;
                } else {
                    currencyTo = currency;
                }
            }
        });
    }

    private void getRate() {
        String currencyfrom = currency_from.getText().toString();
        String currencyto = currency_to.getText().toString();
        if (TextUtils.isEmpty(currencyfrom) || TextUtils.isEmpty(currencyto)) {
            ToastUtil.showToast(getString(R.string.please_choose_currency));
        } else {
            String code = currencyFrom.getCode() + currencyTo.getCode();
            Api.getInstance().getExchangeResult(new BaseSubscriber<ExcangeResult>() {
                @Override
                public void onNext(ExcangeResult excangeResult) {
                    setData(excangeResult);
                }
            }, code);
        }
    }

    private void setData(ExcangeResult excangeResult){
        if (excangeResult==null){
            ToastUtil.showToast("暂无信息");
            li_currency_result.setVisibility(View.GONE);
        }else {
            li_currency_result.setVisibility(View.VISIBLE);
            currency_buyPic.setText(excangeResult.getBuyPic());
            currency_closePri.setText(excangeResult.getBuyPic());
            currency_diffAmo.setText(excangeResult.getDiffAmo());
            currency_diffPer.setText(excangeResult.getDiffPer());
            currency_highPic.setText(excangeResult.getHighPic());
            currency_lowPic.setText(excangeResult.getLowPic());
            currency_openPri.setText(excangeResult.getOpenPri());
            currency_range.setText(excangeResult.getRange());
            currency_sellPic.setText(excangeResult.getSellPic());
            currency_yesDayPic.setText(excangeResult.getYesDayPic());
        }
    }
}
