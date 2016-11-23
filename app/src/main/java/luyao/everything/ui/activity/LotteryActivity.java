package luyao.everything.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.adapter.LotteryAdapter;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.LotteryResult;
import luyao.everything.utils.ToastUtil;
import luyao.everything.view.SpaceItemDecoration;

/**
 * 彩票查询
 * Created by Lu
 * on 2016/11/22 17:49.
 */

public class LotteryActivity extends BaseActivity {

    @BindView(R.id.lotteryRecycle)
    RecyclerView lotteryRecycle;

    private LotteryAdapter lotteryAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_lottery;
    }

    @Override
    protected void initView() {
        title_tv.setText(R.string.lottery_search);
        lotteryRecycle.setLayoutManager(new LinearLayoutManager(mContext));
        lotteryRecycle.addItemDecoration(new SpaceItemDecoration(20));
        if (lotteryAdapter == null) lotteryAdapter = new LotteryAdapter();
        lotteryRecycle.setAdapter(lotteryAdapter);
    }

    @Override
    protected void initData() {
        getLotteryList();
    }

    private void getLotteryList() {
        Api.getInstance().getLotteryList(new BaseSubscriber<List<String>>() {
            @Override
            public void onNext(List<String> list) {
                lotteryAdapter.setData(list);
            }
        });
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
