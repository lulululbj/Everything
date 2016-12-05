package luyao.everything.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.EverythingApplication;
import luyao.everything.R;
import luyao.everything.base.BaseFragment;
import luyao.everything.ui.activity.AboutActivity;
import luyao.everything.ui.activity.ServiceManagerActivity;
import luyao.everything.utils.Util;

import static luyao.everything.R.styleable.View;

/**
 * 侧边栏Fragment
 * Created by Lu
 * on 2016/12/1 22:38
 */


public class LeftFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_left;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_service, R.id.rl_share, R.id.rl_about, R.id.rl_exit, R.id.rl_praise})
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.rl_service:
                startActivity(ServiceManagerActivity.class);
                break;
            case R.id.rl_share:
                Util.share(getActivity());
                break;
            case R.id.rl_about:
                startActivity(AboutActivity.class);
                break;
            case R.id.rl_praise:
                Util.givePraise(getActivity());
                break;
            case R.id.rl_exit:
                for (Activity activity : EverythingApplication.activities) activity.finish();
                break;
        }
    }
}
