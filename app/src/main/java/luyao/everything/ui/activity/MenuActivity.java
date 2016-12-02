package luyao.everything.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
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


    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.left_content)
    FrameLayout left_content;
    @BindView(R.id.main_content)
    FrameLayout main_content;

    private MainFragment mainFragment;
    private LeftFragment leftFragment;
    private int mDrawerWidth;//抽屉全部拉出来时的宽度
    private float scrollWidth;//抽屉被拉出部分的宽度

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_menu;
    }

    @Override
    protected void initView() {
        if (mainFragment==null)mainFragment=new MainFragment();
        if (leftFragment==null)leftFragment=new LeftFragment();

        initDrawerLayout();
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

    private void initDrawerLayout(){
        measureView(left_content);
        mDrawerWidth = left_content.getMeasuredWidth();

        mDrawerLayout.setScrimColor(0x00ffffff);
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //因为arg1的范围是0.0-1.0，是一个相对整个抽屉宽度的比例
                //所以要准换成
                scrollWidth = slideOffset * mDrawerWidth;
                //setScroll中的参数，正数表示向左移动，负数向右
                main_content.setScrollX((int) (-1 * scrollWidth));
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    /**
     * 此方法可以多次被不同的View对象调用。
     * 在调用该方法后，
     * 使用View对象的getMessuredHeight()获高度（单位px）
     *
     * @param child 需要测量高度和宽度的View对象，
     */
    private void measureView(View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0,
                params.width);
        int lpHeight = params.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight,
                    View.MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0,
                    View.MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    public  void openMenu(){
        if (mDrawerLayout.isDrawerOpen(left_content)){
            mDrawerLayout.closeDrawer(left_content);
        }else {
            mDrawerLayout.openDrawer(left_content);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(left_content)){
            mDrawerLayout.closeDrawer(left_content);
        }else {
            super.onBackPressed();
        }

    }
}
