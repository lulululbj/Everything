package luyao.everything.ui.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.GuideAdapter;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.utils.Constants;
import luyao.everything.utils.ToastUtil;
import luyao.everything.utils.Util;
import rx.Subscriber;


/**
 * 引导用户选择需要的服务
 * Created by Lu
 * on 2016/11/14 18:56.
 */

public class GuideActivity extends BaseActivity {

    @BindView(R.id.guideRecycleView)
    RecyclerView guideRecycleView;

    private GuideAdapter guideAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        title_back.setVisibility(View.GONE);
        title_right.setVisibility(View.VISIBLE);
        title_right.setText(R.string.finish);
        guideRecycleView.setLayoutManager(new GridLayoutManager(mContext, 2));
        if (guideAdapter == null) guideAdapter = new GuideAdapter();
        guideRecycleView.setAdapter(guideAdapter);
        showSnackBar();
    }

    @Override
    protected void initData() {

        guideAdapter.setData(Util.getAllGuide(getApplicationContext()));
    }

    @Override
    protected void clickBack() {
        finish();
    }

    @Override
    protected void clickRight() {
        next();
    }

    private void showSnackBar() {
        Snackbar.make(guideRecycleView, "Choose Service", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        }).show();
    }

    /**
     * 存储用户选择的服务
     */
    private void next() {
        List<GuideEnity> guideEnities = guideAdapter.getSelect();
        if (guideEnities == null || guideEnities.size() == 0) {
            ToastUtil.showToast("请选择您感兴趣的服务");
        } else {
            EverythingApplication.mACache.put(Constants.SELECT_GUIDES, (Serializable) guideEnities);
            EverythingApplication.mACache.put(Constants.ALL_GUIDES, (Serializable) guideAdapter.getAll());
            startActivity(MainActivity.class);
            finish();
        }
    }
}
