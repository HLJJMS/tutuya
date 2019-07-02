package com.tutuya.tck.activity.Classing;

import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.zaixianketang.ClassingAdapter;
import com.tutuya.tck.base.BaseMvpActivity;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.diyview.HomeTitle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
四大教育activity
*/
public class ClassingActivity extends BaseMvpActivity {
    ClassingPresent present;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.bt_konw)
    HomeTitle btKonw;
    @BindView(R.id.bt_family)
    ImageView btFamily;
    @BindView(R.id.bt_develop)
    ImageView btDevelop;
    @BindView(R.id.bt_healthy)
    ImageView btHealthy;
    @BindView(R.id.xiaoren)
    ImageView xiaoren;
    @BindView(R.id.bt_expand)
    ImageView btExpand;
    @BindView(R.id.bt_create)
    ImageView btCreate;
    @BindView(R.id.bt_professional)
    HomeTitle btProfessional;
    @BindView(R.id.bt_teacher_one)
    ImageView btTeacherOne;
    @BindView(R.id.bt_teacher_two)
    ImageView btTeacherTwo;
    @BindView(R.id.txt_number_one)
    TextView txtNumberOne;
    @BindView(R.id.bt_heart_one)
    CheckBox btHeartOne;
    @BindView(R.id.txt_name_one)
    TextView txtNameOne;
    @BindView(R.id.txt_detail_one)
    TextView txtDetailOne;
    @BindView(R.id.txt_detail_one_two)
    TextView txtDetailOneTwo;
    @BindView(R.id.txt_detail_one_three)
    TextView txtDetailOneThree;
    @BindView(R.id.bt_classing_select)
    HomeTitle btClassingSelect;
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
    @BindView(R.id.rec)
    RecyclerView rec;
    private int radioGroupWidth,lastPosition=1;
    private ClassingAdapter adapter;

    @Override
    protected BasePresenter createPresenter() {
        present = new ClassingPresent();
        return present;
    }

    @Override
    protected void initPresenter() {
        present.getActivity();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_classing);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        int a = getMyApplication().getWidth();
        radioGroupWidth = new Double( getMyApplication().getWidth()*0.92).intValue();
        aboutAdapter();

    }
//    精选课列表相关
    private void aboutAdapter() {
        adapter = new ClassingAdapter();
        rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rec.setNestedScrollingEnabled(false);
        rec.setAdapter(adapter);
    }



    @OnClick({R.id.back, R.id.bt_konw, R.id.bt_family, R.id.bt_develop, R.id.bt_healthy, R.id.bt_expand, R.id.bt_create, R.id.bt_professional, R.id.bt_teacher_one, R.id.bt_teacher_two, R.id.bt_heart_one, R.id.bt_classing_select, R.id.r1, R.id.r2, R.id.r3, R.id.r4, R.id.r5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_konw:
                break;
            case R.id.bt_family:
                break;
            case R.id.bt_develop:
                break;
            case R.id.bt_healthy:
                break;
            case R.id.bt_expand:
                break;
            case R.id.bt_create:
                break;
            case R.id.bt_professional:
                break;
            case R.id.bt_teacher_one:
                break;
            case R.id.bt_teacher_two:
                break;
            case R.id.bt_heart_one:
                break;
            case R.id.bt_classing_select:
                break;
            case R.id.r1:
                jumoIcon(1);
                break;
            case R.id.r2:
                jumoIcon(2);
                break;
            case R.id.r3:
                jumoIcon(3);
                break;
            case R.id.r4:
                jumoIcon(4);
                break;
            case R.id.r5:
                jumoIcon(5);
                break;
        }
    }
//小人的动画
    private void jumoIcon(int position){
        final int marginLeft =  radioGroupWidth/5*position-xiaoren.getWidth();
        final int lastLeft = radioGroupWidth/5*lastPosition-xiaoren.getWidth();
        final ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) xiaoren.getLayoutParams();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(lastLeft, marginLeft);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.setMargins((int)animation.getAnimatedValue(),0,0,0);
                xiaoren.setLayoutParams(params);
            }
        });
        valueAnimator.start();
        lastPosition = position;
    }
}
