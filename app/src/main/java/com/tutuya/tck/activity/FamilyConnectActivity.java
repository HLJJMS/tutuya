package com.tutuya.tck.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flyco.tablayout.SlidingTabLayout;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.GMAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.BaseFragment;
import com.tutuya.tck.frament.education.ClassingFragment;
import com.tutuya.tck.frament.education.CommontFragment;
import com.tutuya.tck.frament.education.DetailFragment;
import com.tutuya.tck.frament.familyconnnect.GiftListFragment;
import com.tutuya.tck.frament.familyconnnect.TalkFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FamilyConnectActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.headimg)
    ImageView headimg;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_school)
    TextView txtSchool;
    @BindView(R.id.tab)
    SlidingTabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private GMAdapter mAdapter;
    String[] titleList = {"沟通记录","礼单"};
    List<BaseFragment> list = new ArrayList<>();
    TalkFragment talkFragment = new TalkFragment();
    GiftListFragment giftListFragment = new GiftListFragment();
    String id;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_family_connect);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        list.add(talkFragment);
        list.add(giftListFragment);
        mAdapter = new GMAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(mAdapter);
        tab.setViewPager(viewPager, titleList);
        headTitle.setText("家园互通");


        id=getIntent().getStringExtra("id");
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("token", getMyApplication().getToken());
        bundle.putString("rmb",getIntent().getStringExtra("rmb"));
        talkFragment.setArguments(bundle);
        giftListFragment.setArguments(bundle);

        txtName.setText(getIntent().getStringExtra("name"));
        txtSchool.setText( getIntent().getStringExtra("className"));
        Glide.with(this).load(  getIntent().getStringExtra("photoUrl")).into(headimg);
    }

    @OnClick({R.id.back, R.id.view_pager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.view_pager:
                break;
        }
    }
}
