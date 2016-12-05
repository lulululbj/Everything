package luyao.everything.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.message.ChooseCityMessage;


/**
 * 选择省市区 基类Activity
 * Created by Lu
 * on 2016/11/21 14:54.
 */

public abstract class BaseChooseActivity<T> extends BaseActivity {

    protected List<T> dataList=new ArrayList<>();

    @BindView(R.id.chooseRecycle)
    protected RecyclerView chooseRecycler;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_basechoose;
    }

    @Override
    protected void initView() {
        chooseRecycler.setLayoutManager(new LinearLayoutManager(mContext));
//        chooseRecycler.addItemDecoration(new LinearItemDecoration(mContext,LinearItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void initData() {

    }

    protected void setDataList(List<T> list){
        if (dataList.size()>0)dataList.clear();
        dataList.addAll(list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void chooseCity(ChooseCityMessage cityMessage){
        onBackPressed();
    }
}
