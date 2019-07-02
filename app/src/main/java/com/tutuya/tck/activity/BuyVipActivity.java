package com.tutuya.tck.activity;

import android.support.constraint.Guideline;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuyVipActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.image_head)
    ImageView imageHead;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.check_weixin)
    RadioButton checkWeixin;
    @BindView(R.id.check_zhifubao)
    RadioButton checkZhifubao;
    @BindView(R.id.ok)
    TextView ok;
    @BindView(R.id.lrg)
    Guideline lrg;
    @BindView(R.id.rrg)
    Guideline rrg;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_buy_vip);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("童创客会员");
    }

    @OnClick({R.id.back, R.id.check_weixin, R.id.check_zhifubao, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.check_weixin:
                checkZhifubao.setChecked(false);
                break;
            case R.id.check_zhifubao:
                checkWeixin.setChecked(false);
                break;
            case R.id.ok:
                break;
        }
    }
}
