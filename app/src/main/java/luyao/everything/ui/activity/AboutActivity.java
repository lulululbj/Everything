package luyao.everything.ui.activity;

import android.graphics.Paint;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.base.BaseActivity;
import luyao.everything.utils.ToastUtil;
import luyao.everything.utils.Util;

/**
 * Created by Lu
 * on 2016/12/2 23:23
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.about_qq)
    TextView about_qq;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        title_tv.setText(getString(R.string.about));
        about_qq.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.about_qq})
    public void onClick() {
        Util.copy(about_qq.getText().toString(), getApplicationContext());
        ToastUtil.showToast("已为您复制到剪切板");
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
