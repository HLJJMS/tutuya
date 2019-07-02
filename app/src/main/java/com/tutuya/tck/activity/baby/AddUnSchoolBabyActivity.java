package com.tutuya.tck.activity.baby;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.tutuya.tck.bean.network.BabyDetailBean;
import com.tutuya.tck.bean.network.BabyImageBean;
import com.tutuya.tck.bean.network.GMBean;
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

public class AddUnSchoolBabyActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.et_sex)
    TextView etSex;
    @BindView(R.id.et_city)
    TextView etCity;
    @BindView(R.id.ok)
    Button ok;
    private Uri mImageUri;
    private UriToFliePath uriToFliePath = new UriToFliePath();
    private String HEAD_ICON_NAME = "head", imageUrl = "", id="0", type;
    private int PHOTO_ALBUM = 0, REQUESTCODE_CUTTING = 1;
    private List<CityBean> provinceBean = new ArrayList<>();
    private List<ArrayList<CityBean.ChildrenBeanX>> cityBean = new ArrayList<>();
    private String cityCode, provinceCode;
    private String sexCode;
    private List<String> sexList = new ArrayList<>();
    private List<GMCheckNullBean> gmCheckNullBean = new ArrayList<>();
    @Override
    protected void initView() {
        setContentView(R.layout.activity_add_unschool_baby);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("宝宝信息");
        sexList.add("男");
        sexList.add("女");
        getCityList();
        id=getIntent().getStringExtra("id");
        if (!id.equals(0)){
            getData();
        }
    }

    @OnClick({R.id.back, R.id.image, R.id.et_sex, R.id.et_city, R.id.ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.image:
                MPermissions.requestPermissions(this, 4, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
                break;
            case R.id.et_sex:
                selectSex();
                break;
            case R.id.et_city:
                showPickerView();
                break;
            case R.id.ok:
                checkInfo();
                break;
        }
    }

    private void checkInfo() {
        gmCheckNullBean.clear();
        gmCheckNullBean.add(new GMCheckNullBean("头像", imageUrl));
        gmCheckNullBean.add(new GMCheckNullBean("姓名", etName.getText().toString()));
        gmCheckNullBean.add(new GMCheckNullBean("城市", String.valueOf(cityCode)));
        gmCheckNullBean.add(new GMCheckNullBean("性别", String.valueOf(sexCode)));
        String result = Util.checkNull(gmCheckNullBean);
        Log.e(result,result);
        if (!result.equals("ok")) {
            showToast(result);
        }else if(etId.getText().toString().equals("")){
            submit();
        }else if( Util.validateIdNumber(etId.getText().toString())){
            submit();
        }
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


    //    选择性别
    private void selectSex() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                etSex.setText(sexList.get(options1));
                sexCode =String.valueOf( options1 + 1);
            }
        }).build();
        pvOptions.setPicker(sexList);
        pvOptions.show();

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


    @PermissionGrant(4)
    public void requestContactSuccess() {
        Toast.makeText(this, "GRANT ACCESS CONTACTS!", Toast.LENGTH_SHORT).show();
        getPhoto();
    }

    @PermissionDenied(4)
    public void requestContactFailed() {
        Toast.makeText(this, "DENY ACCESS CONTACTS!", Toast.LENGTH_SHORT).show();
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
    //    提交数据(老版)
    private void submit() {
        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("api", "baby/babyae")
                .addFormDataPart("token", getMyApplication().getToken())
                .addFormDataPart("name", etName.getText().toString())
                .addFormDataPart("sex", String.valueOf(sexCode))
                .addFormDataPart("idcard", etId.getText().toString())
                .addFormDataPart("baby_id", id)
                .addFormDataPart("photo", imageUrl)
                .addFormDataPart("province_id", provinceCode)
                .addFormDataPart("city_id", cityCode)
                .build();
        Call<GMBean> call = inter.editOrAddDate(requestBody);
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    finish();
                }
                    showToast(response.body().getErrormessage());
            }
            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                Log.e("新建宝宝信息", t.getMessage());
            }
        });
    }




    //    如果是编辑信息时请求详情数据
    private void getData() {
        Call<BabyDetailBean> call = inter.getBabyDetail("baby/babyinfo", getMyApplication().getToken(), id);
        call.enqueue(new Callback<BabyDetailBean>() {
            @Override
            public void onResponse(Call<BabyDetailBean> call, Response<BabyDetailBean> response) {
                if (response.body().getErrorcode() == 200) {
                    etName.setText(response.body().getData().getName());
                    etCity.setText(response.body().getData().getCity_name());
                    cityCode = response.body().getData().getCity_id();
                    provinceCode = response.body().getData().getProvince_id();
                    etSex.setText(response.body().getData().getSex_show());
                    sexCode = response.body().getData().getSex();
                    etId.setText(response.body().getData().getIdcard());
                    imageUrl = response.body().getData().getPhoto();
                    Log.e("卧室图片的地址请求的",imageUrl);
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
}
