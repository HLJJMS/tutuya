package com.tutuya.tck.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.ProfessionalTeacherAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.TeacherListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @author  tyh
 * @功能：专家列表
 * @date 创建时间：2019/4/14
 */
public class ProfessionalTeacherListActivity extends BaseActivity {

    ProfessionalTeacherAdapter adapter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.rec)
    RecyclerView rec;
    String id;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_professional_teacher_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("专家名师");
        getIntent().getStringExtra("id");
        aboutAdapter();
        getData();
    }

    private void aboutAdapter() {
        adapter = new ProfessionalTeacherAdapter(this, getMyApplication().getWidth());
        rec.setLayoutManager(new GridLayoutManager(this, 2));
        rec.setAdapter(adapter);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


    private void getData() {
        Call<TeacherListBean> call = inter.getTeacherList("course/get_course_lecturer", getMyApplication().getToken(), "50", "1","1");
        call.enqueue(new Callback<TeacherListBean>() {
            @Override
            public void onResponse(Call<TeacherListBean> call, Response<TeacherListBean> response) {
                if (response.body().getErrorcode() == 200) {
                    adapter.setData(response.body().getData().getData());
                }
            }

            @Override
            public void onFailure(Call<TeacherListBean> call, Throwable t) {

            }
        });
    }

}
