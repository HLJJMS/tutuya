package com.tutuya.tck.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.HeadDetailBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
 * create  by  田羽衡
 * //闹测评详情列表
 * */
public class HeadDetailAdapter extends RecyclerView.Adapter<HeadDetailAdapter.ViewHolder> {
    private String[] name = {"预约单号", "宝宝姓名", "宝宝性别", "出生日期", "联系电话", "宝宝利手", "报告类型", "学校名称",
            "班级名称", "家庭住址", "预约人", "预约时间", "创建时间"};
    private String[] handArry = {"","左手","右手"};
    private String[] evaluationArry = {"","普测版-成人","普测版-儿童","特长版-学生","兴趣版-幼儿","能力发展版-学生","能力发展版-幼小衔接","综合版-成人","综合版-学生","综合版-幼儿"};
    private WeakReference<Context> context;
    private HeadDetailBean.DataBeanX.DataBean bean;
    private int sum=0;
    public HeadDetailAdapter(Context context) {
        this.context = new WeakReference<Context>(context);
    }

    public void setData(HeadDetailBean.DataBeanX.DataBean bean) {
        sum=13;
        this.bean = bean;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HeadDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_head_detail, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HeadDetailAdapter.ViewHolder viewHolder, int i) {

        viewHolder.key.setText(name[i]);
        switch (i) {
            case 0:
                viewHolder.value.setText(bean.getCode());
                break;
            case 1:
                viewHolder.value.setText(bean.getName());
                break;
            case 2:
                viewHolder.value.setText(bean.getSex_show());
                break;
            case 3:
                viewHolder.value.setText(bean.getBirth());
                break;
            case 4:
                viewHolder.value.setText(bean.getPhone());
                break;
            case 5:
                viewHolder.value.setText(bean.getHandednes());
                break;
            case 6:
                viewHolder.value.setText(evaluationArry[Integer.valueOf(bean.getEvaluation_type())]);
                break;
            case 7:
                viewHolder.value.setText(bean.getSchool_name());
                break;
            case 8:
                viewHolder.value.setText(bean.getClass_name());
                break;
            case 9:
                viewHolder.value.setText(bean.getAddress());
                break;
            case 10:
                viewHolder.value.setText(bean.getPro_name());
                break;
            case 11:
                viewHolder.value.setText(bean.getAppo_date());
                break;
            case 12:
                viewHolder.value.setText(bean.getCreate_tm());
                break;


        }

    }

    @Override
    public int getItemCount() {
        return sum;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView key, value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            key = itemView.findViewById(R.id.key);
            value = itemView.findViewById(R.id.value);
        }
    }
}
