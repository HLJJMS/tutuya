package com.tutuya.tck.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.CourseRecommendationAdapter;
import com.tutuya.tck.adapter.education.ClassingListAdapter;
import com.tutuya.tck.adapter.home.HomeClassingAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.HomeClassingNewBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @author  tyh
 * @功能：课程推荐列表
 * @date 创建时间：2019/4/14
 */
public class CourseRecommendationListActivity extends BaseActivity {

    @BindView(R.id.r0)
    RadioButton r0;
    @BindView(R.id.r1)
    RadioButton r1;
    @BindView(R.id.r2)
    RadioButton r2;
    @BindView(R.id.r3)
    RadioButton r3;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.r11)
    RadioButton r11;
    @BindView(R.id.r10)
    RadioButton r10;
    @BindView(R.id.group1)
    RadioGroup group1;
    @BindView(R.id.rec)
    RecyclerView rec;
    HomeClassingAdapter adapter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    Context context;
    String token;
    @OnClick({R.id.r0, R.id.r1, R.id.r2, R.id.r11, R.id.r3, R.id.r10, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.r0:
                group1.clearCheck();
                break;
            case R.id.r1:
                group1.clearCheck();
                break;
            case R.id.r2:
                group1.clearCheck();
                break;
            case R.id.r3:
                group1.clearCheck();
                break;
            case R.id.r11:
                group.clearCheck();
                break;
            case R.id.r10:
                group.clearCheck();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_course_recommendation_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        token = getMyApplication().getToken();
        adapter = new HomeClassingAdapter(this);
        rec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rec.setAdapter(adapter);

        getClassTwo("");
    }

    public void getClassTwo(String id) {
        Call<HomeClassingNewBean> call = inter.getHomeClassingList("course/get_cate_theme",token,"50","1",id);
        call.enqueue(new Callback<HomeClassingNewBean>() {
            @Override
            public void onResponse(Call<HomeClassingNewBean> call, Response<HomeClassingNewBean> response) {
                if (response.body().getErrorcode()==200){
                  adapter.setData(response.body().getData().getData());
                }


            }

            @Override
            public void onFailure(Call<HomeClassingNewBean> call, Throwable t) {

            }
        });



    }
}
