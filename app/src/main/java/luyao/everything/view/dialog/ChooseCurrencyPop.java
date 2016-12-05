package luyao.everything.view.dialog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import luyao.everything.adapter.BaseRecycleViewAdapter;
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
    private OnItemClick onItemClick;
    private Activity context;
    private List<Currency> currencyList=new ArrayList<>();

    public ChooseCurrencyPop(Activity context){
        this.context=context;
        initPop();
    }

    private void initPop(){
        View view= LayoutInflater.from(EverythingApplication.CONTEXT).inflate(R.layout.pop_choose_currency,null);
        ScreenUtil.initScale(view);
        ButterKnife.bind(this,view);

        setContentView(view);
        setWidth(ScreenUtil.getScalePxValue(640));
        setHeight(ScreenUtil.getScalePxValue(800));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));

        currencyRecycle.setLayoutManager(new LinearLayoutManager(EverythingApplication.CONTEXT));
//        currencyRecycle.addItemDecoration(new LinearItemDecoration(EverythingApplication.CONTEXT,LinearItemDecoration.VERTICAL_LIST));
        if (currencyAdapter==null)currencyAdapter=new CurrencyAdapter();
        currencyRecycle.setAdapter(currencyAdapter);

        String[] NAMES=EverythingApplication.CONTEXT.getResources().getStringArray(R.array.currency_name);
        String[] CODES=EverythingApplication.CONTEXT.getResources().getStringArray(R.array.currency_code);
        for (int i=0;i<NAMES.length;i++){
            Currency currency=new Currency();
            currency.setCode(CODES[i]);
            currency.setName(NAMES[i]);
            currencyList.add(currency);
        }
        currencyAdapter.setData(currencyList);

        currencyAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (onItemClick!=null){
                    onItemClick.onItemCkick(position,currencyList.get(position));
                    dismiss();
                }
            }
        });

        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(context, 1f);
            }
        });
    }

    public void show(View v){
        if (isShowing()){
            dismiss();
            backgroundAlpha(context, 1f);
        }else {
            showAtLocation(v, Gravity.CENTER,0,0);
            backgroundAlpha(context, 0.7f);
        }
    }

    /**
     * 设置添加屏幕的背景透明度
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

    public interface OnItemClick {
        void onItemCkick(int position, Currency currency);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


}
