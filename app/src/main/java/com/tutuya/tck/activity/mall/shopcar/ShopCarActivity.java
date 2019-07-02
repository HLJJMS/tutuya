package com.tutuya.tck.activity.mall.shopcar;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.mall.MallCarAdapter;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.base.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopCarActivity extends BaseMvpActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.bt_edit)
    TextView btEdit;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private MallCarAdapter adapter;
    private ShopCarPresent present;
    @Override
    protected BasePresenter createPresenter() {
        present = new ShopCarPresent();
        return present;
    }

    @Override
    protected void initPresenter() {
        present.getActivity();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_shop_car);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("购物车");
        aboutRecycler();
    }

    private void aboutRecycler() {
        adapter = new MallCarAdapter(this);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler.setAdapter(adapter);

    }

    @OnClick({R.id.back, R.id.bt_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_edit:
                break;
        }
    }
}
