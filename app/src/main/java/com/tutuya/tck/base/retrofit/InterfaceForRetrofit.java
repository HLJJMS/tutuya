package com.tutuya.tck.base.retrofit;

import com.tutuya.tck.bean.base.HomePositionBean;
import com.tutuya.tck.bean.base.TalkBean;
import com.tutuya.tck.bean.network.BabyClassBean;
import com.tutuya.tck.bean.network.BabyDetailBean;
import com.tutuya.tck.bean.network.BabyImageBean;
import com.tutuya.tck.bean.network.BabyInClassBean;
import com.tutuya.tck.bean.network.BabyListBean;
import com.tutuya.tck.bean.network.FiveEducationOneListBean;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.GMStringBean;
import com.tutuya.tck.bean.network.GiftBean;
import com.tutuya.tck.bean.network.GiftListForTeacherBean;
import com.tutuya.tck.bean.network.HeadCityFindAreaBean;
import com.tutuya.tck.bean.network.HeadDetailBean;
import com.tutuya.tck.bean.network.HeadTestListBean;
import com.tutuya.tck.bean.network.HomeBannerBean;
import com.tutuya.tck.bean.network.HomeBean;
import com.tutuya.tck.bean.network.HomeClassingNewBean;
import com.tutuya.tck.bean.network.PhoneMessageBean;
import com.tutuya.tck.bean.network.LoginBean;
import com.tutuya.tck.bean.network.SchoolBean;
import com.tutuya.tck.bean.network.TeacherBean;
import com.tutuya.tck.bean.network.TeacherListBean;
import com.tutuya.tck.bean.network.UserInfoBean;
import com.tutuya.tck.bean.network.classing.ClassHomeBean;
import com.tutuya.tck.bean.network.classing.FamousTeacherInfoBean;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListBean;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListPlayBean;
import com.tutuya.tck.bean.network.home.CommentingBean;
import com.tutuya.tck.bean.network.home.CouresRecommendBean;
import com.tutuya.tck.bean.network.home.FamousTeacherBean;
import com.tutuya.tck.bean.network.home.FiveEducation;

