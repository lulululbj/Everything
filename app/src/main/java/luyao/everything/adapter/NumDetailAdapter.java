package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.NumberEnity;

/**
 * Created by Lu
 * on 2016/11/24 14:43.
 */

public class NumDetailAdapter extends BaseRecycleViewAdapter<NumberEnity.NumberDetail, NumDetailAdapter.NumDetailHolder> {


    @Override
    public void bindData(NumDetailHolder holder, NumberEnity.NumberDetail data, int viewType, int position) {
        holder.numberdetail_tv.setText(data.getBrand());
    }

    @Override
    public NumDetailHolder createHolder(ViewGroup parent, int viewType) {
        return new NumDetailHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city, null));
    }

    class NumDetailHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.city)
        TextView numberdetail_tv;

        public NumDetailHolder(View itemView) {
            super(itemView);
        }
    }
}
