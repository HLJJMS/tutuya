package com.tutuya.tck.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.Education.EducationListActivity;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/15
 */
public class ProfessionalFamousTeacherClassListAdapter extends RecyclerView.Adapter<ProfessionalFamousTeacherClassListAdapter.ViewHolder> {
    View view;
    WeakReference<Context> context;
    int width;
    List<FamousTeacherVideoListBean.DataBeanX.DataBean> list = new ArrayList<>();

    public ProfessionalFamousTeacherClassListAdapter(Context context, int width) {
        this.context = new WeakReference<>(context);
        this.width = width;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_professional_famous_teacher_class, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context.get()).load(list.get(i).getCover_img()).into(viewHolder.img);
        viewHolder.title.setText(list.get(i).getCategory_name());
        viewHolder.txtName.setText("主讲教师 : "+list.get(i).getLecturer());
        viewHolder.txtTime.setText("播放量"+list.get(i).getPlay_num());
        viewHolder.txtHeart.setText(list.get(i).getPraise_num());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.get(), EducationListActivity.class);
                intent.putExtra("id",list.get(i).getId());
                context.get().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setData(List<FamousTeacherVideoListBean.DataBeanX.DataBean> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.free)
        TextView free;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.txt_heart)
        TextView txtHeart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
