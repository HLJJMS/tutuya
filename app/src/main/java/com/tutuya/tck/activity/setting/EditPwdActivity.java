package com.tutuya.tck.activity.setting;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.GMAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.GMBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//密码更改界面
public class EditPwdActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.et_frist)
    EditText etFrist;
    @BindView(R.id.et_second)
    EditText etSecond;
    @BindView(R.id.ok)
    TextView ok;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_edit_pwd);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("设置新密码");
    }

    @OnClick({R.id.back, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
              finish();
                break;
            case R.id.ok:
                ok();
                break;
        }
    }

    private void ok() {
        if(!etFrist.getText().toString().equals(etSecond.getText().toString())){
            showToast("两次密码不一致");
        }else if (etFrist.getText().toString().equals("")){
            showToast("密码不能为空");
        }else{
            showLoading();
            Call<GMBean> call =inter.postPassWordTwo("user/password",getMyApplication().getToken(),"2",etFrist.getText().toString());
            call.enqueue(new Callback<GMBean>() {
                @Override
                public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                    if(response.body().getErrorcode().equals("200")){
                        showToast(response.body().getErrormessage());
                        finish();
                    }else{
                        showToast(response.body().getErrormessage());
                    }
                }

                @Override
                public void onFailure(Call<GMBean> call, Throwable t) {
                    showToast(inter.ERRORMESSAGE);
                }
            });
        }
    }
}
