package com.tutuya.tck.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.headtest.HeadDetailActivity;
import com.tutuya.tck.bean.network.HeadTestListBean;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * 闹测评列表
 *
 * create  by 田羽衡
 * */
public class HeadTestAdapter extends RecyclerView.Adapter<HeadTestAdapter.ViewHolder> {
    private Reference<Context> context;
    private List<HeadTestListBean.DataBeanX.DataBean> list = new ArrayList<>();
    private String[] status={"未支付","预约成功","预约失败","已检测","正在出结果","检测完成","检测失败","无法获取结果"};
    public HeadTestAdapter(Context context) {
        this.context = new WeakReference<Context>(context);
    }
    public void setData( List<HeadTestListBean.DataBeanX.DataBean> list){
        this.list.clear();
       this. list.addAll(list);
       notifyDataSetChanged();
    }
    public void setDataAll(List<HeadTestListBean.DataBeanX.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_head_test, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.etId.setText(list.get(i).getId());
        viewHolder.etName.setText(list.get(i).getName());
        viewHolder.etDate.setText(list.get(i).getAppo_date());
        viewHolder.etSchool.setText(list.get(i).getSchool_name());
        viewHolder.type.setText(status[Integer.valueOf(list.get(i).getStatus())]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.get(), HeadDetailActivity.class);
                intent.putExtra("id",list.get(i).getId());
                context.get().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.et_id)
        TextView etId;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.et_name)
        TextView etName;
        @BindView(R.id.tv_school)
        TextView tvSchool;
        @BindView(R.id.et_school)
        TextView etSchool;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.et_date)
        TextView etDate;
        @BindView(R.id.read)
        TextView read;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
