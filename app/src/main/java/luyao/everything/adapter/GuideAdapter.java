package luyao.everything.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.GuideEnity;

/**
 * Created by Lu
 * on 2016/11/15 11:02.
 */

public class GuideAdapter extends BaseRecycleViewAdapter<GuideEnity,GuideAdapter.GuideHolder> {


    @Override
    public void bindData(GuideHolder holder, GuideEnity data, int viewType) {
        holder.guide_title.setText(data.getName());
        holder.guide_img.setImageResource(data.getResId());
    }

    @Override
    public GuideHolder createHolder(ViewGroup parent, int viewType) {
        return new GuideHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_item,null));
    }


    public static class GuideHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.guide_img)
        ImageView guide_img;

        @BindView(R.id.guide_title)
        TextView guide_title;

        public GuideHolder(View itemView) {
            super(itemView);
        }
    }
}
