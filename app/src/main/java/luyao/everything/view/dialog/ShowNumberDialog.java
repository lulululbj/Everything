package luyao.everything.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import luyao.everything.R;
import luyao.everything.enity.NumberEnity;
import luyao.everything.utils.Util;

/**
 * Created by Lu
 * on 2016/11/24 15:41.
 */

public class ShowNumberDialog extends BaseDialog {

    @BindView(R.id.img_call1)
    ImageView img_call1;
    @BindView(R.id.img_call2)
    ImageView img_call2;
    @BindView(R.id.tv_name1)
    TextView tv_name1;
    @BindView(R.id.tv_name2)
    TextView tv_name2;
    @BindView(R.id.tv_num1)
    TextView tv_num1;
    @BindView(R.id.tv_num2)
    TextView tv_num2;
    @BindView(R.id.tv_brand)
    TextView tv_brand;
    @BindView(R.id.rl_num1)
    RelativeLayout rl_num1;
    @BindView(R.id.rl_num2)
    RelativeLayout rl_num2;

    private NumberEnity.NumberDetail numberDetail;

    public ShowNumberDialog(Context context, int themeId) {
        super(context, themeId);
    }

    public ShowNumberDialog(Context context, int themeId, NumberEnity.NumberDetail numberDetail) {
        this(context, themeId);
        this.numberDetail = numberDetail;
        setData();
    }

    @Override
    protected int getResId() {
        return R.layout.show_number_dialog;
    }

    @Override
    protected void initData() {

    }

    private void setData() {

        tv_brand.setText(numberDetail.getBrand());

        String name1 = numberDetail.getName1();
        String name2 = numberDetail.getName2();

        if (!TextUtils.isEmpty(name1)) {
            rl_num1.setVisibility(View.VISIBLE);
            tv_name1.setText(name1);
            tv_num1.setText(numberDetail.getNumber1());
        } else {
            rl_num1.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(name2)) {
            rl_num2.setVisibility(View.VISIBLE);
            tv_name2.setText(name2);
            tv_num2.setText(numberDetail.getNumber2());
        } else {
            rl_num2.setVisibility(View.GONE);
        }


    }

    @OnClick(R.id.img_call1)
    public void call1() {
        Util.callPhone(getContext(), tv_num1.getText().toString().replace(" ", ""));
    }

    @OnClick(R.id.img_call2)
    public void call2() {
        Util.callPhone(getContext(), tv_num2.getText().toString().replace(" ", ""));
    }
}
