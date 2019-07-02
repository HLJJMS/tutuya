package com.tutuya.tck.frament.my;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.BuyBeanActivity;
import com.tutuya.tck.activity.FamilyConnectActivity;
import com.tutuya.tck.activity.setting.SettingActivity;
import com.tutuya.tck.adapter.my.MyAdapter;
import com.tutuya.tck.base.BaseMvpFragment;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.base.UriToFliePath;
import com.tutuya.tck.frament.IHomeActivityToFramgent;

import butterknife.BindView;
import butterknife.OnClick;

public class MyMvpFragment extends BaseMvpFragment implements IMyView, IHomeActivityToFramgent {


    @BindView(R.id.bt_addbean)
    TextView btAddBean;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.dousum)
    TextView dousum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.setting)
    ImageView setting;
    @BindView(R.id.detail)
    TextView detail;
    private MyPresenter presenter;
    private Context context;
    MyAdapter adapter;
    private boolean vip;
    private String token = "";
    private Uri mImageUri;
    private UriToFliePath uriToFliePath = new UriToFliePath();
    private Bundle bundle;
    private String txtName, txtSchool, txtImage, txtRmb, phone, myBean;

    @Override
    protected BasePresenter createPresenter() {
        presenter = new MyPresenter();
        return presenter;
    }

    @Override
    protected void initPresenter() {
        presenter.getActivity();
    }

    @Override
    protected void initData() {
        bundle = getArguments();
        if (null != bundle) {
            token = bundle.getString("token");
        }
        context = getActivity();
        aboutRecycler();

    }


    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_my;
    }


    private void aboutRecycler() {
        recycler.setHasFixedSize(true);
        StaggeredGridLayoutManager recyclerViewLayoutManager =
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(recyclerViewLayoutManager);
        adapter = new MyAdapter(getActivity(), getWidth());
        recycler.setAdapter(adapter);

        adapter.CallBackData(new MyAdapter.PostData() {
            @Override
            public void setFamilyData() {
                presenter.getTeacherInfo(token);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @OnClick({R.id.head_img, R.id.message, R.id.setting, R.id.bt_addbean})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img:
//                MPermissions.requestPermissions(this, 4, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});
                break;
            case R.id.message:
                break;
            case R.id.setting:
                Intent setting = new Intent(getActivity(), SettingActivity.class);
                setting.putExtra("img", txtImage);
                setting.putExtra("school", txtSchool);
                setting.putExtra("rmb", txtRmb);
                setting.putExtra("name", txtName);
                setting.putExtra("phone", phone);
                startActivityForResult(setting, 100);
                break;
            case R.id.bt_addbean:
                Intent buyBeanIntent = new Intent(getActivity(), BuyBeanActivity.class);
                buyBeanIntent.putExtra("img", txtImage);
                buyBeanIntent.putExtra("rmb", txtRmb);
                buyBeanIntent.putExtra("name", txtName);
                startActivity(buyBeanIntent);
                break;
        }
    }


    private void postPhoto() {
        presenter.upLoadImg(uriToFliePath.getPhotoPathFromContentUri(getActivity(), mImageUri));

    }


    @Override
    public void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("版本检测").setMessage("发现新版本！点击确定更新").setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("暂不更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();

    }


    @Override
    public void photoOk(String url) {
        Glide.with(this).load(url).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(headImg);
    }

    //    获取头像等数据返回
    @Override
    public void setDataUser(String name, String school, String img, String rmb, String phone) {
        txtImage = img;
        txtName = name;
        txtRmb = rmb;
        txtSchool = school;
        photoOk(img);
        this.name.setText(name);
        dousum.setText(rmb);
        detail.setText(school);
        this.phone = phone;
    }

    @Override
    public void setTeacherInfo(String id,String name, String className, String photoUrl) {
        Intent intent = new Intent(getContext(), FamilyConnectActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("name",name);
        intent.putExtra("className",className);
        intent.putExtra("photoUrl",photoUrl);
        intent.putExtra("rmb", txtRmb);
        startActivity(intent);
    }


    @Override
    public void loadData() {
//            首次加载
        presenter.getUserInfo(token);
        Log.e("第一次加载", token);

    }

    @Override
    public void getToken(String token, boolean vip) {
        this.token = token;
        this.vip = vip;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            txtImage = data.getStringExtra("image");
            photoOk(txtImage);
        }
    }
}
