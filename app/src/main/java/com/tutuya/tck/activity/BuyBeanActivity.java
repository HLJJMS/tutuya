package com.tutuya.tck.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.BuyBeanAdapter;
import com.tutuya.tck.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuyBeanActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.headImg)
    ImageView headImg;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_sum)
    TextView txtSum;
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.check_weixin)
    RadioButton checkWeixin;
    @BindView(R.id.check_zhifubao)
    RadioButton checkZhifubao;
    @BindView(R.id.ok)
    TextView ok;
    BuyBeanAdapter adapter;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_buy_bean);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        txtName.setText(getIntent().getStringExtra("name"));
        txtSum.setText(getIntent().getStringExtra("rmb"));
        photoOk(getIntent().getStringExtra("img"));
        adapter = new BuyBeanAdapter(getMyApplication().getWidth()*92/100,this);
        rec.setLayoutManager(new GridLayoutManager(this, 3));
        rec.setAdapter(adapter);
        headTitle.setText("充值");
    }


    public void photoOk(String url) {
        Glide.with(this).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop()).signature(new ObjectKey(System.currentTimeMillis()))).into(headImg);
    }

    @OnClick({R.id.back, R.id.check_weixin, R.id.check_zhifubao})
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
        }
    }
}
