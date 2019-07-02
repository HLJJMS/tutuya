package com.tutuya.tck.activity;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flyco.tablayout.SlidingTabLayout;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.TellDetailAdapter;
import com.tutuya.tck.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//讲师介绍
public class TellDetailActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tab)
    SlidingTabLayout tab;
    @BindView(R.id.frament)
    ViewPager frament;
    private TellDetailAdapter adapter;
    private String[] mTitles = {"讲师简介", "往期讲评"};

    @Override
    protected void initView() {
        setContentView(R.layout.activity_tell_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553087325617&di=01561182f4dd790e6a40b8f531b0beed&imgtype=0&src=http%3A%2F%2Fstatic.leiphone.com%2Fuploads%2F2014%2F05%2F201212070925372159.jpg").into(img);
        headTitle.setText("讲评详情");
        aboutAdapterAndTab();
    }

    private void aboutAdapterAndTab() {
        adapter = new TellDetailAdapter(getSupportFragmentManager());
        frament.setAdapter(adapter);
        frament.setCurrentItem(0);
        frament.setOffscreenPageLimit(2);
        frament.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            //            监听view改变tab也跟着改变
            @Override
            public void onPageSelected(int i) {
                tab.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        tab.setViewPager(frament, mTitles);

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

}
