package luyao.everything.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.area.City;

/**
 * Created by Lu
 * on 2016/11/21 15:12.
 */

public class CityAdapter extends BaseRecycleViewAdapter<City, CityAdapter.CityHolder> {

    @Override
    public void bindData(CityHolder holder, City data, int viewType, int position) {
        holder.city.setText(data.getCity());
    }

    @Override
    public CityAdapter.CityHolder createHolder(ViewGroup parent, int viewType) {
        return new CityHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city, null));
    }

    class CityHolder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.city)
        TextView city;

        public CityHolder(View itemView) {
            super(itemView);
        }
    }
}
