package luyao.everything.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.adapter.GuideAdapter;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.api.SubscriberOnNextListener;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.enity.HttpResult;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.utils.LogUtils;


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
    private SubscriberOnNextListener getWeatherNext;

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

        getWeatherNext=new SubscriberOnNextListener<HttpResult<List<WeatherEnity>>>(){

            @Override
            public void onNext(HttpResult<List<WeatherEnity>> listHttpResult) {
                Toast.makeText(getApplicationContext(), listHttpResult.getMsg() + "//" + listHttpResult.getRetCode(), Toast.LENGTH_LONG).show();
                LogUtils.e(listHttpResult.getMsg() + "//" + listHttpResult.getRetCode());
            }
        };


//        Subscriber<HttpResult<List<WeatherEnity>>> subscriber = new Subscriber<HttpResult<List<WeatherEnity>>>() {
//            @Override
//            public void onCompleted() {
//                LogUtils.e("onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtils.e("onERROR " + e.getMessage());
//            }
//
//            @Override
//            public void onNext(HttpResult<List<WeatherEnity>> listHttpResult) {
//                Toast.makeText(getApplicationContext(), listHttpResult.getMsg() + "//" + listHttpResult.getRetCode(), Toast.LENGTH_LONG).show();
//                LogUtils.e(listHttpResult.getMsg() + "//" + listHttpResult.getRetCode());
//            }
//        };
        Api.getInstance().getWeather(new BaseSubscriber(getWeatherNext), "南京", "江苏");
    }
}