import java.io.File;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface InterfaceForRetrofit {
    public String ERRORMESSAGE = "操作异常，请稍后重试";
    public String SUCCESS = "操作成功";


    // 更新大文件
    @Streaming
    @GET("")
    Call<ResponseBody> downloadFileUrl();

    //上传图片
    @POST
    Call<ResponseBody> upPhoto(@Url String url, @Query("fload") String fload, @Query("pictureFile") File file);

    // 获取位置百度
    @GET("")
    Call<HomePositionBean> getPosition(@Url String url, @Query("location") String position, @Query("ak") String longitude);

    //发送手机短信验证码(from,用户区分发送模块 ：1-登录 2-注册 3-修改)
    @FormUrlEncoded
    @POST("index.php")
    Call<PhoneMessageBean> getPhoneMessage(@Field("api") String api, @Field("phone") String phone, @Field("from") String from);

    @FormUrlEncoded
    @POST("index.php")
    Call<PhoneMessageBean> getPhoneMessage(@Field("api") String api, @Field("phone") String phone, @Field("from") String from, @Field("token") String token);

    //注册接口

    @FormUrlEncoded
    @POST("index.php")
    Call<LoginBean> register(@Field("api") String api, @Field("phone") String phone, @Field("code") String code);

    //  登录接口（账号登录）

    @FormUrlEncoded
    @POST("index.php")
    Call<LoginBean> loginUserId(@Field("api") String api, @Field("username") String username, @Field("password") String password, @Field("type") String type);

    // 登录接口(手机登录)

    @FormUrlEncoded
    @POST("index.php")
    Call<LoginBean> loginPhone(@Field("api") String api, @Field("phone") String phone, @Field("code") String code, @Field("type") String type);

    //获取个人信息

    @FormUrlEncoded
    @POST("index.php")
    Call<UserInfoBean> getUserInfo(@Field("api") String api, @Field("token") String id);

    // 改名字

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postName(@Field("api") String api, @Field("token") String id, @Field("nickname") String name);

    // 上傳圖片 f_type 类型 0默认 1 用户头像 2 宝宝头像
    @POST("index.php")
    Call<GMStringBean> postPhoto(@Body RequestBody Body);

    // 上傳圖片 f_type 类型 0默认 1 用户头像 2 宝宝头像
    @POST("index.php")
    Call<BabyImageBean> postBabyPhoto(@Body RequestBody Body);

    //更改家长信息
//   
    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postPrasentInfo(@Field("api") String api, @Field("token") String id, @Field("realname") String realname, @Field("relationship") String relationship, @Field("sex") String sex, @Field("occupation") String occupation, @Field("address") String address, @Field("id_type") String id_type, @Field("id_val") String id_val);

    // 改密码手机号第一步

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postPassPhoneOrWord(@Field("api") String api, @Field("token") String id, @Field("step") String step, @Field("code") String code);

    // 改密码第二步

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postPassWordTwo(@Field("api") String api, @Field("token") String id, @Field("step") String step, @Field("new_password") String new_password);

    // 改手机号第二部

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postPhoneTwo(@Field("api") String api, @Field("token") String id, @Field("step") String step, @Field("code") String code, @Field("new_phone") String new_phone);

    // 改密码手机号第一步

    @FormUrlEncoded
    @POST("index.php")
    Call<BabyListBean> getBabyList(@Field("api") String api, @Field("token") String id);

    // 宝宝信息详情

    @FormUrlEncoded
    @POST("index.php")
    Call<BabyDetailBean> getBabyDetail(@Field("api") String api, @Field("token") String id, @Field("baby_id") String baby_id);

    // 宝宝信息修改增加(脑测评)
    @POST("index.php")
    Call<GMBean> editOrAddDate(@Body RequestBody Body);

    // 获取学校信息

    @FormUrlEncoded
    @POST("index.php")
    Call<SchoolBean> getSchoolList(@Field("api") String api, @Field("province_id") String province_id, @Field("city_id") String city_id);


    // 获取学校信息

    @FormUrlEncoded
    @POST("index.php")
    Call<BabyClassBean> getClassList(@Field("api") String api, @Field("school_id") String school_id);

    // 删除宝宝

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> delBaby(@Field("api") String api, @Field("token") String token, @Field("baby_id") String baby_id);

    // 根据城市查找测评地址(脑测评)

    @FormUrlEncoded
    @POST("index.php")
    Call<HeadCityFindAreaBean> getHeadTestArea(@Field("api") String api, @Field("token") String token, @Field("province_id") String province_id, @Field("city_id") String city_id);

    // 脑测评列表

    @FormUrlEncoded
    @POST("index.php")
    Call<HeadTestListBean> getHeadTestList(@Field("api") String api, @Field("token") String token, @Field("page") int page, @Field("page_size") int page_size);

    // 脑测评详情

    @FormUrlEncoded
    @POST("index.php")
    Call<HeadDetailBean> getHeadDetail(@Field("api") String api, @Field("token") String token, @Field("id") String id);


    // 首页已废弃

    @FormUrlEncoded
    @POST("index.php")
    Call<HomeBean> getHomeData(@Field("api") String api, @Field("token") String token);


    // 加载轮播图

    @FormUrlEncoded
    @POST("index.php")
    Call<HomeBannerBean> getBanner(@Field("api") String api, @Field("model") String model);


    // 获取宝宝名字根据班级

    @FormUrlEncoded
    @POST("index.php")
    Call<BabyInClassBean> getNameForClass(@Field("api") String api, @Field("class_id") String class_id);


    // 保存宝宝信息  新版(在园宝宝)

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postBabyInfo(@Field("api") String api, @Field("token") String token, @Field("baby_id") String baby_id, @Field("photo") String photo);


    // 获取礼物清单

    @FormUrlEncoded
    @POST("index.php")
    Call<GiftBean> getGiftList(@Field("api") String api, @Field("token") String token);

    // 获取老师信息


    @FormUrlEncoded
    @POST("index.php")
    Call<TeacherBean> getTeacherInfo(@Field("api") String api, @Field("token") String token);


    // 发送礼物

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postGift(@Field("api") String api, @Field("token") String token, @Field("teacher_id") String teacher_id, @Field("gift_id") String gift_id, @Field("anonymous") String anonymous, @Field("vc_gift_count") String vc_gift_count);


    // 获取礼物清单费老师的

    @FormUrlEncoded
    @POST("index.php")
    Call<GiftListForTeacherBean> getGiftListForTeacher(@Field("api") String api, @Field("token") String token, @Field("teacher_id") String teacher_id, @Field("page") String page, @Field("page_size") String page_size);


    // 聊天记录

    @FormUrlEncoded
    @POST("index.php")
    Call<TalkBean> getTalkRecord(@Field("api") String api, @Field("token") String token, @Field("teacher_id") String teacher_id, @Field("page") String page, @Field("page_size") String page_size);


    // 发送礼物

    @FormUrlEncoded
    @POST("index.php")
    Call<GMBean> postTxt(@Field("api") String api, @Field("token") String token, @Field("teacher_id") String teacher_id, @Field("content") String content);

    /*——————————————————————————————————首页内容——————————————————————————————————*/
    // 获取首页五大教育

    @FormUrlEncoded
    @POST("index.php")
    Call<FiveEducation> getFiveEducation(@Field("api") String api, @Field("type") String type);

    // 名师讲堂

    @FormUrlEncoded
    @POST("index.php")
    Call<FamousTeacherBean> getFamousTeacher(@Field("api") String api, @Field("type") String type);


    // 课程推荐

    @FormUrlEncoded
    @POST("index.php")
    Call<CouresRecommendBean> getCouresRecommend(@Field("api") String api, @Field("type") String type);


    //在线讲评

    @FormUrlEncoded
    @POST("index.php")
    Call<CommentingBean> getCommenting(@Field("api") String api, @Field("type") String type);



    /*——————————————————————————————————首页内容结束——————————————————————————————————*/


    /*——————————————————————————————————在线课堂——————————————————————————————————*/
//    在线课堂首页

    @FormUrlEncoded
    @POST("index.php")
    Call<ClassHomeBean> getClassing(@Field("api") String api);


    //名师信息

    @FormUrlEncoded
    @POST("index.php")
    Call<FamousTeacherInfoBean> getFamousTeacherInfo(@Field("api") String api, @Field("token") String token, @Field("lecturer_id") String lecturer_id);


    //名师课程列表

    @FormUrlEncoded
    @POST("index.php")
    Call<FamousTeacherVideoListBean> getFamousTeacherVideo(@Field("api") String api, @Field("token") String token, @Field("page_size") String page_size, @Field("page") String page, @Field("lecturer_id") String lecturer_id);

    //名师课程列表(播放)

    @FormUrlEncoded
    @POST("index.php")
    Call<FamousTeacherVideoListPlayBean> getFamousTeacherVideoPlay(@Field("api") String api, @Field("token") String token, @Field("them_id") String them_id);

    //五大教育列表

    @FormUrlEncoded
    @POST("index.php")
    Call<FiveEducationOneListBean> getFiveEducationListVideo(@Field("api") String api, @Field("token") String token, @Field("category") String category, @Field("page_size") String page_size, @Field("page") String page);


//    获取老师列表

    @FormUrlEncoded
    @POST("index.php")
    Call<TeacherListBean> getTeacherList(@Field("api") String api, @Field("token") String token, @Field("page_size") String page_size, @Field("page") String page, @Field("is_recommend") String is_recommend);

//    获取首页课程列表

    @FormUrlEncoded
    @POST("index.php")
    Call<HomeClassingNewBean> getHomeClassingList(@Field("api") String api, @Field("token") String token, @Field("page_size") String page_size, @Field("page") String page, @Field("category") String category);




}
