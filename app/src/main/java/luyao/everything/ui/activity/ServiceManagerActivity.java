package luyao.everything.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.EverythingApplication;
import luyao.everything.adapter.ManagerAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.utils.Constants;
import luyao.everything.R;

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
        super.onBackPressed();
        List<Integer> ints = new ArrayList<>();
        List<GuideEnity> allList = managerAdapter.getList();
        List<GuideEnity> newList2 = new ArrayList<>();
        List<GuideEnity> selectList = (List<GuideEnity>) EverythingApplication.mACache.getAsObject(Constants.SELECT_GUIDES);
        List<GuideEnity> newList = new ArrayList<>();
        if (selectList != null && allList != null) {
//            for (GuideEnity guideEnity : selectList) {//为保证顺序，先取出已选列表中仍选择的，再取出新增加的
//                for (GuideEnity guideEnity1 : allList) {
//                    if (guideEnity.getName().equals(guideEnity1.getName())) {
//                        if (guideEnity1.isSelected()) newList.add(guideEnity1);
//                    }
//                }
//            }

            for (int i = 0; i < selectList.size(); i++) {
                for (int j = 0; j < allList.size(); j++) {
                    if (selectList.get(i).getName().equals(allList.get(j).getName())) {
                        if (allList.get(j).isSelected()) {
                            newList.add(allList.get(j));
                            ints.add(j);
                        }
                    }
                }
            }

            EverythingApplication.mACache.put(Constants.ALL_GUIDES, (Serializable) allList);

            for (int i=ints.size();i>0;i--){
                allList.remove(i);
            }

            for (GuideEnity guideEnity : allList) {
                boolean hasAdd = false;
                for (GuideEnity guideEnity1 : newList) {
                    if (!guideEnity.getName().equals(guideEnity1.getName()) && guideEnity.isSelected()) {
                        if (!hasAdd) {
                            newList2.add(guideEnity);
                            hasAdd = true;
                        }
                    }
                }
            }
            newList.addAll(newList2);
            EverythingApplication.mACache.put(Constants.SELECT_GUIDES, (Serializable) newList);

        }
    }
}
