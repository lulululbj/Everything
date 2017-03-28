package luyao.everything.ui.activity;

import android.view.View;

import java.io.Serializable;
import java.util.List;

import luyao.everything.EverythingApplication;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.ProvinceAdapter;
import luyao.everything.base.BaseChooseActivity;
import luyao.everything.enity.area.Province;
import luyao.everything.utils.Constants;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.PreferencesUtils;
import luyao.everything.utils.ToastUtil;

/**
 * Created by Lu
 * on 2016/11/21 14:51.
 */

public class ChooseProvinceActivity extends BaseChooseActivity<Province> {

    private ProvinceAdapter provinceAdapter;

    @Override
    protected void initView() {
        super.initView();
        ToastUtil.showToast("选择您的城市");
    }

    @Override
    protected void initData() {

        if (provinceAdapter == null) provinceAdapter = new ProvinceAdapter();
        chooseRecycler.setAdapter(provinceAdapter);
        provinceAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PreferencesUtils.set(PreferencesUtils.PROVINCE, dataList.get(position).getProvince());
                PreferencesUtils.set(PreferencesUtils.HAS_USER_CHOSED, true);
                EverythingApplication.mACache.put(Constants.CITY, (Serializable) dataList.get(position).getCity());
                startActivity(ChooseCityActivity.class);
            }
        });

        List<Province> provinceList = (List<Province>) EverythingApplication.mACache.getAsObject(Constants.CITY_LIST);
        if (provinceList != null) {
            LogUtils.e("weather", provinceList.size() + "");
            setDataList(provinceList);
            provinceAdapter.setData(dataList);
        }

    }


    @Override
    protected void clickBack() {
        super.clickBack();
        onBackPressed();
    }
}
