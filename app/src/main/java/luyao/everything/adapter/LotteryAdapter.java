package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.enity.LotteryResult;

/**
 * Created by Lu
 * on 2016/11/22 18:41.
 */

public class LotteryAdapter extends BaseRecycleViewAdapter<String, LotteryAdapter.LotteryHolder> {


    @Override
    public void bindData(LotteryHolder holder, String data, int viewType, int position) {
        Api.getInstance().getLotteryResult(new BaseSubscriber<LotteryResult>() {
            @Override
            public void onNext(LotteryResult lotteryResult) {

            }
        }, data, "");
    }

    @Override
    public LotteryHolder createHolder(ViewGroup parent, int viewType) {
        return new LotteryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lottery_item,null));
    }

    class LotteryHolder extends BaseRecycleViewAdapter.BaseHolder {

        public LotteryHolder(View itemView) {
            super(itemView);
        }
    }
}
