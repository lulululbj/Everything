package luyao.everything.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.CheckBox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.ManagerAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.utils.Constants;
import luyao.everything.utils.RxBus;
import luyao.everything.view.MainItemTouchHelperCallBack;

/**
 * 服务管理
 * Created by Lu
 * on 2016/12/2 14:38.
 */

public class ServiceManagerActivity extends BaseActivity {

    @BindView(R.id.managerRecycle)
    RecyclerView managerRecycle;

    private ManagerAdapter managerAdapter;
    private List<GuideEnity> guideEnityList = new ArrayList<>();
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_service_manager;
    }

    @Override
    protected void initView() {
        title_tv.setText(getString(R.string.manager_services));
        managerRecycle.setLayoutManager(new LinearLayoutManager(this));
        if (managerAdapter == null) managerAdapter = new ManagerAdapter();
        managerRecycle.setAdapter(managerAdapter);


        MainItemTouchHelperCallBack callBack = new MainItemTouchHelperCallBack(managerAdapter);
        itemTouchHelper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(managerRecycle);
    }

    @Override
    protected void initData() {
        guideEnityList = (List<GuideEnity>) EverythingApplication.mACache.getAsObject(Constants.ALL_GUIDES);
        if (guideEnityList != null && guideEnityList.size() > 0)
            managerAdapter.setData(guideEnityList);
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {

        List<GuideEnity> allList = managerAdapter.getList();
        List<GuideEnity> selectList = new ArrayList<>();
        List<GuideEnity> unSelectList = new ArrayList<>();

        for (GuideEnity guideEnity : allList) {
            if (guideEnity.isSelected()) {
                selectList.add(guideEnity);
            } else {
                unSelectList.add(guideEnity);
            }
        }
        EverythingApplication.mACache.put(Constants.SELECT_GUIDES, (Serializable) selectList);
        EverythingApplication.mACache.put(Constants.ALL_GUIDES, (Serializable) allList);

        RxBus.getDefault().post(Constants.MESSAGE_REFRESH_GUIDE);
        super.onBackPressed();
    }

}
