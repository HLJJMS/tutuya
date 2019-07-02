package com.tutuya.tck.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListPlayBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/26
 */
public class VideoClassingAdapter extends RecyclerView.Adapter<VideoClassingAdapter.ViewHolder> {
    List<FamousTeacherVideoListPlayBean.DataBean.VideoListBean> list = new ArrayList<>();
    private WeakReference<Context> contextWeakReference;
    private CallBackSendVideoData mCallBackSendVideoData;
    public VideoClassingAdapter(Context contextWeakReference) {
        this.contextWeakReference = new WeakReference<>(contextWeakReference);
    }

    public void sentCallBackVideo(CallBackSendVideoData mCallBackSendVideoData){
        this.mCallBackSendVideoData = mCallBackSendVideoData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_select, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.title.setText(list.get(i).getName());
        viewHolder.teacher.setText("讲师 ： " + list.get(i).getLecturer());
        viewHolder.all.setText("共" + list.get(i).getPraise_num() + "集");
        Glide.with(contextWeakReference.get()).load(list.get(i).getCover_img()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBackSendVideoData.sendVideoData(list.get(i).getName(),list.get(i).getVideo_url(),list.get(i).getCover_img());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<FamousTeacherVideoListPlayBean.DataBean.VideoListBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.teacher)
        TextView teacher;
        @BindView(R.id.all)
        TextView all;
        @BindView(R.id.eye)
        ImageView eye;
        @BindView(R.id.et_eye)
        TextView etEye;
        @BindView(R.id.like_img)
        CheckBox likeImg;
        @BindView(R.id.et_like)
        TextView etLike;
        @BindView(R.id.ll)
        ConstraintLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }

    public interface CallBackSendVideoData{
        void sendVideoData(String title,String video,String img);
    }

}