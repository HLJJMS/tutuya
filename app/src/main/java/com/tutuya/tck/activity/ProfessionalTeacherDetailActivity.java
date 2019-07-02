package com.tutuya.tck.activity;



import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.GMAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.BaseFragment;

import com.tutuya.tck.frament.education.CommontFragment;
import com.tutuya.tck.frament.professionalteacher.ClassingFragment;
import com.tutuya.tck.frament.professionalteacher.CommentFragment;
import com.tutuya.tck.frament.professionalteacher.DetailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * @version 1.0
 * @author  tyh
 * @功能：专家详情列表
 * @date 创建时间：2019/4/14
 */
public class ProfessionalTeacherDetailActivity extends BaseActivity {

    @BindView(R.id.bg)
    ImageView bg;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_detail)
    TextView txtDetail;
    @BindView(R.id.hat)
    ImageView hat;
    @BindView(R.id.tab)
    SlidingTabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private final String[] mTitles = {"介绍", "评论", "课程"};
    private GMAdapter mAdapter;
    List<BaseFragment> list = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_professional_teacher_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("教师介绍");
        aboutViewPager();

    }

    private void aboutViewPager() {
        list.add(new DetailFragment());
        list.add(new CommentFragment());
        list.add(new ClassingFragment());
        mAdapter = new GMAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(mAdapter);
        tab.setViewPager(viewpager, mTitles);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

}
