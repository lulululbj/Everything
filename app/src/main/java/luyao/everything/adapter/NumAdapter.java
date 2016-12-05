package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.NumberEnity;

/**
 * Created by Lu
 * on 2016/11/24 10:22.
 */

public class NumAdapter extends BaseRecycleViewAdapter<NumberEnity, NumAdapter.NumberHolder> {


    @Override
    public void bindData(NumberHolder holder, NumberEnity data, int viewType, int position) {
        holder.main_img.setImageResource(data.getResId());
        holder.main_tv.setText(data.getKind());
    }

    @Override
    public NumberHolder createHolder(ViewGroup parent, int viewType) {
        return new NumberHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.number_item, null));
    }

    class NumberHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.main_img)
        ImageView main_img;

        @BindView(R.id.main_tv)
        TextView main_tv;

        public NumberHolder(View itemView) {
            super(itemView);
        }
    }
}
