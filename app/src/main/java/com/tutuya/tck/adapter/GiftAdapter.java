package com.tutuya.tck.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.GiftBean;

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
public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.ViewHolder> {

    private List<GiftBean.DataBean.GiftListBean> list = new ArrayList<>();
    private String photoUp;
    private int position = 0;
    private View view;
    private WeakReference<Context> contextWeakReference;
    private int width;
    private CallBackGetData callBackGetData;

    public GiftAdapter(Context contextWeakReference, int width) {

        this.contextWeakReference = new WeakReference<>(contextWeakReference);
        this.width = width;
    }

    public void GetCallBackGetData(CallBackGetData callBackGetData) {
        this.callBackGetData = callBackGetData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gift, viewGroup, false);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = width / 4;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (position==i){
            viewHolder.txt.setTextColor(Color.WHITE);
            viewHolder.txt.setBackground(contextWeakReference.get().getDrawable(R.drawable.corner_rmbcolor_solid_bottom));
            viewHolder.img.setBackground(contextWeakReference.get().getDrawable(R.drawable.corner_rmbcolor_stroke_top));
        }else{
            viewHolder.txt.setTextColor(Color.BLACK);
            viewHolder.txt.setBackground(contextWeakReference.get().getDrawable(R.color.colorWhite));
            viewHolder.img.setBackground(contextWeakReference.get().getDrawable(R.color.colorWhite));
        }
        viewHolder.txt.setText(list.get(i).getVc_price()+"豆");
        Glide.with(contextWeakReference.get()).load(photoUp + list.get(i).getGift_photo()).into(viewHolder.img);
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = i;
                notifyDataSetChanged();
            }
        });
    }

    public void setData(List<GiftBean.DataBean.GiftListBean> list, String photoUp) {
        this.list.clear();
        this.list.addAll(list);
        this.photoUp = photoUp;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.txt)
        TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public String getGiftId(){
        return String.valueOf(position);
    }



    public interface CallBackGetData {
        void getData(String id);
    }
}
