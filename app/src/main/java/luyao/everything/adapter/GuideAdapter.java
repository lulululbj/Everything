package luyao.everything.adapter;

import android.os.Handler;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.GuideEnity;

/**
 * Created by Lu
 * on 2016/11/15 11:02.
 */

public class GuideAdapter extends BaseRecycleViewAdapter<GuideEnity, GuideAdapter.GuideHolder> {

    @Override
    public void bindData(GuideHolder holder, final GuideEnity data, int viewType, final int position) {
        holder.guide_title.setText(data.getName());
        holder.guide_checkbox.setChecked(data.isSelected());

        holder.guide_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mData.get(position).setSelected(b);
            }
        });

    }

    @Override
    public GuideHolder createHolder(ViewGroup parent, int viewType) {
        return new GuideHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_item, null));
    }

    public List<GuideEnity> getSelect() {
        List<GuideEnity> selectList = new ArrayList<>();
        for (GuideEnity guideEnity : mData) {
            if (guideEnity.isSelected()) selectList.add(guideEnity);
        }
        return selectList;
    }


    public static class GuideHolder extends BaseRecycleViewAdapter.BaseHolder {


        @BindView(R.id.guide_title)
        TextView guide_title;

        @BindView(R.id.guide_checkbox)
        AppCompatCheckBox guide_checkbox;

        public GuideHolder(View itemView) {
            super(itemView);
        }
    }
}
