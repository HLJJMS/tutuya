package com.tutuya.tck.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tutuya.tck.R;
/*
* activity基础类 mvp
* create  by   田羽衡
*
* */
public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    private Dialog mWeiboDialog;
    private Context context;
    protected T mPresenter; // Presenter对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        context = this;
        mWeiboDialog = new Dialog(context);
        initView();
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        initData();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    protected abstract T createPresenter();

    protected abstract void initPresenter();
    /**
     * 绑定UI布局，以及初始化UI控件
     */
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();

    }

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
