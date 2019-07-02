package com.tutuya.tck.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.tutuya.tck.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
* 地图的demoactivity\
*
* */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bmapView)
    MapView bmapView;
    @BindView(R.id.walk)
    TextView walk;
    @BindView(R.id.drive)
    TextView drive;
    @BindView(R.id.bus)
    TextView bus;
    LatLng point = new LatLng(39.963175, 116.400244);
    private BaiduMap baiduMap;
    private RoutePlanSearch mSearch; // 搜索模块，也可去掉地图模块独立使用
    private MapLocationListener locationListener = new MapLocationListener();
    private LocationClient locationClient;
    private LocationClientOption option = new LocationClientOption();
    private MapLocationListener mapLocationListener = new MapLocationListener();
    PlanNode stNode = PlanNode.withCityNameAndPlaceName("北京", "西二旗地铁站");
    PlanNode enNode = PlanNode.withCityNameAndPlaceName("北京", "百度科技园");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getLocation();
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_gcoding);
//构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap).alpha(0.5f).perspective(false);
//在地图上添加Marker，并显示
        baiduMap.addOverlay(option);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
    }


    private void getLocation() {
        locationClient = new LocationClient(this);
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        //设置locationClientOption
        locationClient.setLocOption(option);
        locationClient.registerLocationListener(mapLocationListener);
        //注册LocationListener监听器

        baiduMap = bmapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        //开启地图定位图层
        locationClient.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        bmapView.onPause();
    }

    @Override
    protected void onDestroy() {
        locationClient.stop();
        baiduMap.setMyLocationEnabled(false);
        bmapView.onDestroy();
        bmapView = null;
        super.onDestroy();

    }

    @OnClick({R.id.walk, R.id.drive, R.id.bus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.walk:
                mSearch.walkingSearch((new WalkingRoutePlanOption())
                        .from(stNode)
                        .to(enNode));
                break;
            case R.id.drive:
                mSearch.drivingSearch((new DrivingRoutePlanOption())
                        .from(stNode)
                        .to(enNode));
                break;
            case R.id.bus:
                mSearch.transitSearch((new TransitRoutePlanOption())
                        .from(stNode)
                        .to(enNode));
                break;
        }
    }


    public class MapLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(bdLocation.getDirection()).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            baiduMap.setMyLocationData(locData);
        }
    }

}
