package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.area.District;
import luyao.everything.enity.area.Province;

/**
 * Created by Lu
 * on 2016/11/21 15:16.
 */

public class DistrictAdapter extends BaseRecycleViewAdapter<District, DistrictAdapter.DistrictHolder> {


    @Override
    public void bindData(DistrictHolder holder, District data, int viewType, int position) {
        holder.city.setText(data.getDistrict());
    }

    @Override
    public DistrictHolder createHolder(ViewGroup parent, int viewType) {
        return new DistrictHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city, null));
    }

    class DistrictHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.city)
        TextView city;

        public DistrictHolder(View itemView) {
            super(itemView);
        }
    }

}
