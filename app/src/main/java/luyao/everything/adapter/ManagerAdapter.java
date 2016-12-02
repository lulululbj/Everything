package luyao.everything.adapter;

import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.GuideEnity;

/**
 * 服务管理
 * Created by Lu
 * on 2016/12/2 14:45.
 */

public class ManagerAdapter extends BaseRecycleViewAdapter<GuideEnity, ManagerAdapter.ManagerHolder> {


    @Override
    public void bindData(ManagerHolder holder, final GuideEnity data, int viewType, int position) {
        holder.manager_img.setImageResource(data.getResId());
        holder.manager_service.setText(data.getName());
        holder.manager_switch.setChecked(data.isSelected());

        holder.manager_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                data.setSelected(b);
            }
        });
    }

    @Override
    public ManagerHolder createHolder(ViewGroup parent, int viewType) {
        return new ManagerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.manager_item, null));
    }

    class ManagerHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.manager_img)
        ImageView manager_img;
        @BindView(R.id.manager_service)
        TextView manager_service;
        @BindView(R.id.manager_switch)
        SwitchCompat manager_switch;

        public ManagerHolder(View itemView) {
            super(itemView);
        }
    }

    public List<GuideEnity> getList(){
        return mData;
    }
}
