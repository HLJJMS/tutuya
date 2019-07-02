package com.tutuya.tck.adapter.education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutuya.tck.R;

import java.lang.ref.WeakReference;
/*
* 视频课程部分
* create by 田羽衡
* */
public class RmvbAdapter extends RecyclerView.Adapter<RmvbAdapter.ViewHolder> {
    private WeakReference<Context> context;
    int width;

    public RmvbAdapter(Context context, int width) {
        this.context = new WeakReference<>(context);
        this.width =  new Double(width*0.92).intValue();;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_education_rmvb,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams clt = viewHolder.cl.getLayoutParams();
        clt.width = width/2;
        viewHolder.cl.setLayoutParams(clt);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout cl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cl = itemView.findViewById(R.id.cl);
        }
    }
}
