package luyao.everything.ui.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.adapter.GuideAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.utils.Constants;
import luyao.everything.utils.ToastUtil;
import luyao.everything.utils.Util;


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
        guideRecycleView.setLayoutManager(new GridLayoutManager(mContext, 2));
        if (guideAdapter == null) guideAdapter = new GuideAdapter();
        guideRecycleView.setAdapter(guideAdapter);
        showSnackBar();
    }

    @Override
    protected void setListener() {

        guideAdapter.setData(Util.getAllGuide(getApplicationContext()));

//        Subscriber<List<WeatherEnity>> subscriber = new BaseSubscriber<List<WeatherEnity>>() {
//
//            @Override
//            public void onNext(List<WeatherEnity> listHttpResult) {
//                Toast.makeText(getApplicationContext(), listHttpResult.get(0).getCity(), Toast.LENGTH_LONG).show();
//            }
//        };
//        Api.getInstance().getWeather(subscriber, "南京", "江苏");
    }

    @OnClick({R.id.guide_confirm})
    public void onClick(){

        List<GuideEnity> guideEnities=guideAdapter.getSelect();
        if (guideEnities==null || guideEnities.size()==0){
            ToastUtil.showToast("请选择您感兴趣的服务");
        }else {
            EverythingApplication.mACache.put(Constants.SELECT_GUIDES, (Serializable) guideEnities);
            startActivity(MainActivity.class);
        }

    }

    @Override
    protected void clickBack() {
        finish();
    }

    private void showSnackBar(){
        Snackbar.make(guideRecycleView,"Choose Service",Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();
    }
}
