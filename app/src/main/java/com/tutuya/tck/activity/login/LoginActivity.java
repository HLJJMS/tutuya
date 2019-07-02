package com.tutuya.tck.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.HomeActivity;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.LoginBean;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//登录页（常规）
public class LoginActivity extends BaseActivity {
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
    @BindView(R.id.not)
    TextView not;
    @BindView(R.id.book)
    TextView book;
    Context context;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        context = this;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ok, R.id.message, R.id.regist, R.id.book,R.id.bt_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ok:
                postRequest();
                break;
            case R.id.message:
                startActivity(LoginMessageActivity.class);
                finish();
                break;
            case R.id.regist:
                startActivity(RegisterActivity.class);
                finish();
                break;
            case R.id.book:
                break;
            case R.id.bt_back:
                startActivity(LoginMessageActivity.class);
                finish();
                break;
        }
    }

    private void postRequest() {
        if (psw.getText().toString().equals("")) {
            showToast("密码不能为空");
        } else if (userId.getText().equals("")) {
            showToast("账号不能为空");
        } else if (userId.getText().length() != 11) {
            showToast("手机号码填写错误");
        } else {
            Call<LoginBean> call = inter.loginUserId("login/login", userId.getText().toString(), psw.getText().toString(), "2");
            call.enqueue(new Callback<LoginBean>() {
                @Override
                public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                    if (response.body().getErrorcode() == 200) {
                        EventBus.getDefault().post("ok");
                        showToast(response.body().getErrormessage());
                        successLogin(response.body().getData().getToken());
                        getMyApplication().setToken(response.body().getData().getToken());
                        startActivity(HomeActivity.class);
                        finish();
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
    }

//    登陆成功后保存token

    private void successLogin(String id) {
        SharedPreferences sharedPreferences = getSharedPreferences("tutuyaInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", id);
        editor.commit();
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
