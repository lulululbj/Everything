package luyao.everything.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.adapter.GuideAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;

/**
 * 引导用户选择需要的服务
 * Created by Lu
 * on 2016/11/14 18:56.
 */

public class GuideActivity extends BaseActivity {

    @BindView(R.id.guideRecycleView)
    RecyclerView guideRecycleView;

    private List<GuideEnity> guideEnities = new ArrayList<>();
    private GuideAdapter guideAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        guideRecycleView.setLayoutManager(new GridLayoutManager(mContext, 3));
        if (guideAdapter == null) guideAdapter = new GuideAdapter();
        guideRecycleView.setAdapter(guideAdapter);
    }

    @Override
    protected void setListener() {
        GuideEnity guideEnity = new GuideEnity();
        guideEnity.setName("天气预报");
        guideEnity.setResId(R.mipmap.ic_launcher);
        guideEnities.add(guideEnity);
        guideAdapter.setData(guideEnities);
    }
}
