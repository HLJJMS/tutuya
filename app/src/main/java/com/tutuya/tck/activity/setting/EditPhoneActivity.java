package com.tutuya.tck.activity.setting;

import android.os.CountDownTimer;
import android.os.Handler;
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
//手机号码更改界面

public class EditPhoneActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.button_number)
    TextView buttonNumber;
    @BindView(R.id.ok)
    TextView ok;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_edit_phone);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("修改手机号");
    }

    @OnClick({R.id.back, R.id.button_number, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.button_number:
                if (tel.getText().toString().equals("")) {
                    showToast("手机号码不可为空");
                } else {
                    startTimer();
                    getMessage();
                }
                break;
            case R.id.ok:
                sumbit();
                break;
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

    //    获取短信
    private void getMessage() {
        Call<PhoneMessageBean> call = inter.getPhoneMessage("common/sendsms", tel.getText().toString(), "3", getMyApplication().getToken());
        call.enqueue(new Callback<PhoneMessageBean>() {
            @Override
            public void onResponse(Call<PhoneMessageBean> call, Response<PhoneMessageBean> response) {
                showToast(response.message());
            }

            @Override
            public void onFailure(Call<PhoneMessageBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                Log.e("错误信息", t.getMessage());
            }
        });
    }

    //    提交更改
    private void sumbit() {
        if (etNumber.getText().toString().equals("")) {
            showToast("验证码不能为空");
        } else if (tel.getText().equals("")) {
            showToast("账号不能为空");
        } else if (tel.getText().length() != 11) {
            showToast("手机号码填写错误");
        } else {
            Call<GMBean> call = inter.postPhoneTwo("user/phone", getMyApplication().getToken(), "2", etNumber.getText().toString(), tel.getText().toString());
            call.enqueue(new Callback<GMBean>() {
                @Override
                public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                    if (response.body().getErrorcode().equals("200")) {
                        showToast(response.body().getErrormessage());
                        finish();
                    } else {
                        showToast(response.body().getErrormessage());
                    }
                }

                @Override
                public void onFailure(Call<GMBean> call, Throwable t) {
                    showToast(inter.ERRORMESSAGE);
                    Log.e("我是改电话第二部", t.getLocalizedMessage());
                }
            });


        }

    }
}