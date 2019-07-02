package com.tutuya.tck.adapter.education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;

import java.lang.ref.WeakReference;
/*
* 课程推荐部分
* create 田羽衡
* */
public class HotClassAdapter extends RecyclerView.Adapter<HotClassAdapter.ViewHolder> {
    WeakReference<Context> weakReference ;
    int width;

    public HotClassAdapter(Context weakReference, int width) {
        this.weakReference = new WeakReference<>(weakReference);
        this.width =  new Double(width*0.92).intValue();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_education_hot,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams lp = viewHolder.cl.getLayoutParams();
        lp.width = width/3;
        viewHolder.cl.setLayoutParams(lp);
        Glide.with(weakReference.get()).load(R.mipmap.linshishufa).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout cl;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cl = itemView.findViewById(R.id.cl);
            img = itemView.findViewById(R.id.img);
        }
    }
}
