package luyao.everything.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import luyao.everything.R;
import luyao.everything.base.BaseFragmentActivity;
import luyao.everything.ui.fragment.LeftFragment;
import luyao.everything.ui.fragment.MainFragment;

/**
 * 主页
 * Created by Lu
 * on 2016/12/1 22:27
 */

public class MenuActivity extends BaseFragmentActivity {

//
//    @BindView(R.id.drawerLayout)
//    DrawerLayout mDrawerLayout;

    private MainFragment mainFragment;
    private LeftFragment leftFragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_menu;
    }

    @Override
    protected void initView() {
        if (mainFragment==null)mainFragment=new MainFragment();
        if (leftFragment==null)leftFragment=new LeftFragment();
    }

    @Override
    protected void initData() {
        shwowFragment(mainFragment,R.id.main_content);
        shwowFragment(leftFragment,R.id.left_content);
    }

    private void shwowFragment(Fragment fragment,int resId){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded())transaction.add(resId,fragment);
        transaction.commit();
    }
}
