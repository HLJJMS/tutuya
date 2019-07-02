package com.tutuya.tck.activity.baby;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.BabyListAdapter;
import com.tutuya.tck.adapter.BabyWetherSchoolBean;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.BabyListBean;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.diyview.SwipeRecycler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
宝宝信息列表
*/
public class BabyListActivity extends BaseActivity {

    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.list)
    SwipeRecycler list;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.list_null)
    ImageView listNull;
    private BabyListAdapter adapter;
    private List<BabyListBean.DataBean> listBean = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_baby_list);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("宝宝信息");
        aboutRecycler();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }

    private void aboutRecycler() {
        adapter = new BabyListAdapter(list, this);
        list.setAdapter(adapter);

        //        recyclerview回调监听（删除）
        adapter.setDelItem(new BabyListAdapter.DelItem() {
            @Override
            public void del(final int i, String id) {
                Call<GMBean> call = inter.delBaby("baby/babydel", getMyApplication().getToken(), id);
                call.enqueue(new Callback<GMBean>() {
                    @Override
                    public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                        if (response.body().getErrorcode().equals("200")) {
                            adapter.delItemForActivity(i);
                        }
                        showToast(response.body().getErrormessage());
                    }
                    @Override
                    public void onFailure(Call<GMBean> call, Throwable t) {
                        showToast(inter.ERRORMESSAGE);
                    }
                });
            }
        });
    }


    private void getList() {

        Call<BabyListBean> call = inter.getBabyList("baby/babylist", getMyApplication().getToken());
        call.enqueue(new Callback<BabyListBean>() {
            @Override
            public void onResponse(Call<BabyListBean> call, Response<BabyListBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    if (response.body().getData().size() > 0) {
                        listBean.clear();
                        listBean.addAll(response.body().getData());
                        adapter.setData(listBean);
                        list.setVisibility(View.VISIBLE);
                        listNull.setVisibility(View.GONE);
                    } else {
                        showToast("暂无数据");
                        list.setVisibility(View.GONE);
                        listNull.setVisibility(View.VISIBLE);
                    }

                } else {
                    showToast(response.body().getErrormessage());
                    list.setVisibility(View.GONE);
                    listNull.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<BabyListBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                list.setVisibility(View.GONE);
                listNull.setVisibility(View.VISIBLE);
                closeLoading();
            }
        });
    }


    @OnClick({R.id.back, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.add:
//                showToast("功能暂未开放");
                Intent intent = new Intent(BabyListActivity.this, WhetherSchoolActivity.class);
                startActivity(intent);
                break;
        }
    }

}
