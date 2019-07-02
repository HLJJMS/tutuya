package com.tutuya.tck.frament.home;


import com.tutuya.tck.bean.network.HomeClassingNewBean;
import com.tutuya.tck.bean.network.home.CommentingBean;
import com.tutuya.tck.bean.network.home.CouresRecommendBean;
import com.tutuya.tck.bean.network.home.FamousTeacherBean;
import com.tutuya.tck.bean.network.home.FiveEducation;

import java.util.List;

public interface IHomeView {

    void showToastI( String txt);
    //获取位置返回信息
    void showCity(String city);

    void setTeacherInfo(String id,String name, String className,String photoUrl );

    void setFiveEducation(List<FiveEducation.DataBean.CateBean> fiveEducation);

    void setFamousTeacher(List<FamousTeacherBean.DataBean.LectureBean> famousTeacher);

    void setCouresRecommend( List<HomeClassingNewBean.DataBeanX.DataBean> couresRecommend );

    void setCommenting(CommentingBean commenting);
}
