package luyao.everything.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.MainAdapter;
import luyao.everything.base.BaseFragment;
import luyao.everything.enity.GuideEnity;
import luyao.everything.utils.Constants;
import luyao.everything.view.MainItemTouchHelperCallBack;

/**
 * 主页面Fragment
 * Created by Lu
 * on 2016/12/1 22:33
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.mainRecycleView)
    RecyclerView mainRecycleView;

    private MainAdapter mainAdapter;
    private List<GuideEnity> guideEnities = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        mainRecycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        if (mainAdapter == null) mainAdapter = new MainAdapter();
        mainRecycleView.setAdapter(mainAdapter);
        MainItemTouchHelperCallBack callBack = new MainItemTouchHelperCallBack(mainAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(mainRecycleView);
    }

    @Override
    protected void initData() {
        guideEnities = (List<GuideEnity>) EverythingApplication.mACache.getAsObject(Constants.SELECT_GUIDES);
        if (guideEnities == null) guideEnities = new ArrayList<>();
        mainAdapter.setData(guideEnities);

        mainAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(guideEnities.get(position).getZ());
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        //存储用户拖动后的集合
        List<GuideEnity> guideEnityList = mainAdapter.getAllList();
        EverythingApplication.mACache.put(Constants.SELECT_GUIDES, (Serializable) guideEnityList);
    }

}