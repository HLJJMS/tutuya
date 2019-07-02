package com.tutuya.tck.activity.Education;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.education.ClassingListAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.FiveEducationOneListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationOneListActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.rec)
    RecyclerView rec;
    String id;
    ClassingListAdapter adapter;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_education_one_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
        headTitle.setText("课程列表");
        adapter = new ClassingListAdapter(this);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);
        getData();
    }

    @OnClick({R.id.back, R.id.head_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.head_title:
                break;
        }
    }

    private void getData() {
        Call<FiveEducationOneListBean> call = inter.getFiveEducationListVideo("course/get_cate_theme",getMyApplication().getToken(),id,"50","1");
        call.enqueue(new Callback<FiveEducationOneListBean>() {
            @Override
            public void onResponse(Call<FiveEducationOneListBean> call, Response<FiveEducationOneListBean> response) {
                if (response.body().getErrorcode()==200){
                    adapter.setData(response.body().getData().getData());
                }else{
                    showToast("暂无数据");
                }
            }

            @Override
            public void onFailure(Call<FiveEducationOneListBean> call, Throwable t) {

            }
        });
    }


}
