package luyao.everything.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.NumDetailAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.NumberEnity;
import luyao.everything.utils.Constants;
import luyao.everything.view.LinearItemDecoration;
import luyao.everything.view.dialog.ShowNumberDialog;

/**
 * 号码列表
 * Created by Lu
 * on 2016/11/24 14:27.
 */

public class NumberDetailActivity extends BaseActivity {

    @BindView(R.id.numberDetailRecycle)
    RecyclerView numberDetailRecycle;

    private NumDetailAdapter numDetailAdapter;
    private NumberEnity numberEnity;
    private List<NumberEnity.NumberDetail> numberDetailList = new ArrayList<>();
    private ShowNumberDialog showNumberDialog;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_number_detail;
    }

    @Override
    protected void initView() {
        numberEnity = (NumberEnity) getIntent().getSerializableExtra(Constants.NUMBERENITY);
        title_tv.setText(numberEnity.getKind());
        numberDetailRecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        numberDetailRecycle.addItemDecoration(new LinearItemDecoration(mContext, LinearItemDecoration.VERTICAL_LIST));
        if (numDetailAdapter == null) numDetailAdapter = new NumDetailAdapter();
        numberDetailRecycle.setAdapter(numDetailAdapter);
    }

    @Override
    protected void initData() {
        numberDetailList = numberEnity.getNumberDetailList();
        numDetailAdapter.setData(numberDetailList);
        numDetailAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showNumberDialog = new ShowNumberDialog(NumberDetailActivity.this, R.style.dialog, numberDetailList.get(position));
                showNumberDialog.show();
            }
        });
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
