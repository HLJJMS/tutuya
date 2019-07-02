package com.tutuya.tck.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.ProfessionalFamousTeacherClassListAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.classing.FamousTeacherInfoBean;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListBean;
import com.tutuya.tck.bean.network.home.FamousTeacherBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @author  tyh
 * @功能：专家名师详情页
 * @date 创建时间：2019/4/14
 */
public class ProfessionalFamousTeacherActivity extends BaseActivity {

    @BindView(R.id.img_bg)
    ImageView imgBg;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.image_head)
    ImageView imageHead;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_detail)
    TextView txtDetail;
    @BindView(R.id.bt1)
    TextView bt1;
    @BindView(R.id.bt2)
    TextView bt2;
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.txt)
    TextView txt;
    ProfessionalFamousTeacherClassListAdapter adapter;
    String id ;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_professionla_famous_teacher);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("code");
        Log.e("我是老师的id",getIntent().getStringExtra("code"));
        headTitle.setText("名师详情");
        setView(1);
        aboutAdapter();
        getListData();
        getTeacherInfo();
    }

    private void aboutAdapter() {
        adapter = new ProfessionalFamousTeacherClassListAdapter(this, getMyApplication().getWidth());
        rec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rec.setAdapter(adapter);
    }

    @OnClick({R.id.back, R.id.bt1, R.id.bt2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt1:
                setView(1);
                break;
            case R.id.bt2:
                setView(2);
                break;
        }
    }

    private void setView(int position) {
        switch (position) {
            case 1:
                bt1.setTextColor(0xffFFA30E);
                bt2.setTextColor(0xff333333);
                rec.setVisibility(View.VISIBLE);
                txt.setVisibility(View.GONE);
                break;
            case 2:
                bt1.setTextColor(0xff333333);
                bt2.setTextColor(0xffFFA30E);
                rec.setVisibility(View.GONE);
                txt.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void getTeacherInfo(){
        Call<FamousTeacherInfoBean> call = inter.getFamousTeacherInfo("course/get_lecturer_info",getMyApplication().getToken(),id);
        call.enqueue(new Callback<FamousTeacherInfoBean>() {
            @Override
            public void onResponse(Call<FamousTeacherInfoBean> call, Response<FamousTeacherInfoBean> response) {
                if (response.body().getErrorcode()==200){
                    setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<FamousTeacherInfoBean> call, Throwable t) {

            }
        });

    }

    private void setData( FamousTeacherInfoBean bean) {
        Glide.with(this).load(bean.getData().getData().getCover_img()).into(imgBg);
        Glide.with(this).load(bean.getData().getData().getRecommend_img()).into(imageHead);
        txtName.setText(bean.getData().getData().getName());
        txtDetail.setText(bean.getData().getData().getTags().toString().replace(",","\n"));
        txt.setText(bean.getData().getData().getIntroduction());

    }


    private void getListData(){
        Call<FamousTeacherVideoListBean> call = inter.getFamousTeacherVideo("course/get_course_theme",getMyApplication().getToken(),"50","1",id);
        call.enqueue(new Callback<FamousTeacherVideoListBean>() {
            @Override
            public void onResponse(Call<FamousTeacherVideoListBean> call, Response<FamousTeacherVideoListBean> response) {
                if (response.body().getErrorcode()==200){
                    adapter.setData(response.body().getData().getData());
                }
            }

            @Override
            public void onFailure(Call<FamousTeacherVideoListBean> call, Throwable t) {

            }
        });


    }

}
