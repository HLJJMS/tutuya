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
import com.tutuya.tck.bean.network.classing.ClassHomeBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/14
 */
public class ClassingThreeAdapter extends RecyclerView.Adapter<ClassingThreeAdapter.ViewHolder> {
    WeakReference<Context> context;
    int width;
    List<ClassHomeBean.DataBean.List3Bean> list = new ArrayList<>();

    public ClassingThreeAdapter(Context context, int width) {
        this.context = new WeakReference<>(context);
        this.width = new Double(width * 0.92).intValue();
    }

    @NonNull
    @Override
    public ClassingThreeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_teach_class, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassingThreeAdapter.ViewHolder viewHolder, int i) {
        ViewGroup.LayoutParams lp = viewHolder.ll.getLayoutParams();
        lp.width = width / 4;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        viewHolder.ll.setLayoutParams(lp);
        Glide.with(context.get()).load(list.get(i).getCover_img()+list.get(i).getCover_img()).into(viewHolder.img);
        viewHolder.txt.setText("李老师");
        viewHolder.txt2.setText("童创客教师");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<ClassHomeBean.DataBean.List3Bean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll;
        TextView txt, txt2;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
            img = itemView.findViewById(R.id.img);
            ll = itemView.findViewById(R.id.ll);
            txt2 = itemView.findViewById(R.id.txt2);
        }
    }
}
