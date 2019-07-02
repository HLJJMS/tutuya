package com.tutuya.tck.activity.headtest;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.HeadDetailAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.HeadDetailBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//闹测评详情页
public class HeadDetailActivity extends BaseActivity {


    @BindView(R.id.scan)
    ImageView scan;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.cancel)
    TextView cancel;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    private HeadDetailAdapter adapter;
    private String decode;
    private Context context;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_head_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        context = this;
        headTitle.setText("脑测评预约记录");
        adapter = new HeadDetailAdapter(this);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recycler.setAdapter(adapter);
        recycler.setNestedScrollingEnabled(false);
        getData(getIntent().getStringExtra("id"));

    }

    @OnClick({R.id.scan, R.id.cancel, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.scan:
                break;
            case R.id.cancel:
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    private void getData(String id) {


        Call<HeadDetailBean> call = inter.getHeadDetail("qqtree/app_detail", getMyApplication().getToken(), id);
        call.enqueue(new Callback<HeadDetailBean>() {
            @Override
            public void onResponse(Call<HeadDetailBean> call, Response<HeadDetailBean> response) {
                if (response.body().getErrorcode() == 200) {
                    adapter.setData(response.body().getData().getData());
                    decode = response.body().getData().getData().getDcode();
                    Glide.with(context).load("http://qr.liantu.com/api.php?text="+decode).into(scan);
                } else {
                    showToast(response.body().getErrormessage());
                }
            }

            @Override
            public void onFailure(Call<HeadDetailBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });


    }
}
