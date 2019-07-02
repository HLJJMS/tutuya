package com.tutuya.tck.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.HomeActivity;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.PhoneMessageBean;
import com.tutuya.tck.bean.network.LoginBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//注册
public class RegisterActivity extends BaseActivity {


    @BindView(R.id.user_id)
    EditText userId;
    @BindView(R.id.psw)
    EditText psw;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.book)
    TextView book;
    @BindView(R.id.forget)
    TextView forget;

    Context context;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {


    }


    @OnClick({R.id.ok, R.id.forget, R.id.book,R.id.bt_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok:
                if (userId.getText().toString().equals("")) {
                    showToast("手机号不能为空");
                } else if (psw.getText().toString().equals("")) {
                    showToast("验证码不能为空");
                } else if(userId.getText().length()!=11) {
                    showToast("手机号码输入有误");
                }else{
                    ok();
                }
                break;
            case R.id.forget:
                if (userId.getText().toString().equals("")) {
                    showToast("请输入手机号");
                } else if(userId.getText().length()!=11){
                    showToast("手机号码输入有误");
                }else{
                    showToast("短信已发送");
                    startTimer();
                    getMessage();
                }
                break;
            case R.id.book:
                break;
            case R.id.bt_back:
                startActivity(LoginMessageActivity.class);
                finish();
                break;
        }
    }


    //定时器60s
    private void startTimer() {
        CountDownTimer timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                forget.setEnabled(false);
                forget.setText(millisUntilFinished / 1000 + "秒后重发");
            }

            @Override
            public void onFinish() {
                forget.setEnabled(true);
                forget.setText("重新发送");
            }
        }.start();
    }

    //    获取短信验证码
    private void getMessage() {
        Call<PhoneMessageBean> call = inter.getPhoneMessage("common/sendsms", userId.getText().toString(), "2");
        call.enqueue(new Callback<PhoneMessageBean>() {
            @Override
            public void onResponse(Call<PhoneMessageBean> call, Response<PhoneMessageBean> response) {
                showToast(response.body().getErrormessage());
            }

            @Override
            public void onFailure(Call<PhoneMessageBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });
    }

    //    完成注册
    private void ok() {
        Call<LoginBean> call = inter.register("login/register", userId.getText().toString(), psw.getText().toString());
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                if (response.body().getErrorcode() == 200) {
                    showToast("注册成功");
                    registerSuccess(response.body().getData().getToken());
                } else {
                    showToast(response.body().getErrormessage());
                }
            }
            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });
    }

    private void registerSuccess(String token) {
        getMyApplication().setToken(token);
        startActivity(HomeActivity.class);
        SharedPreferences sharedPreferences = getSharedPreferences("tutuyaInfo", MODE_PRIVATE);
        getMyApplication().setToken(token);
        EventBus.getDefault().post("ok");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.commit();
        finish();
    }

    //    监听返回键让其跳转至密码登录
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == 4) {
            startActivity(LoginMessageActivity.class);
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
