package com.tutuya.tck.activity.setting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.base.GMCheckNullBean;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.UserInfoBean;
import com.tutuya.tck.tools.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//家长信息列表
public class ParentsInfoActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.et_name)
    TextView etName;
    @BindView(R.id.link)
    TextView link;
    @BindView(R.id.et_link)
    TextView etLink;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.et_sex)
    TextView etSex;
    @BindView(R.id.profession)
    TextView profession;
    @BindView(R.id.et_profession)
    TextView etProfession;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.et_address)
    TextView etAddress;
    @BindView(R.id.id_type)
    TextView idType;
    @BindView(R.id.et_id_type)
    TextView etIdType;
    @BindView(R.id.code)
    TextView code;
    @BindView(R.id.et_code)
    TextView etCode;
    @BindView(R.id.ok)
    TextView ok;
    private List<String> sexList = new ArrayList<>(), occupationList = new ArrayList<>(), linkList = new ArrayList<>();
    private int codeP, codeS;
    private List<GMCheckNullBean> gmCheckNullBeans = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_parents_info);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("家长信息");
        setList();
        getInfo();
    }

    private void setList() {
        sexList.clear();
        sexList.add("男");
        sexList.add("女");
        occupationList.clear();
        occupationList.add("计算机/互联网/通信/电子");
        occupationList.add("销售/客服/技术支持");
        occupationList.add("会计/金融/银行/保险");
        occupationList.add("生产/运营/采购/物流");
        occupationList.add("生物/制药/医疗/护理");
        occupationList.add("广告/市场/媒体/艺术");
        occupationList.add("建筑/房地产");
        occupationList.add("人事/行政/高级管理");
        occupationList.add("咨询/法律/教育/科研");
        occupationList.add("服务业");
        occupationList.add("公务员/翻译/其他");
        linkList.add("父子");
        linkList.add("母子");
        linkList.add("父女");
        linkList.add("母女");
        linkList.add("祖父");
        linkList.add("祖母");
        linkList.add("外祖母");
        linkList.add("外祖父");
    }

    @OnClick({R.id.back, R.id.name, R.id.link, R.id.sex, R.id.profession, R.id.address, R.id.id_type, R.id.code, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.name:
                showEdit("修改昵称", etName);
                break;
            case R.id.link:
                selectLink();
                break;
            case R.id.sex:
                selectSex();
                break;
            case R.id.profession:
                selectProfessional();
                break;
            case R.id.address:
                showEdit("修改地址", etAddress);
                break;
            case R.id.id_type:
                break;
            case R.id.code:
                showEdit("修改身份证号", etCode);
                break;
            case R.id.ok:
                checkInfo();
                break;
        }
    }

    //    手动输入的修改
    private void showEdit(String txt, final TextView view) {
        final EditText et = new EditText(this);
        et.setText(view.getText());
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(txt);
        dialog.setView(et).setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                view.setText(et.getText());
            }
        }).setNegativeButton("取消", null).show();
    }


    private void selectLink() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etLink.setText(linkList.get(options1));
            }
        }).build();
        pvOptions.setPicker(linkList);
        pvOptions.show();
    }

    private void selectSex() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etSex.setText(sexList.get(options1));
                codeS = options1 + 1;
            }
        }).build();
        pvOptions.setPicker(sexList);
        pvOptions.show();
    }

    private void selectProfessional() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etProfession.setText(occupationList.get(options1));
                codeP = options1 + 1;
            }
        }).build();
        pvOptions.setPicker(occupationList);
        pvOptions.show();
    }


    private void getInfo() {
        showLoading();
        Call<UserInfoBean> call = inter.getUserInfo("user/user", getMyApplication().getToken());
        call.enqueue(new Callback<UserInfoBean>() {
            @Override
            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    etName.setText(response.body().getData().getRealname());
                    etLink.setText(response.body().getData().getRelationship());
                    etSex.setText(response.body().getData().getSex_show());
                    etAddress.setText(response.body().getData().getAddress());
                    etProfession.setText(response.body().getData().getOccupation_show());
                    etCode.setText(response.body().getData().getId_val());
                } else {
                    showToast(response.body().getErrormessage());
                }
                closeLoading();
            }

            @Override
            public void onFailure(Call<UserInfoBean> call, Throwable t) {
                Log.e("返回值异常", t.toString());
                showToast(inter.ERRORMESSAGE);
                closeLoading();
            }
        });
    }


    //    检查前台验证
    private void checkInfo() {
        gmCheckNullBeans.clear();
        gmCheckNullBeans.add(new GMCheckNullBean("昵称", etName));
        gmCheckNullBeans.add(new GMCheckNullBean("与子女关系", etLink));
        gmCheckNullBeans.add(new GMCheckNullBean("性别", codeS));
        gmCheckNullBeans.add(new GMCheckNullBean("职业类别", codeP));
        gmCheckNullBeans.add(new GMCheckNullBean("家庭住址",etAddress));
        String result = Util.checkNull(gmCheckNullBeans);
        if(!result.equals("ok")){
            showToast(result);
        }else if(!Util.validateIdNumber(etName.getText().toString())){
            showToast("身份证格式错误");
        }else{
            postInfo();
        }


    }


    private void postInfo() {
        showLoading();
        Log.e("", "");
        Call<GMBean> call = inter.postPrasentInfo("user/edituser", getMyApplication().getToken(), etName.getText().toString(), etLink.getText().toString(), String.valueOf(codeS), String.valueOf(codeP), etAddress.getText().toString(), "1", etCode.getText().toString());
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                showToast(response.body().getErrormessage());
                closeLoading();
            }

            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                Log.e("返回值异常", t.toString());
                showToast(inter.ERRORMESSAGE);
                closeLoading();
            }
        });

    }


}
