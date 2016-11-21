package luyao.everything.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.MainAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.utils.Constants;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mainRecycleView)
    RecyclerView mainRecycleView;

    private MainAdapter mainAdapter;
    private List<GuideEnity> guideEnities=new ArrayList<>();


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mainRecycleView.setLayoutManager(new GridLayoutManager(mContext, 3));
        if (mainAdapter == null) mainAdapter = new MainAdapter();
        mainRecycleView.setAdapter(mainAdapter);
    }

    @Override
    protected void initData() {

        guideEnities= (List<GuideEnity>) EverythingApplication.mACache.getAsObject(Constants.SELECT_GUIDES);
        if (guideEnities==null)guideEnities=new ArrayList<>();
        mainAdapter.setData(guideEnities);

        mainAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(guideEnities.get(position).getZ());
            }
        });

    }


}
