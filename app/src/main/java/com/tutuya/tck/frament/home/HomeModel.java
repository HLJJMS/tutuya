package com.tutuya.tck.frament.home;

public class HomeModel  implements IHomeModel {
    @Override
    public void getPosion(String location) {

    }
//
//    @Override
//    public void getPosion(String location) {
//        Call<HomePositionBean> call = inter.getPosition("http://api.map.baidu.com/geocoder?output=json", String.valueOf(latitude) +"," +String.valueOf(longitude), "tgilOzK0eduH0GYMve0ITWpiWp7VQC1m");
//        call.enqueue(new Callback<HomePositionBean>() {
//            @Override
//            public void onResponse(Call<HomePositionBean> call, Response<HomePositionBean> response) {
//                if (response.body().getStatus().equals("OK")){
//                    city[0] = response.body().getResult().getAddressComponent().getCity();
//                    Log.e("定位结果",city[0]);
//                }else{
//                    view.showToastI("获取位置失败，请手动选择城市");
//                }
//            }
//            @Override
//            public void onFailure(Call<HomePositionBean> call, Throwable t) {
//                view.showToastI("获取位置失败，请手动选择城市");
//            }
//        });
//    }
}
