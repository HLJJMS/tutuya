package com.tutuya.tck.adapter.home;

import android.animation.ValueAnimator;
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
import com.bumptech.glide.request.RequestOptions;
import com.tutuya.tck.R;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/*
* 主页的商城 部分
* create by
* 田羽衡
* */


public class HomeMallAdapter extends RecyclerView.Adapter<HomeMallAdapter.ViewHolder> {
    private Reference<Context>  context;
    private int width;
    public HomeMallAdapter(Context context, int width) {
        this.context = new WeakReference<Context>(context) ;
        this.width = new Double(width*0.88/2).intValue() ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_mall, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams clp=viewHolder.cl.getLayoutParams();
        clp.width =width;
        clp.height = width*10/7;
        viewHolder.cl.setLayoutParams(clp);
        RequestOptions requestOptions = new RequestOptions().fitCenter();
        Glide.with(context.get()).load(R.mipmap.linshitutu).apply(requestOptions).into(viewHolder.img);
        viewHolder.car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator anim = ValueAnimator.ofFloat(0.3f,0.9f,0.6f);
                anim.setDuration(500);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float currentValue =(float)  animation.getAnimatedValue();
                        viewHolder.car.setScaleX(currentValue);
                        viewHolder.car.setScaleY(currentValue);
                        viewHolder.car.requestLayout();
                    }
                });
                anim.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt ,rmb,sum;
        private ConstraintLayout cl;
        private CheckBox car;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
            rmb = itemView.findViewById(R.id.rmb);
            sum = itemView.findViewById(R.id.sum);
            cl = itemView.findViewById(R.id.cl);
            car = itemView.findViewById(R.id.car);
        }
    }
}
