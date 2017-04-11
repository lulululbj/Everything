package luyao.everything.ui.activity.weather;

import android.view.View;

import java.io.Serializable;
import java.util.List;

import luyao.everything.EverythingApplication;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.CityAdapter;
import luyao.everything.base.BaseChooseActivity;
import luyao.everything.enity.area.City;
import luyao.everything.utils.Constants;
import luyao.everything.utils.PreferencesUtils;

/**
 * Created by Lu
 * on 2016/11/21 15:48.
 */

public class ChooseCityActivity extends BaseChooseActivity<City> {

    private CityAdapter cityAdapter;

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        if (cityAdapter == null) cityAdapter = new CityAdapter();
        chooseRecycler.setAdapter(cityAdapter);
        cityAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PreferencesUtils.set(PreferencesUtils.CITY, dataList.get(position).getCity());
                EverythingApplication.mACache.put(Constants.DISTRICT, (Serializable) dataList.get(position).getDistrict());
                startActivity(ChooseDistrictActivity.class);
            }
        });

        List<City> cityList = (List<City>) EverythingApplication.mACache.getAsObject(Constants.CITY);
        setDataList(cityList);
        cityAdapter.setData(dataList);
    }

    @Override
    protected void clickBack() {
        super.clickBack();
        onBackPressed();
    }
}
