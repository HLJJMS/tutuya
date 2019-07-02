package com.tutuya.tck.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.HomeActivity;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.LoginBean;
import com.tutuya.tck.bean.network.PhoneMessageBean;


import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//登录页 手机短息
public class LoginMessageActivity extends BaseActivity {
    @BindView(R.id.user_id)
    EditText userId;
    @BindView(R.id.psw)
    EditText psw;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.regist)
    TextView regist;
    @BindView(R.id.book)
    TextView book;
    @BindView(R.id.forget)
    TextView forget;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
//        userId.setHint("请输入手机号");
//        psw.setHint("输入验证码");
        userId.setText("19845269239");
        psw.setText("1208");
        message.setText("账号密码登录");
        forget.setText("获取验证码");

    }

    @OnClick({R.id.ok, R.id.message, R.id.regist, R.id.book, R.id.forget,R.id.bt_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok:
                login();
                break;
            case R.id.message:
                startActivity(LoginActivity.class);
                finish();
                break;
            case R.id.regist:
                startActivity(RegisterActivity.class);
                finish();
                break;
            case R.id.book:
                break;
            case R.id.forget:
                startTimer();
                getCode();
                break;
            case R.id.bt_back:
                EventBus.getDefault().post("ok");
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

    //    获取验证码
    private void getCode() {


         if (userId.getText().length()!=11){
            showToast("手机号码填写错误");
        }else{
            Call<PhoneMessageBean> call = inter.getPhoneMessage("common/sendsms", userId.getText().toString(), "1");
            call.enqueue(new Callback<PhoneMessageBean>() {
                @Override
                public void onResponse(Call<PhoneMessageBean> call, Response<PhoneMessageBean> response) {
                    showToast(response.body().getErrormessage());
                    Log.e("请问去问问企鹅请问",response.body().toString());
                }

                @Override
                public void onFailure(Call<PhoneMessageBean> call, Throwable t) {
                    showToast(inter.ERRORMESSAGE);
                }
            });
        }

    }


    private void login() {
        if(!psw.getText().toString().equals("")&&!userId.getText().equals("")){
            Call<LoginBean> call = inter.loginPhone("login/login",userId.getText().toString(),psw.getText().toString(),"1");
            call.enqueue(new Callback<LoginBean>() {
                @Override
                public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                    if(response.body().getErrorcode()==200){
                        showToast(response.body().getErrormessage());
                        registerSuccess(response.body().getData().getToken());
                    }else{
                        showToast(response.body().getErrormessage());
                    }
                }
                @Override
                public void onFailure(Call<LoginBean> call, Throwable t) {
                    showToast(inter.ERRORMESSAGE);
                }
            });

        }else{
            showToast("用户名密码不能为空");
        }

    }
    private void registerSuccess(String token){

        SharedPreferences sharedPreferences = getSharedPreferences("tutuyaInfo", MODE_PRIVATE);
        getMyApplication().setToken(token);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.commit();
        EventBus.getDefault().post("ok");
        startActivity(HomeActivity.class);
        finish();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        EventBus.getDefault().post("ok");
        finish();
        return true;
    }
}
