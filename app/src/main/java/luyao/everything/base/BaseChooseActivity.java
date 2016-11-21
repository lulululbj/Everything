package luyao.everything.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.utils.ToastUtil;
import luyao.everything.view.LinearItemDecoration;

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
        chooseRecycler.addItemDecoration(new LinearItemDecoration(mContext,LinearItemDecoration.VERTICAL_LIST));
        ToastUtil.showToast("test");
    }

    @Override
    protected void initData() {

    }

    protected void setDataList(List<T> list){
        if (dataList.size()>0)dataList.clear();
        dataList.addAll(list);
    }
}
