package com.tutuya.tck.frament.home;

import android.Manifest;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.CourseRecommendationListActivity;
import com.tutuya.tck.activity.Education.EducationHomeActivity;
import com.tutuya.tck.activity.Education.EducationOneListActivity;
import com.tutuya.tck.activity.FamilyConnectActivity;
import com.tutuya.tck.activity.ProfessionalFamousTeacherActivity;
import com.tutuya.tck.activity.ProfessionalTeacherListActivity;
import com.tutuya.tck.activity.baby.BabyListActivity;
import com.tutuya.tck.activity.headtest.HeadTestListActivity;
import com.tutuya.tck.adapter.home.HomeAboutBabyListAdapter;
import com.tutuya.tck.adapter.home.HomeClassingAdapter;
import com.tutuya.tck.adapter.home.HomeMallAdapter;
import com.tutuya.tck.adapter.home.HomeProfessionalAdapter;
import com.tutuya.tck.adapter.home.HomePullTellAdapter;
import com.tutuya.tck.base.BaseMvpFragment;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.bean.base.GlideImageLoader;
import com.tutuya.tck.bean.network.HomeBannerBean;
import com.tutuya.tck.bean.network.HomeClassingNewBean;
import com.tutuya.tck.bean.network.home.CommentingBean;
import com.tutuya.tck.bean.network.home.CouresRecommendBean;
import com.tutuya.tck.bean.network.home.FamousTeacherBean;
import com.tutuya.tck.bean.network.home.FiveEducation;
import com.tutuya.tck.diyview.HomeTitle;
import com.tutuya.tck.diyview.SmartScrollView;
import com.tutuya.tck.leochuan.CenterSnapHelper;
import com.tutuya.tck.leochuan.ScaleLayoutManager;
import com.tutuya.tck.tools.Util;
import com.youth.banner.Banner;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
/*
 * 主页framgent
 * create  by  田羽衡
 *
 * */

public class HomeMvpFragment extends BaseMvpFragment implements IHomeView, IHomeForActivity {

