package com.tutuya.tck.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.SchoolBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：宝宝是否在学校列表
 * @date 创建时间：2019/4/23
 */
public class BabyWetherSchoolBean extends RecyclerView.Adapter<BabyWetherSchoolBean.ViewHolder> {
    List<SchoolBean.DataBean> bean = new ArrayList<>();

    public void setBean( List<SchoolBean.DataBean> bean ){
        this.bean.clear();
        this.bean.addAll(bean);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_whether_school, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtName.setText(bean.get(i).getName());
        viewHolder.txtCeoName.setText(bean.get(i).getDirector());
        viewHolder.txtAddress.setText(bean.get(i).getAddress());
        viewHolder.txtTel.setText(bean.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_ceo_name)
        TextView txtCeoName;
        @BindView(R.id.txt_tel)
        TextView txtTel;
        @BindView(R.id.txt_address)
        TextView txtAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
