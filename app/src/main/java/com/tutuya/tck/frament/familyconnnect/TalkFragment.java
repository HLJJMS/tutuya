package com.tutuya.tck.frament.familyconnnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.BuyBeanActivity;
import com.tutuya.tck.adapter.GiftAdapter;
import com.tutuya.tck.adapter.TalkAdapter;
import com.tutuya.tck.base.BaseFragment;
import com.tutuya.tck.bean.base.TalkBean;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.GiftBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @author  tyh
 * @功能：家园互通聊天
 * @date 创建时间：2019/4/23
 */
public class TalkFragment extends BaseFragment {


    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.bt_gift)
    ImageView btGift;
    @BindView(R.id.edit_txt)
    EditText editTxt;
    @BindView(R.id.bt_ok)
    Button btOk;
    String token, teacherId, rmb;
    GiftAdapter giftAdapter;
    TalkAdapter talkAdapter;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    int page = 1;

    @Override
    protected void initData() {
        getGiftData();
        token = getArguments().getString("token");
        teacherId = getArguments().getString("id");
        rmb = getArguments().getString("rmb");
        Log.e("我是token", token);
        giftAdapter = new GiftAdapter(getContext(), getWidth());
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page++;
                getTalkRecord();
            }
        });
        aboutTalkTxt();
        aboutTalkAdapter();
        getGiftData();
        getTalkRecord();
    }

    private void aboutTalkTxt() {
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTxt.getText().toString().equals("")){
                    showToast("请输入您想发送的内容");
                }else{
                    postTxt(editTxt.getText().toString());

                }

            }
        });



    }

    private void aboutTalkAdapter() {
        talkAdapter = new TalkAdapter(getContext());
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(talkAdapter);
    }


    @Override
    protected void initView(View rootView) {
        mContext = getContext();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_talk;
    }

    @OnClick({R.id.bt_gift, R.id.bt_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_gift:
                showGiftList();
                break;
            case R.id.bt_ok:
                break;
        }
    }


    private void getGiftData() {
        Call<GiftBean> call = inter.getGiftList("student/allgift", token);
        call.enqueue(new Callback<GiftBean>() {
            @Override
            public void onResponse(Call<GiftBean> call, Response<GiftBean> response) {
                if (response.body().getErrorcode() == 200) {
                    giftAdapter.setData(response.body().getData().getGift_list(), response.body().getData().getBase_url());
                }
            }

            @Override
            public void onFailure(Call<GiftBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });


    }

    private void showGiftList() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.popup_recyclerview, null);
        PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        RecyclerView recyclerView = view.findViewById(R.id.rec);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.HORIZONTAL, false));
        TextView buy = view.findViewById(R.id.bt_buy);
        TextView ok = view.findViewById(R.id.bt_ok);
        buy.setText("充值" + "(" + "剩余" + rmb + "豆" + ")");
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BuyBeanActivity.class));
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postGift(giftAdapter.getGiftId());
            }
        });
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.isShowing();
        popupWindow.showAtLocation(getView(), Gravity.BOTTOM, 0, 0);
        recyclerView.setAdapter(giftAdapter);
    }


    private void postGift(String id) {
        Call<GMBean> call = inter.postGift("student/sendgift", token, teacherId, id, "1", "1");
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {

                if (response.body().getErrorcode().equals("200")) {
                    showToast("赠送成功");
                } else {
                    showToast(response.body().getErrormessage());
                }

            }

            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });
    }


    private void getTalkRecord() {
        Call<TalkBean> call = inter.getTalkRecord("student/msglist", token, teacherId, String.valueOf(page), "10");
        call.enqueue(new Callback<TalkBean>() {
            @Override
            public void onResponse(Call<TalkBean> call, Response<TalkBean> response) {
                if (response.body().getErrorcode() == 200) {
                    talkAdapter.addData(response.body().getData().getBase_url(), response.body().getData().getMsg_list());
                } else {
                    showToast(response.body().getErrormessage());
                }
                refreshLayout.finishRefresh();
            }

            @Override
            public void onFailure(Call<TalkBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                refreshLayout.finishRefresh();
            }
        });

    }

    private void postTxt(String txt){
        Call<GMBean> call =inter.postTxt("student/sendmsg",token,teacherId,txt);
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                if (response.body().getErrorcode().equals("200")){
                    talkAdapter.addData(new TalkBean.DataBean.MsgListBean("1",editTxt.getText().toString()));
                    editTxt.setText("");
                }
                showToast(response.body().getErrormessage());
            }

            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });
    }
}
