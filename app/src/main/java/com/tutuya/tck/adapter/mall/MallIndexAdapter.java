package com.tutuya.tck.adapter.mall;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.mall.prodectdetail.ProdectDetailActivity;

/*
商城主页列表
create   田羽衡
*/
public class MallIndexAdapter extends RecyclerView.Adapter<MallIndexAdapter.ViewHolder> {
private Context context;
private int width;

    public MallIndexAdapter(Context context, int width) {
        this.context = context;
        this.width = width;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mall_index, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554111028565&di=abfe6f7e113b3e527733addada8e62d9&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20140821%2Fshoujifangbaomotaobaozhutu_2849591.jpg").into(viewHolder.img);
        viewHolder.txtDetail.setText("钢铁侠，钢铁侠，钢铁侠") ;
        viewHolder.txtPrice.setText("￥9999");
        viewHolder.txtNumber.setText("6000人购买");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProdectDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtPrice,txtNumber,txtDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtPrice = itemView.findViewById(R.id.txt_price);
            txtDetail = itemView.findViewById(R.id.txt_detail);
            txtNumber = itemView.findViewById(R.id.txt_number);
        }
    }
}