    @BindView(R.id.position_txt)
    TextView positionTxt;
    @BindView(R.id.position_img)
    ImageView positionImg;
    @BindView(R.id.about_baby_rec)
    RecyclerView aboutBabyRec;
    @BindView(R.id.study_txt)
    TextView studyTxt;
    @BindView(R.id.teacher)
    HomeTitle teacher;
    @BindView(R.id.class_rec)
    RecyclerView classRec;
    @BindView(R.id.profession_go)
    HomeTitle professionGo;
    @BindView(R.id.profession_rec)
    RecyclerView professionRec;
    @BindView(R.id.good_tell)
    HomeTitle goodTell;
    @BindView(R.id.good_tell_rec)
    RecyclerView goodTellRec;
    @BindView(R.id.mall_rec)
    RecyclerView mallRec;
    @BindView(R.id.scrollView)
    SmartScrollView scrollView;
    @BindView(R.id.tv_classing)
    TextView tvClassing;
    @BindView(R.id.five_study)
    TextView fiveStudy;
    @BindView(R.id.bt_family)
    ImageView btFamily;
    @BindView(R.id.bt_develop)
    ImageView btDevelop;
    @BindView(R.id.bt_healthy)
    ImageView btHealthy;
    @BindView(R.id.bt_expand)
    ImageView btExpand;
    @BindView(R.id.bt_create)
    ImageView btCreate;
    @BindView(R.id.bt_teacher_one)
    ImageView btTeacherOne;
    @BindView(R.id.bt_teacher_two)
    ImageView btTeacherTwo;
    @BindView(R.id.icon_one)
    ImageView iconOne;
    @BindView(R.id.txt_number_one)
    TextView txtNumberOne;
    @BindView(R.id.bt_heart_one)
    CheckBox btHeartOne;
    @BindView(R.id.txt_name_one)
    TextView txtNameOne;
    @BindView(R.id.icon_two)
    ImageView iconTwo;
    @BindView(R.id.txt_number_two)
    TextView txtNumberTwo;
    @BindView(R.id.bt_heart_two)
    CheckBox btHeartTwo;
    @BindView(R.id.txt_name_two)
    TextView txtNameTwo;
    @BindView(R.id.txt_detail_two_three)
    TextView txtDetailTwoThree;
    @BindView(R.id.bt_classing_select)
    HomeTitle btClassingSelect;
    @BindView(R.id.xiaoren)
    ImageView xiaoren;
    @BindView(R.id.r1)
    RadioButton r1;
    @BindView(R.id.r2)
    RadioButton r2;
    @BindView(R.id.r3)
    RadioButton r3;
    @BindView(R.id.r4)
    RadioButton r4;
    @BindView(R.id.r5)
    RadioButton r5;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.sw)
    SwipeRefreshLayout sw;
    Unbinder unbinder;
    @BindView(R.id.txt_detail_one_three)
    TextView txtDetailOneThree;
    private CenterSnapHelper centerSnapHelper = new CenterSnapHelper();
    private HomeAboutBabyListAdapter homeAboutBabyListAdapter;
    private HomeClassingAdapter homeClassingAdapter;
    private HomeProfessionalAdapter homeProfessionalAdapter;
    private HomePullTellAdapter homePullTellAdapter;
    private HomeMallAdapter homeMallAdapter;
    private HomePresent present;
    private Bundle bundle;
    private int radioGroupWidth, lastPosition = 1;
    private List<String> bannerStringList = new ArrayList<>();
    private List<HomeBannerBean.DataBean> bannerList = new ArrayList<>();
    private String token;
    List<FiveEducation.DataBean.CateBean> fiveEducation = new ArrayList<>();
    private boolean vip;

    @Override
    protected BasePresenter createPresenter() {
        present = new HomePresent();
        return present;
    }

    @Override
    protected void initPresenter() {
        present.getActivity();
    }

    @Override
    protected void initData() {
        bundle = getArguments();
        if (null != bundle) {
            token = bundle.getString("token");
            vip = bundle.getBoolean("vip");
        }
        Log.e("我是token", token);
        aboutBabylistAdapter();
        aboutClassAdapter();
        aboutProfessionAdapter();
        aboutPullTell();
        aboutMallAdapter();
        getCity();
        aboutBanner();
        aboutSwipeRefresh();
        present.getCommenting();
        present.getCouresRecommend();
        present.getFamousTeacher();
        present.getFiveEducation();
    }

    private void aboutSwipeRefresh() {
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {//模拟耗时操作
                    @Override
                    public void run() {
                        sw.setRefreshing(false);//取消刷新

                    }
                }, 2000);
            }
        });
    }

    private void aboutBanner() {
        for (int i = 0; i < bannerList.size(); i++) {
            bannerStringList.add(bannerList.get(i).getImg());
            Log.e("图片url", bannerList.get(i).getImg());
        }
        banner.setImageLoader(new GlideImageLoader()).setImages(bannerStringList).start();
    }


    //获取用户当前位置
    private void getCity() {
        MPermissions.requestPermissions(this, 0, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION});

    }

    //关于主页商城的列表
    private void aboutMallAdapter() {
        homeMallAdapter = new HomeMallAdapter(mContext, getWidth());
        mallRec.setAdapter(homeMallAdapter);
        mallRec.setNestedScrollingEnabled(false);
        mallRec.setLayoutManager(new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false));
    }

    //关于主页推荐讲评
    private void aboutPullTell() {
        homePullTellAdapter = new HomePullTellAdapter(getActivity(), getWidth());
        LinearLayoutManager ptlm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        ptlm.scrollToPositionWithOffset(5, 0);
        goodTellRec.setLayoutManager(ptlm);
        goodTellRec.setAdapter(homePullTellAdapter);
        homePullTellAdapter.setiOnClick(new HomePullTellAdapter.IOnClick() {
            @Override
            public void onClick(int i) {
                Map<String, String> map = new HashMap<>();
                goNewActivity(ProfessionalFamousTeacherActivity.class, map, token, vip);
            }
        });

    }

    //关于主页专家讲评
    private void aboutProfessionAdapter() {
        homeProfessionalAdapter = new HomeProfessionalAdapter(getActivity(), getWidth());
        professionRec.setAdapter(homeProfessionalAdapter);
        ScaleLayoutManager scaleLayoutManager = new ScaleLayoutManager(getContext(), Util.Dp2px(getContext(), 10));
        scaleLayoutManager.setMinScale(0.5f);
        professionRec.setLayoutManager(scaleLayoutManager);
        scaleLayoutManager.scrollToPositionWithOffset(3, 0);
        centerSnapHelper.attachToRecyclerView(professionRec);
        homeProfessionalAdapter.setiOnClick(new HomeProfessionalAdapter.IOnClick() {
            @Override
            public void onClick(int i) {
                Map<String, String> map = new HashMap<>();
                goNewActivity(ProfessionalFamousTeacherActivity.class, map, token, vip);
            }
        });
    }

    //课程推荐
    private void aboutClassAdapter() {
        homeClassingAdapter = new HomeClassingAdapter(getContext());
        classRec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        classRec.setAdapter(homeClassingAdapter);

    }
    //宝宝相关

    private void aboutBabylistAdapter() {
        aboutBabyRec.setLayoutParams(Util.setMargins(aboutBabyRec, 0, 490, 0, 0));
        homeAboutBabyListAdapter = new HomeAboutBabyListAdapter(getWidth(), getActivity());
        aboutBabyRec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        aboutBabyRec.setAdapter(homeAboutBabyListAdapter);

    }

    //小人的动画
    private void jumoIcon(int position) {
        radioGroupWidth = group.getMeasuredWidth();
        final int marginLeft = radioGroupWidth / 5 * position - xiaoren.getWidth();
        final int lastLeft = radioGroupWidth / 5 * lastPosition - xiaoren.getWidth();
        final ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) xiaoren.getLayoutParams();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(lastLeft, marginLeft);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.setMargins((int) animation.getAnimatedValue(), 0, 0, 0);
                xiaoren.setLayoutParams(params);
            }
        });
        valueAnimator.start();
        lastPosition = position;
    }

    @PermissionGrant(0)
    public void requestContactSuccess() {
        Toast.makeText(getActivity(), "正在获取位置信息", Toast.LENGTH_SHORT).show();
        LocationManager lm = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        present.getPosition(lm);
    }

    @PermissionDenied(0)
    public void requestContactFailed() {
        Toast.makeText(getActivity(), "无法获取定位信息，请在设置里打开位置获取权限", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void showToastI(String txt) {
        showToast(txt);
    }

    @Override
    public void showCity(String city) {
        positionTxt.setText(city);
    }

    @Override
    public void setTeacherInfo(String id, String name, String className, String photoUrl) {
        Intent intent = new Intent(getContext(), FamilyConnectActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("name", name);
        intent.putExtra("className", className);
        intent.putExtra("photoUrl", photoUrl);
        startActivity(intent);
    }

    @Override
    public void setFiveEducation(List<FiveEducation.DataBean.CateBean> fiveEducation) {
        this.fiveEducation.addAll(fiveEducation);
        btFamily.setTag(fiveEducation.get(1).getId());
        btCreate.setTag(fiveEducation.get(0).getId());
        btDevelop.setTag(fiveEducation.get(2).getId());
        btHealthy.setTag(fiveEducation.get(3).getId());
        btExpand.setTag(fiveEducation.get(4).getId());
    }

    @Override
    public void setFamousTeacher(List<FamousTeacherBean.DataBean.LectureBean> famousTeacher) {

        Glide.with(getContext()).load(famousTeacher.get(0).getCover_img()).into(btTeacherOne);
        btTeacherOne.setTag(famousTeacher.get(0).getId());
        txtNameOne.setText(famousTeacher.get(0).getName());
        txtDetailOneThree.setText(famousTeacher.get(0).getTags().toString());
        txtNumberOne.setText(famousTeacher.get(0).getPraise_num());

        Glide.with(getContext()).load(famousTeacher.get(1).getCover_img()).into(btTeacherTwo);
        btTeacherTwo.setTag(famousTeacher.get(1).getId());
        txtNameTwo.setText(famousTeacher.get(1).getName());
        txtDetailTwoThree.setText(famousTeacher.get(1).getTags().toString());
        txtNumberTwo.setText(famousTeacher.get(1).getPraise_num());
    }

    @Override
    public void setCouresRecommend( List<HomeClassingNewBean.DataBeanX.DataBean> couresRecommend ) {
        homeClassingAdapter.setData(couresRecommend);
    }

    @Override
    public void setCommenting(CommentingBean commenting) {
        homeProfessionalAdapter.setData(commenting.getData().getComment_high());
        homePullTellAdapter.setData(commenting.getData().getComment_low());
    }


    @OnClick({R.id.five_study, R.id.bt_family, R.id.bt_develop, R.id.bt_healthy, R.id.bt_expand, R.id.bt_create, R.id.bt_teacher_one, R.id.bt_teacher_two, R.id.bt_heart_one, R.id.bt_heart_two, R.id.bt_classing_select, R.id.r1, R.id.r2, R.id.r3, R.id.r4, R.id.r5, R.id.position_txt, R.id.position_img, R.id.study_txt, R.id.teacher, R.id.profession_go, R.id.good_tell})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.five_study:
                break;
            case R.id.bt_family:
                Intent family = new Intent(getContext(), EducationOneListActivity.class);
                family.putExtra("id",btFamily.getTag().toString());
                startActivity(family);
                break;
            case R.id.bt_develop:
                Intent develop = new Intent(getContext(), EducationOneListActivity.class);
                develop.putExtra("id",btDevelop.getTag().toString());
                startActivity(develop);
                break;
            case R.id.bt_healthy:
                Intent healthy = new Intent(getContext(), EducationOneListActivity.class);
                healthy.putExtra("id",btHealthy.getTag().toString());
                startActivity(healthy);
                break;
            case R.id.bt_expand:
                Intent expand = new Intent(getContext(), EducationOneListActivity.class);
                expand.putExtra("id",btExpand.getTag().toString());
                startActivity(expand);
                break;
            case R.id.bt_create:
                Intent create = new Intent(getContext(), EducationOneListActivity.class);
                create.putExtra("id",btCreate.getTag().toString());
                startActivity(create);
                break;
            case R.id.bt_teacher_one:
                Intent teacherOneIntent=new Intent(getActivity(), ProfessionalFamousTeacherActivity.class);
                teacherOneIntent.putExtra("code",btTeacherOne.getTag().toString());
                startActivity(teacherOneIntent);
                break;
            case R.id.bt_teacher_two:
                Intent teacherTwoIntent=new Intent(getActivity(), ProfessionalFamousTeacherActivity.class);
                teacherTwoIntent.putExtra("code",btTeacherOne.getTag().toString());
                startActivity(teacherTwoIntent);
                break;
            case R.id.bt_heart_one:
                break;
            case R.id.bt_heart_two:
                break;
            case R.id.bt_classing_select:
                startActivity(new Intent(getContext(), CourseRecommendationListActivity.class));
                break;
            case R.id.r1:
                jumoIcon(1);
                present.getClassTwo(btCreate.getTag().toString(),token);
                break;
            case R.id.r2:
                jumoIcon(2);
                present.getClassTwo(btFamily.getTag().toString(),token);
                break;
            case R.id.r3:
                jumoIcon(3);
                present.getClassTwo(btDevelop.getTag().toString(),token);
                break;
            case R.id.r4:
                jumoIcon(4);
                present.getClassTwo(btHealthy.getTag().toString(),token);
                break;
            case R.id.r5:
                jumoIcon(5);
                present.getClassTwo(btDevelop.getTag().toString(),token);
            case R.id.position_txt:
                break;
            case R.id.position_img:
                break;
            case R.id.study_txt:
                break;
            case R.id.teacher:
                Intent teacherIntent =new Intent(mContext, ProfessionalTeacherListActivity.class);
                startActivity(teacherIntent);
                break;
            case R.id.profession_go:
                break;
            case R.id.good_tell:
                break;
        }
    }


    @Override
    public void setData(List<HomeBannerBean.DataBean> bannerList) {
        this.bannerList.clear();
        this.bannerList.addAll(bannerList);
    }

    @Override
    public void getToken(String token, boolean vip) {
        this.vip = vip;
        this.token = token;
        Log.e("我是token", token);
    }

}
