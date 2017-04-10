package luyao.everything.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;
import luyao.everything.R;
import luyao.everything.utils.ScreenUtil;

/**
 * Dialog基类
 * Created by Lu
 * on 2016/11/24 15:20.
 */

public abstract class BaseDialog extends Dialog {

    protected Context mContext;

    public BaseDialog(Context context) {
        super(context, R.style.dialog);
    }

    public BaseDialog(Context context, int themeId) {
        super(context, themeId);
        this.mContext = context;
        this.setCanceledOnTouchOutside(true);
        View contentView = getLayoutInflater().inflate(getResId(), null);
        ScreenUtil.initScale(contentView);
        setContentView(contentView);
        ButterKnife.bind(this, contentView);
        initData();
    }

    protected abstract int getResId();

    protected abstract void initData();
}
