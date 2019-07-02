package com.tutuya.tck.adapter;

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
import com.tutuya.tck.activity.ProfessionalFamousTeacherActivity;
import com.tutuya.tck.bean.network.TeacherListBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/14
 */
public class ProfessionalTeacherAdapter extends RecyclerView.Adapter<ProfessionalTeacherAdapter.ViewHolder> {
    View view;
    WeakReference<Context> context;
    List<TeacherListBean.DataBeanX.DataBean> list = new ArrayList<>();
    int width;

    public ProfessionalTeacherAdapter(Context context, int width) {
        this.context = new WeakReference<>(context);
        this.width = width;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_professional_teacher, viewGroup, false);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = width / 2;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.detail.setText(list.get(i).getTags().toString());
        Glide.with(context.get()).load(list.get(i).getCover_img()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.get(), ProfessionalFamousTeacherActivity.class);
                intent.putExtra("code",list.get(i).getId());
                context.get().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(  List<TeacherListBean.DataBeanX.DataBean> list ){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bg)
        TextView bg;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.detail)
        TextView detail;
        @BindView(R.id.honor)
        ImageView honor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, view);
        }
    }
}
