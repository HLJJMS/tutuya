package com.tutuya.tck.frament.mall;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.mall.SearchActivity;
import com.tutuya.tck.adapter.mall.MallIndexAdapter;
import com.tutuya.tck.base.BaseMvpFragment;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.frament.IHomeActivityToFramgent;

import butterknife.BindView;
import butterknife.OnClick;

/*CREATE BY TYH
 **2019.4.1
 **商城FRAMGENT*/
public class MallMvpFragment extends BaseMvpFragment implements IMallView , IHomeActivityToFramgent {
    @BindView(R.id.et_search)
    TextView etSearch;
    @BindView(R.id.bt_search)
    ImageView btSearch;
    @BindView(R.id.bt_all)
    TextView btAll;
    @BindView(R.id.bt_new)
    TextView btNew;
    @BindView(R.id.bt_sell)
    TextView btSell;
    @BindView(R.id.bt_price)
    TextView btPrice;
    @BindView(R.id.mall_rec)
    RecyclerView mallRec;
    private MallIndexAdapter adapter;
    private MallPresent present;
    private String token;
    private boolean vip;
    @Override
    protected BasePresenter createPresenter() {
        present = new MallPresent();
        return present;
    }

    @Override
    protected void initPresenter() {
        present.getActivity();
    }

    @Override
    protected void initData() {
        aboutRecycler();
        setColor(btAll);
    }

    private void aboutRecycler() {
        adapter = new MallIndexAdapter(mContext, getWidth());
        mallRec.setLayoutManager(new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false));
        mallRec.setNestedScrollingEnabled(false);
        mallRec.setAdapter(adapter);
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("开始离开时","离开时开始了");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("充其量","充其量");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mall;
    }


    @OnClick({R.id.et_search, R.id.bt_search, R.id.bt_all, R.id.bt_new, R.id.bt_sell, R.id.bt_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_search:
                Intent search = new Intent(mContext, SearchActivity.class);
                startActivity(search);
                break;
            case R.id.bt_search:
                break;
            case R.id.bt_all:
                setColor(btAll);
                break;
            case R.id.bt_new:
                setColor(btNew);
                break;
            case R.id.bt_sell:
                setColor(btSell);
                break;
            case R.id.bt_price:
                setColor(btPrice);
                break;
        }
    }

    private void setColor(TextView view){
        btAll.setTextColor(0xFF666666);
        btAll.getPaint().setFlags(0);
        btNew.setTextColor(0xFF666666);
        btNew.getPaint().setFlags(0);
        btSell.setTextColor(0xFF666666);
        btSell.getPaint().setFlags(0);
        btPrice.setTextColor(0xFF666666);
        btPrice.getPaint().setFlags(0);
        view.setTextColor(0xffFE9B12);
        view.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG);

    }


    @Override
    public void loadData() {

    }

    @Override
    public void getToken(String token, boolean vip) {
        this.token = token;
        this.vip = vip;
    }
}
