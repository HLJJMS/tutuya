package com.tutuya.tck.frament.home;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.bean.base.HomePositionBean;
import com.tutuya.tck.bean.network.FiveEducationOneListBean;
import com.tutuya.tck.bean.network.HomeClassingNewBean;
import com.tutuya.tck.bean.network.TeacherBean;
import com.tutuya.tck.bean.network.home.CommentingBean;
import com.tutuya.tck.bean.network.home.CouresRecommendBean;
import com.tutuya.tck.bean.network.home.FamousTeacherBean;
import com.tutuya.tck.bean.network.home.FiveEducation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.4 
 * @author  YUHENG.TIAN
 * @功能：主页FRAGMENT PRESENTER
 * @date 创建时间：2019.3.29
 */
public class HomePresent extends BasePresenter<IHomeView> implements IHomePresent {
    // 初始化VIEW
    private IHomeView view;

    public void getActivity() {
        if (isViewAttached()) {
            view = getView();
        }
    }


    //    获取位置请求
    @SuppressLint("MissingPermission")
    protected void getPosition(LocationManager lm) {
        double latitude = 0.0;//纬度
        double longitude = 0.0;//经度
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 50, 0, locationListener);
        Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Call<HomePositionBean> call = interGM.getPosition("http://api.map.baidu.com/geocoder?output=json", String.valueOf(latitude) + "," + String.valueOf(longitude), "tgilOzK0eduH0GYMve0ITWpiWp7VQC1m");
            call.enqueue(new Callback<HomePositionBean>() {
                @Override
                public void onResponse(Call<HomePositionBean> call, Response<HomePositionBean> response) {
                    if (response.body().getStatus().equals("OK")) {
                        view.showCity(response.body().getResult().getAddressComponent().getCity());
                    } else {
                        view.showToastI("获取位置失败，请手动选择城市");
                        view.showCity("定位失败");
                    }
                }

                @Override
                public void onFailure(Call<HomePositionBean> call, Throwable t) {
                    view.showToastI("获取位置失败，请手动选择城市");
                    view.showCity("定位失败");
                }
            });
        }
    }


    LocationListener locationListener = new LocationListener() {

        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        // Provider被enable时触发此函数，比如GPS被打开
        @Override
        public void onProviderEnabled(String provider) {

        }

        // Provider被disable时触发此函数，比如GPS被关闭
        @Override
        public void onProviderDisabled(String provider) {

        }

        //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
        @Override
        public void onLocationChanged(Location location) {
        }
    };

    public void getTeacherInfo(String token) {
        Call<TeacherBean> call = inter.getTeacherInfo("student/teacher", token);
        call.enqueue(new Callback<TeacherBean>() {
            @Override
            public void onResponse(Call<TeacherBean> call, Response<TeacherBean> response) {
                if (response.body().getErrorcode() == 200) {
                    view.setTeacherInfo(response.body().getData().getTeacher_id(), response.body().getData().getName(), response.body().getData().getClass_name(), response.body().getData().getHeadimgurl());
                } else {
                    view.showToastI("您的宝宝不是《中国聪明宝宝佩云工程主题幼儿园》的宝宝，无法使用本功能！");
                }
            }

            @Override
            public void onFailure(Call<TeacherBean> call, Throwable t) {
                view.showToastI("您的宝宝不是《中国聪明宝宝佩云工程主题幼儿园》的宝宝，无法使用本功能！");
            }
        });


    }

    @Override
    public void positionLister() {

    }


    public void getFiveEducation() {
        Call<FiveEducation> call = inter.getFiveEducation("index/index", "1");
        call.enqueue(new Callback<FiveEducation>() {
            @Override
            public void onResponse(Call<FiveEducation> call, Response<FiveEducation> response) {
                if (response.body().getErrorcode() == 200) {
                    view.setFiveEducation(response.body().getData().getCate());
                }
            }

            @Override
            public void onFailure(Call<FiveEducation> call, Throwable t) {
                view.showToastI(inter.ERRORMESSAGE);
            }
        });


    }

    public void getFamousTeacher() {
        Call<FamousTeacherBean> call = inter.getFamousTeacher("index/index", "2");
        call.enqueue(new Callback<FamousTeacherBean>() {
            @Override
            public void onResponse(Call<FamousTeacherBean> call, Response<FamousTeacherBean> response) {
                if (response.body().getErrorcode() == 200) {
                    view.setFamousTeacher(response.body().getData().getLecture());
                }
            }

            @Override
            public void onFailure(Call<FamousTeacherBean> call, Throwable t) {
                view.showToastI(inter.ERRORMESSAGE);
            }
        });

    }


    public void getCommenting() {
        Call<CommentingBean> call = inter.getCommenting("index/index", "4");
        call.enqueue(new Callback<CommentingBean>() {
            @Override
            public void onResponse(Call<CommentingBean> call, Response<CommentingBean> response) {
                if (response.body().getErrorcode() == 200) {
                    view.setCommenting(response.body());
                }
            }

            @Override
            public void onFailure(Call<CommentingBean> call, Throwable t) {
                view.showToastI(inter.ERRORMESSAGE);
            }
        });
    }


    public void getCouresRecommend() {
//        Call<CouresRecommendBean> call = inter.getCouresRecommend("index/index", "3");
//        call.enqueue(new Callback<CouresRecommendBean>() {
//            @Override
//            public void onResponse(Call<CouresRecommendBean> call, Response<CouresRecommendBean> response) {
//                if (response.body().getErrorcode() == 200) {
//                    view.setCouresRecommend(response.body().getData().getCourse());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CouresRecommendBean> call, Throwable t) {
//                view.showToastI(inter.ERRORMESSAGE);
//            }
//        });
    }


    public void getClassTwo(String id,String token) {
        Call<HomeClassingNewBean> call = inter.getHomeClassingList("course/get_cate_theme",token,"50","1",id);
        call.enqueue(new Callback<HomeClassingNewBean>() {
            @Override
            public void onResponse(Call<HomeClassingNewBean> call, Response<HomeClassingNewBean> response) {
                if (response.body().getErrorcode()==200){
                    view.setCouresRecommend(response.body().getData().getData());
                }


            }

            @Override
            public void onFailure(Call<HomeClassingNewBean> call, Throwable t) {

            }
        });



    }
}
