package luyao.everything.adapter;

import android.renderscript.ScriptGroup;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.enity.weather.FutureWeatherEnity;

/**
 * Created by Lu
 * on 2016/11/20 15:22
 */

public class FutureWeatherAdapter extends BaseRecycleViewAdapter<FutureWeatherEnity, FutureWeatherAdapter.FutureWeatherHOlder> {


    @Override
    public void bindData(FutureWeatherHOlder holder, FutureWeatherEnity data, int viewType, int position) {
            holder.future_dayWeather.setText(data.getDayTime());
        holder.future_nightWeather.setText(data.getNight());
        holder.future_weekDay.setText(data.getWeek());
        holder.future_tem.setText(data.getTemperature());
    }

    @Override
    public FutureWeatherHOlder createHolder(ViewGroup parent, int viewType) {
        return new FutureWeatherHOlder(LayoutInflater.from(parent.getContext()).inflate(R.layout.future_weather_item, null));
    }

    class FutureWeatherHOlder extends BaseRecycleViewAdapter.BaseHolder {

        @BindView(R.id.future_day_weather)
        TextView future_dayWeather;

        @BindView(R.id.future_night_weather)
        TextView future_nightWeather;

        @BindView(R.id.future_weekday)
        TextView future_weekDay;

        @BindView(R.id.future_tem)
        TextView future_tem;

        public FutureWeatherHOlder(View itemView) {
            super(itemView);
        }
    }
}
