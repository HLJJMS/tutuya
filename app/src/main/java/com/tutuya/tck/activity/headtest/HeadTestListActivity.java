package com.tutuya.tck.activity.headtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.baby.BabyListForHeadActivity;
import com.tutuya.tck.adapter.HeadTestAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.HeadTestListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//闹测评列表页
public class HeadTestListActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.lg)
    Guideline lg;
    @BindView(R.id.rg)
    Guideline rg;
    @BindView(R.id.lbg)
    Guideline lbg;
    @BindView(R.id.rbg)
    Guideline rbg;
    @BindView(R.id.img_null)
    ImageView imgNull;
    @BindView(R.id.txt_null)
    TextView txtNull;
    private HeadTestAdapter adapter;
    private int page = 1;
    private String token;

    //    private List<HeadTestListBean.DataBeanX.DataBean> dataBeanList = new ArrayList<>();
    @Override
    protected void initView() {
        setContentView(R.layout.activity_head_test);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("脑测评预约记录");
        token = getMyApplication().getToken();
        aboutRecycler();

    }

    private void aboutRecycler() {
        adapter = new HeadTestAdapter(this);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        list.setAdapter(adapter);
        list.setOnScrollListener(new RecyclerView.OnScrollListener() {
            //用来标记是否正在向最后一个滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                        //加载更多功能的代码
                        showToast("到底了");
                        Log.e("到底了", "到底了");
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if (dx > 0) {
                    //大于0表示正在向右滚动
                    isSlidingToLast = true;
                } else {
                    //小于等于0表示停止或向左滚动
                    isSlidingToLast = false;
                }
            }
        });
        getData();
    }


    @OnClick({R.id.back, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.add:
                Intent intent = new Intent(this, BabyListForHeadActivity.class);
                startActivity(intent);
                break;
        }
    }

    //    获取数据脑测评列表
    private void getData() {
        Call<HeadTestListBean> call = inter.getHeadTestList("qqtree/get_evaluation_list", token, page, 30);
        call.enqueue(new Callback<HeadTestListBean>() {
            @Override
            public void onResponse(Call<HeadTestListBean> call, Response<HeadTestListBean> response) {
                if (response.body().getErrorcode() == 200) {
                    if (response.body().getData().getData().size() > 0) {
                        adapter.setData(response.body().getData().getData());
                        imgNull.setVisibility(View.GONE);
                        txtNull.setVisibility(View.GONE);
                        list.setVisibility(View.VISIBLE);
                    }else{
                        imgNull.setVisibility(View.VISIBLE);
                        txtNull.setVisibility(View.VISIBLE);
                        list.setVisibility(View.GONE);
                    }
                } else {
                    showToast(response.body().getErrormessage());
                    imgNull.setVisibility(View.VISIBLE);
                    txtNull.setVisibility(View.VISIBLE);
                    list.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<HeadTestListBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                imgNull.setVisibility(View.VISIBLE);
                txtNull.setVisibility(View.VISIBLE);
                list.setVisibility(View.GONE);
            }
        });
    }

}
