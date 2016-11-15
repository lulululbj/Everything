package luyao.everything.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.adapter.GuideAdapter;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.GuideEnity;
import luyao.everything.enity.weather.WeatherEnity;
import luyao.everything.utils.ToastUtils;
import rx.Subscriber;


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
    }

    @Override
    protected void setListener() {
        GuideEnity guideEnity = new GuideEnity();
        guideEnity.setName("天气预报");
        guideEnity.setResId(R.mipmap.ic_launcher);

        GuideEnity guideEnity1 = new GuideEnity();
        guideEnity1.setName("天气预报");
        guideEnity1.setResId(R.mipmap.ic_launcher);

        GuideEnity guideEnity2 = new GuideEnity();
        guideEnity2.setName("天气预报");
        guideEnity2.setResId(R.mipmap.ic_launcher);

        GuideEnity guideEnity3 = new GuideEnity();
        guideEnity3.setName("天气预报");
        guideEnity3.setResId(R.mipmap.ic_launcher);

        GuideEnity guideEnity4 = new GuideEnity();
        guideEnity4.setName("天气预报");
        guideEnity4.setResId(R.mipmap.ic_launcher);
        guideEnities.add(guideEnity);
        guideEnities.add(guideEnity1);
        guideEnities.add(guideEnity2);
        guideEnities.add(guideEnity3);
        guideEnities.add(guideEnity4);

        guideAdapter.setData(guideEnities);

        Subscriber<List<WeatherEnity>> subscriber = new BaseSubscriber<List<WeatherEnity>>() {

            @Override
            public void onNext(List<WeatherEnity> listHttpResult) {
                Toast.makeText(getApplicationContext(), listHttpResult.get(0).getCity(), Toast.LENGTH_LONG).show();
            }
        };
        Api.getInstance().getWeather(subscriber, "南京", "江苏");
    }

    @OnClick({R.id.guide_confirm})
    public void onClick(){
        ToastUtils.showToast(guideAdapter.getSelect().size()+"");
    }
}
