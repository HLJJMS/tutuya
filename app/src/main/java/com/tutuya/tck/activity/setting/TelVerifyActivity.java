package com.tutuya.tck.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.PhoneMessageBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//修改信息时候的手机验证界面
public class TelVerifyActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.button_number)
    TextView buttonNumber;
    @BindView(R.id.ok)
    TextView ok;
    @BindView(R.id.tel)
    TextView tel;
    private String type, phone;
    private int time;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_tel_verify);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("手机验证");
        //type的值为1时代表更改密码，为0时候代表更改手机号
        type = getIntent().getStringExtra("type");
        phone = getIntent().getStringExtra("phone");
        tel.setText("请输入 " +phone+" 收到的验证码");

    }

    @OnClick({R.id.back, R.id.button_number, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.button_number:
                startTimer();
                getMessage();
                break;
            case R.id.ok:
                sumbit();
                break;
        }
    }

    //    获取短信
    private void getMessage() {
        Call<PhoneMessageBean> call = inter.getPhoneMessage("common/sendsms",phone,"3",getMyApplication().getToken());
        call.enqueue(new Callback<PhoneMessageBean>() {
            @Override
            public void onResponse(Call<PhoneMessageBean> call, Response<PhoneMessageBean> response) {
                showToast(response.message());
            }

            @Override
            public void onFailure(Call<PhoneMessageBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                Log.e("错误信息",t.getMessage());
            }
        });

    }

    private void sumbit() {
        if (etNumber.getText().toString().equals("")) {
            showToast("验证码不能为空");
        } else if (tel.getText().equals("")) {
            showToast("账号不能为空");
        } else if (tel.getText().length() != 11) {
            showToast("手机号码填写错误");
        } else {
            Call<GMBean> call = inter.postPassPhoneOrWord(type,getMyApplication().getToken(),"1",etNumber.getText().toString());
            call.enqueue(new Callback<GMBean>() {
                @Override
                public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                    if (response.body().getErrorcode().equals("200")){
                        goToActivity();
                        showToast(response.body().getErrormessage());
                    }else{
                        showToast(response.body().getErrormessage());
                    }
                }
                @Override
                public void onFailure(Call<GMBean> call, Throwable t) {
                    showToast(inter.ERRORMESSAGE);
                    Log.e("错误结果",t.getMessage());
                }
            });

        }
    }

    //定时器60s
    private void startTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonNumber.setEnabled(false);
                buttonNumber.setText(millisUntilFinished / 1000 + "秒后重发");
            }

            @Override
            public void onFinish() {
                buttonNumber.setEnabled(true);
                buttonNumber.setText("重新发送");
            }
        }.start();
    }

    private void goToActivity() {
        if(type.equals("user/password")){
            startActivity(new Intent(this,EditPwdActivity.class));
            finish();
        }else{
            startActivity(new Intent(this,EditPhoneActivity.class));
            finish();
        }
    }

}
