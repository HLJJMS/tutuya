package com.tutuya.tck.activity.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.HomeActivity;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.base.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//设置界面
public class SettingActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.headimg)
    ImageView headimg;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.iclass)
    TextView iclass;
    @BindView(R.id.school)
    TextView school;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.patriarch)
    TextView patriarch;
    @BindView(R.id.edit_psw)
    TextView editPsw;
    @BindView(R.id.edit_tel)
    TextView editTel;
    @BindView(R.id.lbg)
    Guideline lbg;
    @BindView(R.id.exit)
    TextView exit;
    String txtName, txtImg;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("个人设置");
        Intent intent = getIntent();
        txtImg = getIntent().getStringExtra("img");
        txtName = getIntent().getStringExtra("name");
        name.setText(txtName);
        iclass.setText(getIntent().getStringExtra("school"));
        school.setText("智慧豆：" + getIntent().getStringExtra("rmb"));
        setPhoto();
    }

    private void setPhoto() {
        Glide.with(this).load(txtImg).apply(RequestOptions.bitmapTransform(new CircleCrop()).signature(new ObjectKey(System.currentTimeMillis()))).into(headimg);
    }

    @OnClick({R.id.back, R.id.ll, R.id.my_info, R.id.patriarch, R.id.edit_psw, R.id.edit_tel, R.id.exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Intent intent = new Intent();
                intent.putExtra("image", txtImg);
                setResult(200, intent);
                finish();
                break;
            case R.id.my_info:
                Intent user = new Intent(this, UserDetailActivity.class);
                user.putExtra("img", txtImg);
                user.putExtra("name", txtName);
                startActivityForResult(user, 100);
                break;
            case R.id.patriarch:
                Intent patriarch = new Intent(this, ParentsInfoActivity.class);
                startActivity(patriarch);
                break;
            case R.id.edit_psw:
                Intent pwd = new Intent(this, TelVerifyActivity.class);
                pwd.putExtra("type", "user/password");
                pwd.putExtra("phone", getIntent().getStringExtra("phone"));
                startActivity(pwd);
                break;
            case R.id.edit_tel:
                Intent tel = new Intent(this, TelVerifyActivity.class);
                tel.putExtra("type", "user/phone");
                tel.putExtra("phone", getIntent().getStringExtra("phone"));
                startActivity(tel);
                break;
            case R.id.exit:
                getMyApplication().setToken("");
                SharedPreferences sharedPreferences = getSharedPreferences("tutuyaInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("token", "");
                editor.commit();
                EventBus.getDefault().post("ok");
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            txtImg = data.getStringExtra("image");
            setPhoto();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent();
            intent.putExtra("image", txtImg);
            setResult(200, intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
