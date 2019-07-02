package com.tutuya.tck.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.Education.EducationListActivity;
import com.tutuya.tck.bean.network.HomeClassingNewBean;
import com.tutuya.tck.bean.network.home.CouresRecommendBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * 课程推荐
 * create by
 *田羽衡
 * */
public class HomeClassingAdapter extends RecyclerView.Adapter<HomeClassingAdapter.ViewHolder> {

    private List<HomeClassingNewBean.DataBeanX.DataBean> couresRecommend = new ArrayList<>();
    WeakReference<Context> contextWeakReference;


    public HomeClassingAdapter(Context contextWeakReference) {
        this.contextWeakReference = new WeakReference<>(contextWeakReference);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_select, viewGroup, false));
    }




    public void setData( List<HomeClassingNewBean.DataBeanX.DataBean> couresRecommend ) {
        this.couresRecommend.clear();
        this.couresRecommend.addAll(couresRecommend);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.title.setText(couresRecommend.get(i).getCategory_name());
        viewHolder.type.setText("分类 ： " + couresRecommend.get(i).getLecturer());
        viewHolder.teacher.setText("讲师 ： " + couresRecommend.get(i).getLecturer());
        viewHolder.all.setText("共" + couresRecommend.get(i).getVideo_num() + "集");
        viewHolder.etEye.setText(couresRecommend.get(i).getPlay_num());
        viewHolder.etLike.setText(couresRecommend.get(i).getPraise_num());
        Glide.with(contextWeakReference.get()).load(couresRecommend.get(i).getCover_img());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextWeakReference.get(), EducationListActivity.class);
                intent.putExtra("id",couresRecommend.get(i).getId());
                contextWeakReference.get().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return couresRecommend.size();
    }

    static

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
