package com.tutuya.tck.activity.Education;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.adapter.VideoClassingAdapter;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListPlayBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @version 1.0
 * @author  tyh
 * @功能：视频列表界面播放
 * @date 创建时间：2019/4/15
 */
public class EducationListActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.rec)
    RecyclerView rec;
    VideoClassingAdapter adapter;
    String id;
    @BindView(R.id.video)
    JzvdStd video;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_education_list);
        ButterKnife.bind(this);

    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
        adapter = new VideoClassingAdapter(this);
        rec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rec.setAdapter(adapter);
        getData();
      adapter.sentCallBackVideo(new VideoClassingAdapter.CallBackSendVideoData() {
          @Override
          public void sendVideoData(String title, String video, String img) {
              videoPlay(video,title,img);
          }
      });
    }


    private void getData() {
        Call<FamousTeacherVideoListPlayBean> call = inter.getFamousTeacherVideoPlay("course/get_course_list", getMyApplication().getToken(), id);

        call.enqueue(new Callback<FamousTeacherVideoListPlayBean>() {
            @Override
            public void onResponse(Call<FamousTeacherVideoListPlayBean> call, Response<FamousTeacherVideoListPlayBean> response) {
                if (response.body().getErrorcode() == 200) {
                    adapter.setData(response.body().getData().getVideo_list());
                    videoPlay(response.body().getData().getVideo_list().get(0).getVideo_url(), response.body().getData().getVideo_list().get(0).getName(), response.body().getData().getVideo_list().get(0).getCover_img());

                }
            }

            @Override
            public void onFailure(Call<FamousTeacherVideoListPlayBean> call, Throwable t) {

            }
        });

    }


    private void videoPlay(String url, String tlitle, String img) {
        video.setUp(url, "", Jzvd.SCREEN_NORMAL);
        Glide.with(this).load(img).into(video.thumbImageView);
        headTitle.setText(tlitle);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }




    @OnClick({R.id.back, R.id.head_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.head_title:
                finish();
                break;
        }
    }
}
