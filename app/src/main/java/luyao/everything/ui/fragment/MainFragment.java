package luyao.everything.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.MainAdapter;
import luyao.everything.base.BaseFragment;
import luyao.everything.enity.GuideEnity;
import luyao.everything.ui.activity.MenuActivity;
import luyao.everything.utils.Constants;
import luyao.everything.utils.RxBus;
import rx.Subscription;
import rx.functions.Action1;

/**
 * 主页面Fragment
 * Created by Lu
 * on 2016/12/1 22:33
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.mainRecycleView)
    RecyclerView mainRecycleView;
    @BindView(R.id.title_back)
    ImageView title_back;

    private MainAdapter mainAdapter;
    private List<GuideEnity> guideEnities = new ArrayList<>();
    private  Subscription rxSubscription;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        title_back.setImageResource(R.drawable.menu);
        mainRecycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        if (mainAdapter == null) mainAdapter = new MainAdapter();
        mainRecycleView.setAdapter(mainAdapter);


        rxSubscription= RxBus.getDefault().toObservable(Integer.class)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                       mainAdapter.setData((List<GuideEnity>) EverythingApplication.mACache.getAsObject(Constants.SELECT_GUIDES));
                    }
                });

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


    @OnClick({R.id.title_back})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                ((MenuActivity) getActivity()).openMenu();
                break;
        }
    }

}
