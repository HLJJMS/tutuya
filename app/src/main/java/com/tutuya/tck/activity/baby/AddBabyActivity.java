package com.tutuya.tck.activity.baby;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.google.gson.Gson;
import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.GetJsonDataUtil;
import com.tutuya.tck.base.UriToFliePath;
import com.tutuya.tck.bean.base.CityBean;
import com.tutuya.tck.bean.base.GMCheckNullBean;
import com.tutuya.tck.bean.network.BabyClassBean;
import com.tutuya.tck.bean.network.BabyDetailBean;
import com.tutuya.tck.bean.network.BabyImageBean;
import com.tutuya.tck.bean.network.BabyInClassBean;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.SchoolBean;
import com.tutuya.tck.tools.Util;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;


import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/*宝宝添加列表*/
public class AddBabyActivity extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.et_name)
    TextView etName;
    @BindView(R.id.et_id)
    TextView etId;
    @BindView(R.id.et_sex)
    TextView etSex;
    @BindView(R.id.et_city)
    TextView etCity;
    @BindView(R.id.et_school)
    TextView etSchool;
    @BindView(R.id.et_class)
    TextView etClass;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_class)
    TextView tvClass;
    //    日期选择器使用
    private List<String> sexList = new ArrayList<>();
    private List<BabyInClassBean.DataBean> babyNameList = new ArrayList<>();
    private Context context;
    private Uri mImageUri;
    private UriToFliePath uriToFliePath = new UriToFliePath();
    private String HEAD_ICON_NAME = "head", imageUrl = "", type;
    private int PHOTO_ALBUM = 0,CAMERA=2, REQUESTCODE_CUTTING = 1;
    private List<CityBean> provinceBean = new ArrayList<>();
    private List<ArrayList<CityBean.ChildrenBeanX>> cityBean = new ArrayList<>();
    private SchoolBean schoolList = new SchoolBean();
    private BabyClassBean classList = new BabyClassBean();
    private List<GMCheckNullBean> gmCheckNullBean = new ArrayList<>();
    //    城市代码
    private String cityCode = "0", provinceCode = "0", classCode = "0", schoolCode = "0", sexCode = "1", babyCode = "";

    private boolean isSchool = false, isClass = false, isName = false;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_add_baby);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        babyCode = getIntent().getStringExtra("id");
        if (!babyCode.equals("0")) {
            etId.setClickable(false);
            etName.setClickable(false);
            etSchool.setClickable(false);
            etClass.setClickable(false);
            etCity.setClickable(false);
            getData();
        }
        inital();
        getData();
    }


    private void inital() {
        context = this;
        headTitle.setText("添加宝宝信息");
        getCityList();
    }


    @OnClick({R.id.et_id, R.id.et_name, R.id.image, R.id.back, R.id.et_city, R.id.et_school, R.id.et_class, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.et_city:
                showPickerView();
                break;
            case R.id.et_school:
                if (isSchool == true) {
                    selectSchool();
                } else {
                    showToast("请重新选择城市");
                }
                break;
            case R.id.et_class:
                if (isClass == true) {
                    selectClass();
                } else {
                    showToast("请重新选择学校");
                }
                break;
            case R.id.ok:
                checkData();
                break;
            case R.id.image:
                MPermissions.requestPermissions(this, 4, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
                break;
            case R.id.et_id:

                break;
            case R.id.et_name:
                if (isName == true) {
                    selectName();
                } else {
                    showToast("请重新选择班级");
                }
                break;
        }
    }

    //    数据非空验证
    private void checkData() {
        gmCheckNullBean.clear();
        gmCheckNullBean.add(new GMCheckNullBean("头像", imageUrl));
        gmCheckNullBean.add(new GMCheckNullBean("姓名", babyCode));
        String result = Util.checkNull(gmCheckNullBean);
        if (!result.equals("ok")) {
            showToast(result);
        } else {
            submitNew();
        }
    }

    /*---------------------------------------------------输入框开始---------------------------------------------------*/

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


    /*---------------------------------------------------输入框结束---------------------------------------------------*/


    /*---------------------------------------------------选择器开始---------------------------------------------------*/


    //    选择姓名
    private void selectName() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etName.setText(babyNameList.get(options1).getName());
                etId.setText(babyNameList.get(options1).getIdcard());
                babyCode = babyNameList.get(options1).getBaby_id();
            }
        }).build();
        pvOptions.setPicker(babyNameList);
        pvOptions.show();
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
                etCity.setText(opt2tx + "市");
                getShool();
                etSchool.setText("");
                schoolCode = "";
                classCode = "";
                etClass.setText("");
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

    //    选择学校
    private void selectSchool() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etSchool.setText(schoolList.getData().get(options1).getName());
                schoolCode = schoolList.getData().get(options1).getId();
                getClassList();
                classCode = "";
                etClass.setText("");
            }
        }).build();
        pvOptions.setPicker(schoolList.getData());
        pvOptions.show();
    }

    //选择班级
    private void selectClass() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etClass.setText(classList.getData().get(options1).getName());
                classCode = classList.getData().get(options1).getId();
                getBaby();
            }
        }).build();
        pvOptions.setPicker(classList.getData());
        pvOptions.show();
    }

    /*---------------------------------------------------选择器结束---------------------------------------------------*/


    /*---------------------------------------------------图片处理部分---------------------------------------------------*/

    @PermissionGrant(4)
    public void requestContactSuccess() {
        showSelectPhotoOrCamera();
//        getPhoto();
    }

    private void showSelectPhotoOrCamera() {
        View parent = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);

        PopupWindow popupWindow = new PopupWindow();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow, null);
        view.findViewById(R.id.bt_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCarmera();
            }


        });
        view.findViewById(R.id.bt_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhoto();
            }
        });
        popupWindow.setHeight(WRAP_CONTENT);
        popupWindow.setWidth(WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        popupWindow.isShowing();
    }

    @PermissionDenied(4)
    public void requestContactFailed() {
        Toast.makeText(this, "权限禁止", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void getPhoto() {
        mImageUri = Uri.fromFile(new File(this.getExternalCacheDir(), HEAD_ICON_NAME + ".png"));
        // 创建打开系统图库的意图
        Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(pickIntent, PHOTO_ALBUM);
    }

    private void getCarmera() {
        mImageUri = Uri.fromFile(new File(this.getExternalCacheDir(), HEAD_ICON_NAME + ".png"));
        Intent pickIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
        pickIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
        startActivityForResult(pickIntent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_ALBUM) {
            if (resultCode == 0) {
                Toast.makeText(this, "操作取消", Toast.LENGTH_LONG).show();
            } else {
                startPhotoZoom(data.getData());
            }
        } else if (requestCode == REQUESTCODE_CUTTING) {
            if (resultCode == 0) {
                Toast.makeText(this, "操作取消", Toast.LENGTH_LONG).show();
            } else {
                postPhoto(uriToFliePath.getPhotoPathFromContentUri(this, mImageUri));
            }
        }else if(requestCode == CAMERA){
            if (resultCode == 0){
                Toast.makeText(this, "操作取消", Toast.LENGTH_LONG).show();
            }else {
                startPhotoZoom(mImageUri);
            }
        }
    }


    //    开启裁剪模式
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高，这里可以将宽高作为参数传递进来
        intent.putExtra("outputX", 70);
        intent.putExtra("outputY", 70);
        // 设置裁剪后的数据不以bitmap的形式返回，剪切后图片的位置，图片是否压缩等
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        // 调用系统的图片剪切
        startActivityForResult(intent, REQUESTCODE_CUTTING);
    }

    //    设置头像图片
    private void setPhoto(String url) {
        Glide.with(this).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop()).signature(new ObjectKey(System.currentTimeMillis()))).into(image);
    }


    /*---------------------------------------------------图片处理部分结束---------------------------------------------------*/




    /*-----------------------------------------------------关于网络请求--------------------------------------------------------------------------*/


    //    如果是编辑信息时请求详情数据
    private void getData() {
        Call<BabyDetailBean> call = inter.getBabyDetail("baby/babyinfo", getMyApplication().getToken(), babyCode);
        call.enqueue(new Callback<BabyDetailBean>() {
            @Override
            public void onResponse(Call<BabyDetailBean> call, Response<BabyDetailBean> response) {
                if (response.body().getErrorcode() == 200) {
                    etName.setText(response.body().getData().getName());
                    etCity.setText(response.body().getData().getCity_name());
                    classCode = response.body().getData().getClass_id();
                    cityCode = response.body().getData().getCity_id();
                    provinceCode = response.body().getData().getProvince_id();
                    schoolCode = response.body().getData().getSchool_id();
                    etSchool.setText(response.body().getData().getSchool_name());
                    etClass.setText(response.body().getData().getClass_name());
                    etSex.setText(response.body().getData().getSex_show());
                    etId.setText(response.body().getData().getIdcard());
                    imageUrl = response.body().getData().getPhoto();
                    setPhoto(response.body().getData().getPhoto_show());

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


    //    提交数据(老版)
    private void submit() {

        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("api", "baby/babyae")
                .addFormDataPart("token", getMyApplication().getToken())
                .addFormDataPart("name", etName.getText().toString())
                .addFormDataPart("sex", sexCode)
                .addFormDataPart("idcard", etId.getText().toString())
                .addFormDataPart("school_id", schoolCode)
                .addFormDataPart("class_id", classCode)
                .addFormDataPart("baby_id", babyCode)
                .addFormDataPart("photo", imageUrl)
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

    //    保存信息新版
    private void submitNew() {
        Call<GMBean> call = inter.postBabyInfo("baby/babyae_tck", getMyApplication().getToken(), babyCode, imageUrl);
        Log.e("卧室图片的地址发送的", imageUrl);
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    showToast(response.body().getErrormessage());
                    finish();
                } else {
                    showToast(response.body().getErrormessage());
                }
            }

            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                Log.e("获取学校列表异常", t.getMessage());
            }
        });
    }

    private void getShool() {
        Call<SchoolBean> call = inter.getSchoolList("common/getschool", provinceCode, cityCode);
        call.enqueue(new Callback<SchoolBean>() {
            @Override
            public void onResponse(Call<SchoolBean> call, Response<SchoolBean> response) {
                if (response.body().getErrorcode().equals("200") && response.body().getData().size() > 0) {

                    schoolList = response.body();

                    isSchool = true;
                } else {
                    showToast(inter.ERRORMESSAGE);
                    isSchool = false;
                }
            }

            @Override
            public void onFailure(Call<SchoolBean> call, Throwable t) {
                Log.e("获取学校列表异常", t.getMessage());
                showToast(inter.ERRORMESSAGE);
                isSchool = false;
            }
        });
    }

    private void getClassList() {
        Call<BabyClassBean> call = inter.getClassList("common/getclass", schoolCode);
        call.enqueue(new Callback<BabyClassBean>() {
            @Override
            public void onResponse(Call<BabyClassBean> call, Response<BabyClassBean> response) {
                if (response.body().getErrorcode().equals("200") && response.body().getData().size() > 0) {
                    classList = response.body();

                    isClass = true;
                } else {
                    showToast(inter.ERRORMESSAGE);
                    isClass = false;
                }
            }

            @Override
            public void onFailure(Call<BabyClassBean> call, Throwable t) {
                Log.e("获取学校列表异常", t.getMessage());
                showToast(inter.ERRORMESSAGE);
                isClass = false;
            }
        });
    }

    //    向服务器发送照片
    private void postPhoto(final String url) {
        File file = new File(url);
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("api", "common/upload")
                .addFormDataPart("token", getMyApplication().getToken())
                .addFormDataPart("f_type", "2")
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file)).build();
        Call<BabyImageBean> call = inter.postBabyPhoto(requestBody);
        call.enqueue(new Callback<BabyImageBean>() {
            @Override
            public void onResponse(Call<BabyImageBean> call, Response<BabyImageBean> response) {
                if (response.body().getErrorcode() == 200) {
                    imageUrl = response.body().getData().getPhoto();
                    setPhoto(response.body().getData().getPhoto_show());


                } else {
                    showToast(inter.ERRORMESSAGE);
                }
            }

            @Override
            public void onFailure(Call<BabyImageBean> call, Throwable t) {
                Log.e("上传宝宝头像异常", t.getMessage());
                showToast(inter.ERRORMESSAGE);
            }
        });
    }


    private void getBaby() {
        Call<BabyInClassBean> call = inter.getNameForClass("common/get_class_baby", classCode);
        call.enqueue(new Callback<BabyInClassBean>() {
            @Override
            public void onResponse(Call<BabyInClassBean> call, Response<BabyInClassBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    if (response.body().getData().size() > 0) {
                        babyNameList.clear();
                        babyNameList.addAll(response.body().getData());
                        isName = true;
                    } else {
                        showToast("暂无数据");
                        isName = false;
                    }
                } else {
                    isName = false;
                }
            }

            @Override
            public void onFailure(Call<BabyInClassBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                isName = false;
            }
        });


    }
    /*-----------------------------------------------------关于网络请求结束--------------------------------------------------------------------------*/
}