package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.GuideEnity;

/**
 * Created by Lu
 * on 2016/11/16 13:16.
 */

public class MainAdapter extends BaseRecycleViewAdapter<GuideEnity, MainAdapter.MainHolder> implements OnMoveListener{


    @Override
    public void bindData(MainHolder holder, GuideEnity data, int viewType, int position) {
        if (data.isSelected()){
            holder.main_img.setImageResource(data.getResId());
            holder.main_tv.setText(data.getName());
        }
    }

    @Override
    public MainHolder createHolder(ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, null));
    }

    @Override
    public boolean onItemMove(int fromPostion, int toPosition) {
        Collections.swap(mData,fromPostion,toPosition);
        notifyItemMoved(fromPostion,toPosition);
        return true;
    }

    static class MainHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.main_img)
        ImageView main_img;

        @BindView(R.id.main_tv)
        TextView main_tv;

        public MainHolder(View itemView) {
            super(itemView);
        }
    }

    public List<GuideEnity> getAllList(){
        return mData;
    }
}
