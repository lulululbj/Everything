package luyao.everything.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import luyao.everything.R;
import luyao.everything.utils.ScreenUtil;

/**
 * 基类Fragment
 * Created by Lu
 * on 2016/11/30 19:59.
 */

public abstract class BaseFragment extends Fragment {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getLayoutResId(), container, false);
            ScreenUtil.initScale(mView);
            ButterKnife.bind(this, mView);
            initView();
            initData();

        }
        return mView;
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData();

    protected void startActivity(Class z) {
        startActivity(new Intent(getActivity(), z));
        getActivity().overridePendingTransition(R.anim.slide_in_form_right, R.anim.slide_out_to_left);
    }

}
