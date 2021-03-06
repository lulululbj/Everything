package luyao.everything.ui.activity;

import android.view.View;


import java.util.List;

import luyao.everything.EverythingApplication;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.DistrictAdapter;
import luyao.everything.base.BaseChooseActivity;
import luyao.everything.enity.area.District;
import luyao.everything.message.ChooseMessage;
import luyao.everything.utils.Constants;
import luyao.everything.utils.PreferencesUtils;
import luyao.everything.utils.RxBus;

/**
 * Created by Lu
 * on 2016/11/21 17:23.
 */

public class ChooseDistrictActivity extends BaseChooseActivity<District> {
    private DistrictAdapter districtAdapter;

    @Override
    protected void initData() {
        super.initData();

        if (districtAdapter == null) districtAdapter = new DistrictAdapter();
        chooseRecycler.setAdapter(districtAdapter);

        districtAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                PreferencesUtils.set(PreferencesUtils.DISTRICT, dataList.get(position).getDistrict());

                RxBus.getDefault().post(new ChooseMessage());
                startActivity(WeatherActivity.class);
                finish();
            }
        });

        List<District> districtList = (List<District>) EverythingApplication.mACache.getAsObject(Constants.DISTRICT);
        setDataList(districtList);
        districtAdapter.setData(dataList);

    }

    @Override
    protected void clickBack() {
        super.clickBack();
        onBackPressed();
    }
}
