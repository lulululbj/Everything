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
    private int[] IDs = {R.drawable.service_express, R.drawable.service_food, R.drawable.service_entertainmenticon, R.drawable.service_hotel,
            R.drawable.service_bank, R.drawable.service_driving, R.drawable.service_ticket, R.drawable.service_insurance, R.drawable.service_game,
            R.drawable.service_brand, R.drawable.service_health, R.drawable.service_appliance, R.drawable.service_car, R.drawable.service_hot_line};

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_userful_number;
    }

    @Override
    protected void initView() {
        title_tv.setText(R.string.userful_number);
        numRecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        numRecycle.addItemDecoration(new LinearItemDecoration(mContext, LinearItemDecoration.VERTICAL_LIST));
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
        for (int i = 0; i < numberEnityList.size(); i++) {
            numberEnityList.get(i).setResId(IDs[i]);
        }
        numAdapter.setData(numberEnityList);
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }
}
