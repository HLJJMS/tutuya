package com.tutuya.tck.adapter.mall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;

import java.lang.ref.WeakReference;

/*
商城部分购物车列表
create by
田羽衡

*/

public class MallCarAdapter extends RecyclerView.Adapter<MallCarAdapter.ViewHolder> {
  private WeakReference<Context>  context ;
    private int index;
    public MallCarAdapter(Context context) {
        this.context = new WeakReference<>(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shop_car,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context.get()).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554111028565&di=abfe6f7e113b3e527733addada8e62d9&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20140821%2Fshoujifangbaomotaobaozhutu_2849591.jpg").into(viewHolder.img);
        viewHolder.radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = i;
                notifyDataSetChanged();
            }
        });
        if (index==i){
            viewHolder.radio.setChecked(true);
        }else{
            viewHolder.radio.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name ,detail , pay;
        RadioButton radio;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            pay = itemView.findViewById(R.id.txt_pay);
            detail = itemView.findViewById(R.id.txt_detail);
            radio = itemView.findViewById(R.id.bt_radio);
            img = itemView.findViewById(R.id.image);
        }
    }
}
