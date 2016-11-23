package luyao.everything.view.dialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.CurrencyAdapter;
import luyao.everything.enity.Currency;
import luyao.everything.utils.ScreenUtil;

/**
 * 选择币种
 * Created by Lu
 * on 2016/11/23 18:05.
 */

public class ChooseCurrencyPop extends PopupWindow {

    @BindView(R.id.currencyRecycle)
    RecyclerView currencyRecycle;

    private CurrencyAdapter currencyAdapter;

    public ChooseCurrencyPop(){
        initPop();
    }

    private void initPop(){
        View view= LayoutInflater.from(EverythingApplication.CONTEXT).inflate(R.layout.pop_choose_currency,null);
        ScreenUtil.initScale(view);
        ButterKnife.bind(this,view);

        setContentView(view);
        setWidth(ScreenUtil.getScalePxValue(640));
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
//        setBackgroundDrawable();

        currencyRecycle.setLayoutManager(new LinearLayoutManager(EverythingApplication.CONTEXT));
        if (currencyAdapter==null)currencyAdapter=new CurrencyAdapter();
        currencyRecycle.setAdapter(currencyAdapter);

        String[] NAMES=EverythingApplication.CONTEXT.getResources().getStringArray(R.array.currency_name);
        String[] CODES=EverythingApplication.CONTEXT.getResources().getStringArray(R.array.currency_code);
        List<Currency> currencyList=new ArrayList<>();
        for (int i=0;i<NAMES.length;i++){
            Currency currency=new Currency();
            currency.setCode(CODES[i]);
            currency.setName(NAMES[i]);
            currencyList.add(currency);
        }
        currencyAdapter.setData(currencyList);
    }

    public void show(View v){
        if (isShowing()){
            dismiss();
        }else {
            showAtLocation(v, Gravity.CENTER,0,0);
        }
    }


}
