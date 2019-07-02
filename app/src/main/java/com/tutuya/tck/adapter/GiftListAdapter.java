package com.tutuya.tck.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.GiftListForTeacherBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/24
 */
public class GiftListAdapter extends RecyclerView.Adapter<GiftListAdapter.ViewHolder> {
    List<GiftListForTeacherBean.DataBean.GiftListBean> listBeans = new ArrayList<>();
    private WeakReference<Context> contextWeakReference;
    String photoUp;
    public GiftListAdapter(Context contextWeakReference) {
        this.contextWeakReference = new WeakReference<>(contextWeakReference);
    }


    public void setData( List<GiftListForTeacherBean.DataBean.GiftListBean> listBeans, String photoUp){
        this.listBeans.clear();
        this.listBeans.addAll(listBeans);
        this.photoUp = photoUp;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gift_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.rmb.setText(listBeans.get(i).getVc_per_amount());
        viewHolder.time.setText(listBeans.get(i).getUpdate_tm());
        viewHolder.number.setText("X"+listBeans.get(i).getVc_gift_count());
        viewHolder.txtName.setText(listBeans.get(i).getGift_name());
        viewHolder.sumRmb.setText(listBeans.get(i).getAnonymous());
        Glide.with(contextWeakReference.get()).load(photoUp+ listBeans.get(i).getGift_photo()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.rmb)
        TextView rmb;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.sum_rmb)
        TextView sumRmb;
        @BindView(R.id.number)
        TextView number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
