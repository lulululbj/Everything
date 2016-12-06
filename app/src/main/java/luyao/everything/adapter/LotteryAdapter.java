package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
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
    public void bindData(final LotteryHolder holder, String data, int viewType, int position) {
        Api.getInstance().getLotteryResult(new BaseSubscriber<LotteryResult>() {
            @Override
            public void onNext(LotteryResult lotteryResult) {
                holder.lottery_name.setText(lotteryResult.getName());
                holder.lottery_number.setText(lotteryResult.getNumber());
                holder.lottery_period.setText(String.format("%s期", lotteryResult.getPeriod()));
                if (lotteryResult.getPool() == 0) {
                    holder.lottery_pool_tv.setVisibility(View.GONE);
                    holder.lottery_pool.setVisibility(View.GONE);
                } else {
                    holder.lottery_pool_tv.setVisibility(View.VISIBLE);
                    holder.lottery_pool.setVisibility(View.VISIBLE);

                    java.math.BigDecimal bigDecimal = new java.math.BigDecimal(lotteryResult.getPool());
                    holder.lottery_pool.setText(String.format("%s元",bigDecimal.toPlainString()));
                }
                holder.lottery_time.setText(lotteryResult.getAwardDateTime());
            }
        }, data, "");
    }

    @Override
    public LotteryHolder createHolder(ViewGroup parent, int viewType) {
        return new LotteryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lottery_item, null));
    }

    class LotteryHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.lottery_name)
        TextView lottery_name;
        @BindView(R.id.lottery_number)
        TextView lottery_number;
        @BindView(R.id.lottery_period)
        TextView lottery_period;
        @BindView(R.id.lottery_pool)
        TextView lottery_pool;
        @BindView(R.id.lottery_pool_tv)
        TextView lottery_pool_tv;
        @BindView(R.id.lottery_time)
        TextView lottery_time;

        public LotteryHolder(View itemView) {
            super(itemView);
        }
    }
}
