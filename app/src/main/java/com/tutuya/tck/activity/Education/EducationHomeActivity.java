package com.tutuya.tck.activity.Education;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.flyco.tablayout.SlidingTabLayout;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.GMAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.BaseFragment;
import com.tutuya.tck.frament.education.ClassingFragment;
import com.tutuya.tck.frament.education.CommontFragment;
import com.tutuya.tck.frament.education.DetailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * //五大大教育主页activity
 *
 * */

public class EducationHomeActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    TextView txtPeople;
    @BindView(R.id.tab)
    SlidingTabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private final String[] mTitles = {"课程", "评论", "介绍"};
    @BindView(R.id.video)
    VideoView video;

    private GMAdapter mAdapter;
    List<BaseFragment> list = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_education);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("家庭教育");
        aboutFamilyAdapter();
    }

    //    关于viewpager/
    private void aboutFamilyAdapter() {
        list.add(new ClassingFragment());
        list.add(new CommontFragment());
        list.add(new DetailFragment());
        mAdapter = new GMAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(mAdapter);
        tab.setViewPager(viewpager, mTitles);
    }


    @OnClick({R.id.back, R.id.video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.video:
                break;
        }
    }
}
