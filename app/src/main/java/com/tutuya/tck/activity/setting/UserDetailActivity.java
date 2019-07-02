package com.tutuya.tck.activity.setting;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.base.UriToFliePath;
import com.tutuya.tck.bean.network.GMBean;
import com.tutuya.tck.bean.network.GMStringBean;
import com.tutuya.tck.bean.network.PhotoBean;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//用户信息详情
public class UserDetailActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.head_back)
    TextView headBack;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.et_name)
    TextView etName;
    @BindView(R.id.headimg)
    ImageView headimg;
    private Uri mImageUri;
    private UriToFliePath uriToFliePath = new UriToFliePath();
    private String HEAD_ICON_NAME = "head",headPhotoUrl="";
    private int PHOTO_ALBUM = 0, REQUESTCODE_CUTTING = 1;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        headTitle.setText("个人信息");
        etName.setText(getIntent().getStringExtra("name"));
        setPhoto(getIntent().getStringExtra("img"));
    }

    private void setPhoto(String url) {
        Glide.with(this).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop()).signature(new ObjectKey(System.currentTimeMillis()))).into(headimg);
    }

    @OnClick({R.id.back, R.id.head_back, R.id.name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                if(headPhotoUrl.equals("")){
                    finish();
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("image", headPhotoUrl);
                    setResult(200, intent);
                    finish();
                }

                break;
            case R.id.head_back:
                MPermissions.requestPermissions(this, 4, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
                break;
            case R.id.name:
                showEditName();
                break;
        }
    }

    private void showEditName() {
        final EditText et = new EditText(this);
        AlertDialog.Builder etName = new AlertDialog.Builder(this);
        etName.setTitle("请输入新名字");
        etName.setView(et);
        etName.setPositiveButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                postName(et.getText().toString());
            }
        }).setNegativeButton("取消", null).show();
    }


    private void postName(final String name) {
        showLoading();
        Call<GMBean> call = inter.postName("user/editinfo", getMyApplication().getToken(), name);
        call.enqueue(new Callback<GMBean>() {
            @Override
            public void onResponse(Call<GMBean> call, Response<GMBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    showToast(response.body().getErrormessage());
                    etName.setText(name);
                    closeLoading();
                } else {
                    showToast(response.body().getErrormessage());
                    closeLoading();
                }
            }

            @Override
            public void onFailure(Call<GMBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                closeLoading();
            }
        });

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
                postPhoto();
            }
        }
    }

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

    private void postPhoto() {
        String url = uriToFliePath.getPhotoPathFromContentUri(this, mImageUri);
        Log.e("我是图片地址", url);
        File file = new File(url);
        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("api", "common/upload")
                .addFormDataPart("token", getMyApplication().getToken())
                .addFormDataPart("f_type","1")
                .addFormDataPart("file",file.getName(),RequestBody.create(MediaType.parse("image/*"),file)).build();
        Call<GMStringBean> call = inter.postPhoto(requestBody);
        call.enqueue(new Callback<GMStringBean>() {
            @Override
            public void onResponse(Call<GMStringBean> call, Response<GMStringBean> response) {
                if (response.body().getErrorcode().equals("200")) {
                    showToast(response.body().getErrormessage());
                    headPhotoUrl = response.body().getData();
                    setPhoto(response.body().getData());
                } else {
                    showToast(response.body().getErrormessage());
                }
            }

            @Override
            public void onFailure(Call<GMStringBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
                Log.e("戳无信息", t.toString());
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if(headPhotoUrl.equals("")){
                finish();
            }else{
                Intent intent = new Intent();
                intent.putExtra("image", headPhotoUrl);
                setResult(200, intent);
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
