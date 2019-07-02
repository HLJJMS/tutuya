package com.tutuya.tck.adapter.education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;

import java.lang.ref.WeakReference;

/**
 * @version 1.0
 * @author  tyh
 * @功能：在线讲评第一个横向rec
 * @date 创建时间：2019/4/14
 */
public class ClassingProfessionAdapter extends RecyclerView.Adapter<ClassingProfessionAdapter.ViewHolder> {
    WeakReference<Context> context;
    int width;

    public ClassingProfessionAdapter(Context context, int width) {
        this.context = new WeakReference<>(context);
        this.width = width;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_profession, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams lp = viewHolder.ll.getLayoutParams();
        lp.width = width/3;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        viewHolder.ll.setLayoutParams(lp);
        Glide.with(context.get()).load(R.mipmap.linshilingxinglujin).into(viewHolder.img);
        viewHolder.txt.setText("鲁老师");
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll;
        TextView txt;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt  = itemView.findViewById(R.id.txt);
            img = itemView.findViewById(R.id.img);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
