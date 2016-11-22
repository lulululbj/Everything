package luyao.everything.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import luyao.everything.utils.ScreenUtil;


/**
 * TODO
 * Created by luyao
 * on 2016/8/14 11:35
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace ;

    /**
     * @param space
     */
    public SpaceItemDecoration(int space) {
        this.mSpace = ScreenUtil.getScalePxValue(space);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        int itemCount = parent.getAdapter().getItemCount();
//        int pos = parent.getChildPosition(view);
//        Log.d(TAG, "itemCount>>" +itemCount + ";Position>>" + pos);

//        outRect.left = 0;
        outRect.top = 0;
        outRect.bottom = mSpace;

    }
}
