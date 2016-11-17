package luyao.everything.adapter;

import android.os.Handler;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.enity.GuideEnity;

/**
 * Created by Lu
 * on 2016/11/15 11:02.
 */

public class GuideAdapter extends BaseRecycleViewAdapter<GuideEnity, GuideAdapter.GuideHolder> {

    private Handler mHandler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            notifyDataSetChanged();
        }
    };

    @Override
    public void bindData(final GuideHolder holder, final GuideEnity data, int viewType, final int position) {
        holder.guide_bt.setText(data.getName());
        holder.guide_bt.setBackgroundResource(data.isSelected() ? R.drawable.guide_item_bg_selected : R.drawable.guide_item_bg_normal);
        holder.guide_bt.setTextColor(data.isSelected()? EverythingApplication.CONTEXT.getResources().getColor(R.color.guide_bg_selected):
                EverythingApplication.CONTEXT.getResources().getColor(R.color.guide_bg_normal));
        holder.guide_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setSelected(!data.isSelected());
                mHandler.post(runnable);
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

    public List<GuideEnity> getAll() {

        return mData;
    }


    public static class GuideHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.guide_bt)
        Button guide_bt;


        public GuideHolder(View itemView) {
            super(itemView);
        }
    }
}
