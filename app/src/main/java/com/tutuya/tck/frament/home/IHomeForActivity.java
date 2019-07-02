package com.tutuya.tck.frament.home;

import com.tutuya.tck.bean.network.HomeBannerBean;
import com.tutuya.tck.bean.network.HomeBean;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：与activity通讯使用
 * @date 创建时间：2019/4/19
 */
public interface IHomeForActivity {
//    void setData(HomeBean.DataBean bean);
    void setData( List<HomeBannerBean.DataBean> bannerList);

    void getToken(String token , boolean vip);


}
