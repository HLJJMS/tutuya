package com.tutuya.tck.activity.headtest;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.Gson;
import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.GetJsonDataUtil;
import com.tutuya.tck.bean.base.CityBean;
import com.tutuya.tck.bean.base.GMCheckNullBean;
import com.tutuya.tck.bean.network.BabyDetailBean;
import com.tutuya.tck.bean.network.BabyListBean;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.HeadCityFindAreaBean;
import com.tutuya.tck.tools.Util;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @author  tyh
 * @功能：脑测评添加
 * @date 创建时间：2019/4/17
 */
public class AddHeadTestActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.bt_city)
    TextView btCity;
    @BindView(R.id.bt_address)
    TextView btAddress;
    @BindView(R.id.bt_sex)
    TextView btSex;
    @BindView(R.id.bt_birthday)
    TextView btBirthday;
    @BindView(R.id.bt_hand)
    TextView btHand;
    @BindView(R.id.bt_date)
    TextView btDate;
    @BindView(R.id.bt_school)
    TextView btSchool;
    @BindView(R.id.bt_name)
    EditText btName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.star_city)
    TextView starCity;
    @BindView(R.id.star_name)
    TextView starName;
    @BindView(R.id.star_sex)
    TextView starSex;
    @BindView(R.id.star_birthday)
    TextView starBirthday;
    @BindView(R.id.star_phone)
    TextView starPhone;
    @BindView(R.id.star_hand)
    TextView starHand;
    @BindView(R.id.star_date)
    TextView starDate;
    @BindView(R.id.star_school)
    TextView starSchool;
    @BindView(R.id.star_address)
    TextView starAddress;
    private List<GMCheckNullBean> checkBean = new ArrayList<>();
    private List<BabyListBean.DataBean> babyList = new ArrayList<>();
    private SimpleDateFormat sdf;
    private List<CityBean> provinceBean = new ArrayList<>();
    private List<ArrayList<CityBean.ChildrenBeanX>> cityBean = new ArrayList<>();
    private List<String> sexList = new ArrayList<>(), handList = new ArrayList<>();
    private Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();
    //    城市代码
    private boolean isAddress = false;
    private String token, cityCode, provinceCode, classCode, schoolCode, sexCode, addressCode, handCode, nameCode = "";
    private List<HeadCityFindAreaBean.DataBeanX.DataBean> headAddressList = new ArrayList<>();
    private int year, month, day;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_add_head_test);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("添加预约");
        token = getMyApplication().getToken();
        getCity();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sexList.add("男");
        sexList.add("女");
        handList.add("左手");
        handList.add("右手");
        startDate.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        year = startDate.get(Calendar.YEAR);
        month = startDate.get(Calendar.MONTH);
        day = startDate.get(Calendar.DATE);
        viewSource();
    }

    private void viewSource() {
        btSchool.setClickable(false);
        String source = getIntent().getStringExtra("source");
        if (source.equals("其他")) {
            btSchool.setText("无");
            starCity.setTextColor(0x00ff0000);
            starName.setTextColor(0x00ff0000);
            starSex.setTextColor(0x00ff0000);
            starBirthday.setTextColor(0x00ff0000);
            starAddress.setTextColor(0x00ff0000);
            starSchool.setText("");
        } else if (source.equals("在园")) {
            btCity.setClickable(false);
            btName.setClickable(false);
            btSex.setClickable(false);
            nameCode = getIntent().getStringExtra("id");


            getBabyInfo(nameCode);


        } else {
            btCity.setClickable(false);
            btName.setClickable(false);
            btSex.setClickable(false);
            nameCode = getIntent().getStringExtra("id");
            starBirthday.setTextColor(0x00ff0000);


            getBabyInfo(nameCode);

        }


    }


    @OnClick({R.id.back, R.id.bt_city, R.id.bt_address, R.id.bt_sex, R.id.bt_birthday, R.id.bt_hand, R.id.bt_date, R.id.bt_school, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_city:
                selectCity();
                break;
            case R.id.bt_address:
                if (isAddress == true) {
                    selectAddress();
                } else {
                    showToast("请重新选择城市");
                }
                break;
            case R.id.bt_sex:
                selectSex();
                break;
            case R.id.bt_birthday:
                selectbirthDay();
                break;
            case R.id.bt_hand:
                selectHand();
                break;
            case R.id.bt_date:
                selectDate();
                break;
            case R.id.bt_school:
                showEditTxt("编辑学校", btSchool);
                break;
            case R.id.ok:
                checkNull();
                break;

        }
    }





    /*------------------------------------------------选择器--------------------------------------------------------------------------------------*/

    // 选择城市
    private void selectCity() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt2tx = cityBean.size() > 0 ?
                        cityBean.get(options1).get(options2).getLabel() : "";
                cityCode = cityBean.get(options1).get(options2).getValue();
                provinceCode = provinceBean.get(options1).getValue();
                btCity.setText(opt2tx + "市");
                getAddress();
            }
        })
                .setTitleText("城市选择")
                .isCenterLabel(false)
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(provinceBean, cityBean);//二级选择器*/
        pvOptions.show();

    }

    // 选择脑测评地址
    private void selectAddress() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                btAddress.setText(headAddressList.get(options1).getLabel());
                addressCode = headAddressList.get(options1).getValue();
            }
        })
                .setTitleText("选择脑测评地址")
                .isCenterLabel(false)
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(headAddressList);//二级选择器*/
        pvOptions.show();

    }


    //    选择性别
    private void selectSex() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                btSex.setText(sexList.get(options1));
                sexCode = String.valueOf(options1 + 1);
            }
        }).build();
        pvOptions.setPicker(sexList);
        pvOptions.show();
    }

    //    选择日期
    private void selectDate() {
        startDate.set(year, month, day);
        endDate.set(year + 10, month, day);
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                btDate.setText(sdf.format(date));
            }
        }).setTitleText("选择日期").setRangDate(startDate, endDate)
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    //    选择生日
    private void selectbirthDay() {
        startDate.set(year - 18, month, day);
        endDate.set(year, month, day);
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                btBirthday.setText(sdf.format(date));
            }
        }).setTitleText("选择日期").setRangDate(startDate, endDate)
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    //    利手选择器
    private void selectHand() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                btHand.setText(handList.get(options1));
                handCode = String.valueOf(options1 + 1);
            }
        }).build();
        pvOptions.setPicker(handList);
        pvOptions.show();
    }


    /*------------------------------------------------选择器结束--------------------------------------------------------------------------------------*/
    //  弹出输入框
    private void showEditTxt(String title, final TextView view) {
        final EditText et = new EditText(this);
        AlertDialog.Builder etName = new AlertDialog.Builder(this);
        etName.setTitle(title);
        etName.setView(et);
        etName.setPositiveButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                view.setText(et.getText());
            }
        }).setNegativeButton("取消", null).show();
    }

    private void checkNull() {
        checkBean.clear();
        checkBean.add(new GMCheckNullBean("姓名", nameCode));
        checkBean.add(new GMCheckNullBean("性别", sexCode));
        checkBean.add(new GMCheckNullBean("城市", cityCode));
        checkBean.add(new GMCheckNullBean("区域", addressCode));
        checkBean.add(new GMCheckNullBean("生日", btBirthday));
        checkBean.add(new GMCheckNullBean("利手", handCode));
        checkBean.add(new GMCheckNullBean("预约日期", btDate));
        checkBean.add(new GMCheckNullBean("所在学校", btSchool));
        String result = Util.checkNull(checkBean, etPhone.getText().toString());
        if (result.equals("ok")) {
            submit();
        } else {
            showToast(result);
        }
    }

    /*-----------------------------------------------------关于网络请求--------------------------------------------------------------------------*/

    private void getCity() {
//        showLoading();
        String JsonData = new GetJsonDataUtil().getJson(this, "data.json");//获取assets目录下的json文件数据
        try {
            JSONArray data = new JSONArray(JsonData);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                provinceBean.add(gson.fromJson(data.optJSONObject(i).toString(), CityBean.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < provinceBean.size(); i++) {//遍历省份
            ArrayList<CityBean.ChildrenBeanX> cityList = new ArrayList<>();//该省的城市列表（第二级）
            for (int c = 0; c < provinceBean.get(i).getChildren().size(); c++) {//遍历该省份的所有城市
                cityList.add(provinceBean.get(i).getChildren().get(c));
            }
            cityBean.add(cityList);
        }
//        closeLoading();
    }

    private void getAddress() {
        Call<HeadCityFindAreaBean> call = inter.getHeadTestArea("qqtree/get_identity_area", getMyApplication().getToken(), provinceCode, cityCode);
        call.enqueue(new Callback<HeadCityFindAreaBean>() {
            @Override
            public void onResponse(Call<HeadCityFindAreaBean> call, Response<HeadCityFindAreaBean> response) {
                if (response.body().getErrorcode() == 200) {
                    if (response.body().getData().getData().size() > 0) {
                        headAddressList.clear();
                        headAddressList.addAll(response.body().getData().getData());
                        isAddress = true;
                    }
                } else {
                    isAddress = false;
                    showToast(response.body().getErrormessage());
                }
            }

            @Override
            public void onFailure(Call<HeadCityFindAreaBean> call, Throwable t) {
                Log.e("脑测评获取地址", t.getMessage());
                showToast(inter.ERRORMESSAGE);
                isAddress = false;
            }
        });
    }

    //    获取宝宝详情
    private void getBabyInfo(String id) {
        Log.e("我是宝宝id", id);
        Call<BabyDetailBean> call = inter.getBabyDetail("baby/babyinfo", token, id);
        call.enqueue(new Callback<BabyDetailBean>() {
            @Override
            public void onResponse(Call<BabyDetailBean> call, Response<BabyDetailBean> response) {
                if (response.body().getErrorcode() == 200) {
                    btBirthday.setText(response.body().getData().getBirthday());
                    btSchool.setText(response.body().getData().getSchool_name());
                    sexCode = response.body().getData().getSex();
                    btSex.setText(sexList.get(Integer.valueOf(response.body().getData().getSex()) - 1));
                    btCity.setText(response.body().getData().getCity_name());
                    btName.setText(response.body().getData().getName());
                    if (response.body().getData().getSchool_name().equals("")) {
                        btSchool.setText("无");
                    } else {
                        btSchool.setText(response.body().getData().getSchool_name());
                    }
                } else {
                    showToast(inter.ERRORMESSAGE);
                }
            }

            @Override
            public void onFailure(Call<BabyDetailBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });
    }


    /*-----------------------------------------------------关于网络请求结束--------------------------------------------------------------------------*/
    //    提交数据
    private void submit() {
        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("api", "qqtree/app_add")
                .addFormDataPart("token", getMyApplication().getToken())
                .addFormDataPart("baby_id", nameCode)
                .addFormDataPart("name", btName.getText().toString())
                .addFormDataPart("phone", etPhone.getText().toString())
                .addFormDataPart("sex", sexCode)
                .addFormDataPart("birth", btBirthday.getText().toString())
                .addFormDataPart("handedness", handCode)
                .addFormDataPart("school_name", btSchool.getText().toString())
                .addFormDataPart("id", addressCode)
                .addFormDataPart("address", btAddress.getText().toString())
                .addFormDataPart("appo_date", btDate.getText().toString())
                .build();
        Call<GMBean> call = inter.editOrAddDate(requestBody);
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    finish();

                } else {
                    showToast(inter.ERRORMESSAGE);
                }

            }

            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                Log.e("新建宝宝信息", t.getMessage());
            }
        });
    }

}
