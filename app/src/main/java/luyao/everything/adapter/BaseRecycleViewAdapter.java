package luyao.everything.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import luyao.everything.R;
import luyao.everything.utils.ScreenUtil;

/**
 * RecycleView适配器
 * Created by Lu
 * on 2016/11/14 23:24
 */

public abstract class BaseRecycleViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> mData = new ArrayList<>();

    protected OnItemClickListener onItemClickListener;
    protected View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            v.setClickable(false);
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, (Integer) v.getTag(R.id.item_position));
            }
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    v.setClickable(true);
                }
            }, 300);
        }
    };

    public BaseRecycleViewAdapter() {

    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.itemView.setTag(R.id.item_position, position);
        holder.itemView.setOnClickListener(clickListener);
        bindData(holder, mData.get(position), getItemViewType(position), position);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return createHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public abstract void bindData(VH holder, T data, int viewType, int position);

    public abstract VH createHolder(ViewGroup parent, int viewType);

    public T getItem(int position) {
        if (position < 0 || position >= mData.size()) {
            return null;
        } else {
            return mData.get(position);
        }
    }

    public void setData(List<T> list) {
        if (mData.size() > 0) mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public static class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(View itemView) {
            super(itemView);
            ScreenUtil.initScale(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
