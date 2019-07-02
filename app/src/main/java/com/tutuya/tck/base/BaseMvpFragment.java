package com.tutuya.tck.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.BuyVipActivity;
import com.tutuya.tck.activity.login.LoginActivity;
import com.tutuya.tck.activity.login.LoginMessageActivity;

import java.util.Map;
import java.util.Set;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 * 类名：fragment的基类
 */
public abstract class BaseMvpFragment<V, T extends BasePresenter<V>> extends Fragment {
    /**
     * ButterKnife的使用，官方在fragment中使用了解绑
     */
    protected T mPresenter; // Presenter对象
    private Dialog mWeiboDialog;
    protected Context mContext;
    protected View rootView;
    Unbinder unbinder;
    DisplayMetrics metric = new DisplayMetrics();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        initData();
        initPresenter();

    }

    protected abstract T createPresenter();

    protected abstract void initPresenter();

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
        mPresenter.detachView();
        unbinder.unbind();
    }

    protected abstract int getLayoutResId();

    protected int getWidth() {
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

    protected void goNewActivity(Class<?> activity, Map<String, String> map) {
        Intent intent = new Intent(getActivity(), activity);
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> me : set) {
            intent.putExtra(me.getKey(), me.getValue());
        }
        startActivity(intent);
    }

    protected void goNewActivity(Class<?> activity, Map<String, String> map, String token, boolean vip) {
        if (token.equals("")) {
            startActivity(new Intent(getActivity(), LoginMessageActivity.class));
        } else if (vip == false) {
          buyVip();
        } else {
            Intent intent = new Intent(getActivity(), activity);
            Set<Map.Entry<String, String>> set = map.entrySet();
            for (Map.Entry<String, String> me : set) {
                intent.putExtra(me.getKey(), me.getValue());
            }
            startActivity(intent);
        }
    }


    public void buyVip() {
        View view=LayoutInflater.from(mContext).inflate(R.layout.popup_buy_vip, null);
        final PopupWindow popupWindow = new PopupWindow(mContext);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setContentView(view);
        view.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),BuyVipActivity.class));
            }
        });
//        popupWindow.setBackgroundDrawable(new ColorDrawable(0xe0000000));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.isShowing();
        popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
    }






}
