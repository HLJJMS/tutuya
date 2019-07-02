package com.tutuya.tck.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextLinks;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.ProfessionalTeacherDetailActivity;
import com.tutuya.tck.bean.network.classing.ClassHomeBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：在线讲评第一个横向rec
 * @date 创建时间：2019/4/14
 */
public class ClassingProfessionAdapter extends RecyclerView.Adapter<ClassingProfessionAdapter.ViewHolder> {
    WeakReference<Context> context;
    List<ClassHomeBean.DataBean.List1Bean> list = new ArrayList<>();
    int width;

    public ClassingProfessionAdapter(Context context, int width) {
        this.context = new WeakReference<>(context);
        this.width = new Double(width * 0.92).intValue();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_profession, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams lp = viewHolder.ll.getLayoutParams();
        lp.width = width / 3;
        lp.height = new Double(width / 2.5).intValue();
//        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        viewHolder.ll.setLayoutParams(lp);

        Glide.with(context.get()).load(list.get(i).getCover_img()+list.get(i).getCover_img()).into(viewHolder.img);
        viewHolder.txt.setText("鲁老师");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.get().startActivity(new Intent(context.get(), ProfessionalTeacherDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setData(List<ClassHomeBean.DataBean.List1Bean> list){
        this.list.size();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll;
        TextView txt;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
            img = itemView.findViewById(R.id.img);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
