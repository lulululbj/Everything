package luyao.everything.ui.activity;

import java.util.List;

import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.LotteryResult;
import luyao.everything.utils.ToastUtil;

/**
 * 彩票查询
 * Created by Lu
 * on 2016/11/22 17:49.
 */

public class LotteryActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_lottery;
    }

    @Override
    protected void initView() {
        getLotteryResult("大乐透");
    }

    @Override
    protected void initData() {

    }

    private void getLotteryList() {
        Api.getInstance().getLotteryList(new BaseSubscriber<List<String>>() {
            @Override
            public void onNext(List<String> list) {
                ToastUtil.showToast(list.size() + "");
            }
        });
    }

    private void getLotteryResult(String name) {
        Api.getInstance().getLotteryResult(new BaseSubscriber<LotteryResult>() {
            @Override
            public void onNext(LotteryResult lotteryResult) {
                ToastUtil.showToast(lotteryResult.toString());
            }
        }, name, "");
    }
}
