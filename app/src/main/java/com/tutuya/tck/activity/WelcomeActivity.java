package com.tutuya.tck.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.HomeBannerBean;
import com.tutuya.tck.bean.network.HomeBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @author  tyh
 * @功能：欢迎页
 * @date 创建时间：2019/4/19
 */
public class WelcomeActivity extends BaseActivity {
    private HomeBean.DataBean bean ;
    private List<HomeBannerBean.DataBean> bannerList = new ArrayList<>();
    @Override
    protected void initView() {
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void initData() {
        SharedPreferences sharedPreferences = getSharedPreferences("tutuyaInfo", MODE_PRIVATE);
        if (sharedPreferences != null) {
            String token = sharedPreferences.getString("token", "");
                getMyApplication().setToken(token);
            getData();
        }
    }
//    加载数据
    private void getData() {
        getBanner();

    }

//    //    获取首页数据
//    private void getData() {
//        Call<HomeBean> call = inter.getHomeData("index/index", getMyApplication().getToken());
//        call.enqueue(new Callback<HomeBean>() {
//            @Override
//            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
//                if (response.body().getErrorcode() == 200) {
//                    bean = response.body().getData();
//                    goHome();
//                } else {
//
//                    showToast("数据加载失败，请刷新重试");
//                    goHome();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HomeBean> call, Throwable t) {
//
//                showToast("数据加载失败，请刷新重试");
//                goHome();
//            }
//        });
//
//    }


//    获取轮播图
    private void getBanner(){
        Call<HomeBannerBean> call = inter.getBanner("common/banner","6");
        call.enqueue(new Callback<HomeBannerBean>() {
            @Override
            public void onResponse(Call<HomeBannerBean> call, Response<HomeBannerBean> response) {
                if (response.body().getErrorcode()==200){
                    bannerList.clear();
                    bannerList.addAll(response.body().getData());
                    goHome();
                }
            }

            @Override
            public void onFailure(Call<HomeBannerBean> call, Throwable t) {

            }
        });


    }



    private void goHome() {
        Intent intent = new Intent(this,HomeActivity.class);
//       intent.putExtra("banner",bean);
        intent.putParcelableArrayListExtra("banner",(ArrayList<? extends Parcelable>) bannerList);
        startActivity(intent);
        finish();
    }
}
