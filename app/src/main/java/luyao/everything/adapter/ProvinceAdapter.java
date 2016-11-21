package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.area.Province;

/**
 * Created by Lu
 * on 2016/11/21 15:05.
 */

public class ProvinceAdapter extends BaseRecycleViewAdapter<Province, ProvinceAdapter.ProvinceHolder> {


    @Override
    public void bindData(ProvinceHolder holder, Province data, int viewType, int position) {
        holder.city.setText(data.getProvince());
    }

    @Override
    public ProvinceHolder createHolder(ViewGroup parent, int viewType) {
        return new ProvinceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city, null));
    }

    class ProvinceHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.city)
        TextView city;

        public ProvinceHolder(View itemView) {
            super(itemView);
        }
    }
}
