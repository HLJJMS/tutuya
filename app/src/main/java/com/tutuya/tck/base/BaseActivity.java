package com.tutuya.tck.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.tutuya.tck.R;
import com.tutuya.tck.base.retrofit.InterfaceForRetrofit;
import com.tutuya.tck.base.retrofit.Retrofit;
import com.tutuya.tck.base.retrofit.RetrofitGM;

/*
 * activity基础类（MVC）
 * create  田羽衡   2019
 * */
public abstract class BaseActivity extends AppCompatActivity {
    private Dialog mWeiboDialog;

    protected Retrofit retrofit = Retrofit.getRetrofit();
    protected RetrofitGM retrofitgm = RetrofitGM.getRetrofit();
    protected InterfaceForRetrofit inter = retrofit.getService();
    protected InterfaceForRetrofit interGM = retrofitgm.getService();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        context = this;
        mWeiboDialog = new Dialog(context);
        initView();
        initData();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 绑定UI布局，以及初始化UI控件
     */
    protected abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    public void showToast(String txt) {
        Toast.makeText(context, txt, Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {
        mWeiboDialog = WeiboDialogUtils.createLoadingDialog(context, "加载中...");
    }

    public void closeLoading() {
        WeiboDialogUtils.closeDialog(mWeiboDialog);
    }

    public MyApplication getMyApplication() {
        return ((MyApplication) getApplicationContext());
    }

    //    跳转类
    protected void startActivity(Class<?> activity) {
        Intent intent = new Intent(getBaseContext(), activity);
        startActivity(intent);
    }

}
