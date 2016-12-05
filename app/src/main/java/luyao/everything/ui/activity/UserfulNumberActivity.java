package luyao.everything.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.adapter.BaseRecycleViewAdapter;
import luyao.everything.adapter.NumAdapter;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.NumberEnity;
import luyao.everything.utils.Constants;
import luyao.everything.utils.FileUtils;

/**
 * 号码分类列表
 * Created by Lu
 * on 2016/11/24 10:19.
 */

public class UserfulNumberActivity extends BaseActivity {

    @BindView(R.id.numberRecycle)
    RecyclerView numRecycle;

    private NumAdapter numAdapter;
    private List<NumberEnity> numberEnityList = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_userful_number;
    }

    @Override
    protected void initView() {
        title_tv.setText(R.string.userful_number);
        numRecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if (numAdapter == null) numAdapter = new NumAdapter();
        numRecycle.setAdapter(numAdapter);

        numAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(UserfulNumberActivity.this, NumberDetailActivity.class).putExtra(Constants.NUMBERENITY, numberEnityList.get(position)));
                overridePendingTransition(R.anim.slide_in_form_right, R.anim.slide_out_to_left);
            }
        });
    }

    @Override
    protected void initData() {
        String json = FileUtils.getAssetsFile(getApplicationContext(), "number");
        numberEnityList = new Gson().fromJson(json, new TypeToken<List<NumberEnity>>() {
        }.getType());
        for (NumberEnity numberEnity : numberEnityList) {
            numberEnity.setResId(R.mipmap.ic_launcher);
        }
        numAdapter.setData(numberEnityList);
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
