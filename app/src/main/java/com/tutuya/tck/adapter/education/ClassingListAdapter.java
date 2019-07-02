package com.tutuya.tck.adapter.education;

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
import com.tutuya.tck.activity.Education.EducationOneListActivity;
import com.tutuya.tck.bean.network.FiveEducationOneListBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：课程；列表
 * @date 创建时间：2019/4/28
 */
public class ClassingListAdapter extends RecyclerView.Adapter<ClassingListAdapter.ViewHolder> {
    List<FiveEducationOneListBean.DataBeanX.DataBean> list = new ArrayList<>();
    WeakReference<Context> contextWeakReference;

    public ClassingListAdapter(Context contextWeakReference) {
        this.contextWeakReference = new WeakReference<>(contextWeakReference);
    }

    @NonNull
    @Override
    public ClassingListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_select, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassingListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(list.get(i).getCategory_name());
        viewHolder.type.setText("分类 ： " + list.get(i).getLecturer());
        viewHolder.teacher.setText("讲师 ： " + list.get(i).getLecturer());
        viewHolder.all.setText("共" + list.get(i).getVideo_num() + "集");
        viewHolder.etEye.setText(list.get(i).getPlay_num());
        viewHolder.etLike.setText(list.get(i).getPraise_num());
        Glide.with(contextWeakReference.get()).load(list.get(i).getCover_img());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextWeakReference.get(), EducationListActivity.class);
                intent.putExtra("id",list.get(i).getCategory_id());
                contextWeakReference.get().startActivity(intent);
            }
        });
    }

    public void setData(List<FiveEducationOneListBean.DataBeanX.DataBean> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return list.size();
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
