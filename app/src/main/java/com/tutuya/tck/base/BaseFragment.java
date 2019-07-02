package com.tutuya.tck.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tutuya.tck.base.retrofit.InterfaceForRetrofit;
import com.tutuya.tck.base.retrofit.Retrofit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/*
* fragment基础类mvc
* create  by  田羽衡
*
*
*
* */
public abstract class BaseFragment extends Fragment {

    /**
     * ButterKnife的使用，官方在fragment中使用了解绑
     */
    protected Retrofit retrofit = Retrofit.getRetrofit();
    protected InterfaceForRetrofit inter = retrofit.getService();
    private Dialog mWeiboDialog;
    protected Context mContext;
    protected View rootView;
    Unbinder unbinder;
    DisplayMetrics metric = new DisplayMetrics();
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        initData();

    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化布局文件
     *
     * @param rootView
     */
    protected abstract void initView(View rootView);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);

        if (getActivity() != null) {
            mContext = getActivity();
        }
        mWeiboDialog = new Dialog(mContext);
        initView(rootView);
        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected abstract int getLayoutResId();

    protected int getWidth(){
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }
    public void showToast(String txt) {
        Toast.makeText(mContext, txt, Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {
        mWeiboDialog = WeiboDialogUtils.createLoadingDialog(mContext, "加载中...");
    }

    public void closeLoading() {
        WeiboDialogUtils.closeDialog(mWeiboDialog);
    }


}
