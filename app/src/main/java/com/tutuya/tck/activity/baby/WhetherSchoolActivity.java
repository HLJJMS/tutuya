package com.tutuya.tck.activity.baby;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.BabyWetherSchoolBean;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.GetJsonDataUtil;
import com.tutuya.tck.bean.base.CityBean;
import com.tutuya.tck.bean.network.SchoolBean;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WhetherSchoolActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.bt_yes)
    TextView btYes;
    @BindView(R.id.bt_no)
    TextView btNo;
    @BindView(R.id.bt_city)
    TextView btCity;
    @BindView(R.id.rec)
    RecyclerView rec;
    private List<CityBean> provinceBean = new ArrayList<>();
    private List<ArrayList<CityBean.ChildrenBeanX>> cityBean = new ArrayList<>();
    private String cityCode,provinceCode;
    private BabyWetherSchoolBean adapter = new BabyWetherSchoolBean();
    @Override
    protected void initView() {
        setContentView(R.layout.activity_whether_school);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("幼儿园选择");
        getCityList();
        rec.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        rec.setAdapter(adapter);
    }

    @OnClick({R.id.back, R.id.bt_yes, R.id.bt_no, R.id.bt_city})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_yes:
                Intent yesIntent = new Intent(this,AddBabyActivity.class);
                yesIntent.putExtra("id","0");
                startActivity(yesIntent);
                break;
            case R.id.bt_no:
                Intent noIntent = new Intent(this,AddUnSchoolBabyActivity.class);
                noIntent.putExtra("id","0");
                startActivity(noIntent);
                break;
            case R.id.bt_city:
                showPickerView();
                break;
        }
    }

    //    获取城市列表
    private void getCityList() {
        showLoading();
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
        closeLoading();
    }
    private void getShool() {
        Call<SchoolBean> call = inter.getSchoolList("common/getschool", provinceCode, cityCode);
        call.enqueue(new Callback<SchoolBean>() {
            @Override
            public void onResponse(Call<SchoolBean> call, Response<SchoolBean> response) {
                if (response.body().getErrorcode().equals("200") && response.body().getData().size() > 0) {

                    adapter.setBean(response.body().getData());
                } else {
                    showToast(inter.ERRORMESSAGE);
                }
            }

            @Override
            public void onFailure(Call<SchoolBean> call, Throwable t) {
                Log.e("获取学校列表异常", t.getMessage());
                showToast(inter.ERRORMESSAGE);
            }
        });
    }
    // 选择地址
    private void showPickerView() {

        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置

                String opt2tx = cityBean.size() > 0 ?
                        cityBean.get(options1).get(options2).getLabel() : "";
                cityCode = cityBean.get(options1).get(options2).getValue();
                provinceCode = provinceBean.get(options1).getValue();
                btCity.setText(opt2tx + "市");
                getShool();
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
}
