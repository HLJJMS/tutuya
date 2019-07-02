package com.tutuya.tck.frament.my;

import android.util.Log;

import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.bean.base.ClassingTeacherBean;
import com.tutuya.tck.bean.network.TeacherBean;
import com.tutuya.tck.bean.network.UserInfoBean;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPresenter extends BasePresenter<IMyView> {
    private  IMyView view;

    // 初始化VIEW
    public void getActivity(){
        if (isViewAttached()) {
            view = getView();
        } else {
            return;
        }
    }
    public void getVersion(int version){
        view.showDialog();
    }
    public void upLoadImg(String path){
//        inter = retrofit.getService();
        File file = new File(path);
        Call<ResponseBody> call =  inter.upPhoto("http://47.104.145.21:8080/RrdNewAppProject/upload/uploadImage","user",file);
        call.enqueue(new Callback<ResponseBody>(){

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    response.body();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    view.showToast(inter.ERRORMESSAGE);
            }
        });
    }

    public void getUserInfo(String id){
        view.showLoading();
        Call<UserInfoBean> call = inter.getUserInfo("user/user",id);
        call.enqueue(new Callback<UserInfoBean>() {
            @Override
            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                if(response.body().getErrorcode().equals("200")){
                    if (response.body().getData().getNickname().equals("")){
                        view.setDataUser(response.body().getData().getUsername(),response.body().getData().getSchool_name(),response.body().getData().getHeadimgurl(),response.body().getData().getVc_balance(),response.body().getData().getPhone());
                    }else{
                        view.setDataUser(response.body().getData().getNickname(),response.body().getData().getSchool_name(),response.body().getData().getHeadimgurl(),response.body().getData().getVc_balance(),response.body().getData().getPhone());
                    }
                }else{
                    view.showToast(response.body().getErrormessage());
                }
                view.closeLoading();
            }

            @Override
            public void onFailure(Call<UserInfoBean> call, Throwable t) {
                Log.e("返回值异常",t.toString());
                view.showToast(inter.ERRORMESSAGE);
                view.closeLoading();
            }
        });
    }

    public void getTeacherInfo(String token){
        Call<TeacherBean> call = inter.getTeacherInfo("student/teacher",token);
        call.enqueue(new Callback<TeacherBean>() {
            @Override
            public void onResponse(Call<TeacherBean> call, Response<TeacherBean> response) {
                if(response.body().getErrorcode()==200){
                    view.setTeacherInfo(response.body().getData().getTeacher_id(),response.body().getData().getName(),response.body().getData().getClass_name(),response.body().getData().getHeadimgurl());
                }else{
                    view.showToast("您的宝宝不是《中国聪明宝宝佩云工程主题幼儿园》的宝宝，无法使用本功能！");
                }
            }

            @Override
            public void onFailure(Call<TeacherBean> call, Throwable t) {
                view.showToast("您的宝宝不是《中国聪明宝宝佩云工程主题幼儿园》的宝宝，无法使用本功能！");
            }
        });





    }



}
