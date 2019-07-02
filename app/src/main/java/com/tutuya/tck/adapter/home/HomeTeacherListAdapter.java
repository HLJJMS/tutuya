package com.tutuya.tck.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tutuya.tck.R;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/*
* 推荐讲评部分  横向的rec\
* create by 田羽衡
* */


public class HomeTeacherListAdapter extends RecyclerView.Adapter<HomeTeacherListAdapter.ViewHolder> {
        private View view;
        private int width;
        private Reference<Context>  context;

    public HomeTeacherListAdapter(int width, Context context) {
        this.context =new WeakReference<Context>(context) ;
        this.width = new Double(width*0.88/3).intValue() ;
    }

    @NonNull
    @Override
    public HomeTeacherListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teacher, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeTeacherListAdapter.ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams llLayoutParams = viewHolder.ll.getLayoutParams();
        llLayoutParams.width = width;
        llLayoutParams.height = new Double( width/0.62).intValue();
        viewHolder.ll.setLayoutParams(llLayoutParams);
        RequestOptions requestOptions = new RequestOptions().fitCenter();
        Glide.with(context.get()).load(R.mipmap.linshizhuanjia).apply(requestOptions).into(viewHolder.img);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        LinearLayout ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            ll = itemView.findViewById(R.id.ll);

        }
    }
}
