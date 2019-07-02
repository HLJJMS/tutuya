package com.tutuya.tck.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.home.CommentingBean;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
* 主页专家名师横向的rec
* create by田羽衡
*
* */
public class HomeProfessionalAdapter extends RecyclerView.Adapter<HomeProfessionalAdapter.ViewHolder> {
    private Reference<Context> context;
    private List<CommentingBean.DataBean.CommentHighBean> list = new ArrayList<>();
    private int width;
    private IOnClick iOnClick;
    public HomeProfessionalAdapter(Context context, int width) {
        this.context =new WeakReference<Context>(context) ;
        this.width = new Double(width * 0.88 / 3).intValue();
    }
    public void setiOnClick( IOnClick iOnClick){
        this.iOnClick = iOnClick;
    }
    @NonNull
    @Override
    public HomeProfessionalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_profession, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfessionalAdapter.ViewHolder viewHolder, final int i) {
        ViewGroup.LayoutParams llLayoutParams = viewHolder.ll.getLayoutParams();
        llLayoutParams.width = width;
        llLayoutParams.height = width / 3 * 4;
        viewHolder.ll.setLayoutParams(llLayoutParams);
        RequestOptions requestOptions = new RequestOptions().fitCenter();
        Glide.with(context.get()).load(list.get(i).getCover_img()).apply(requestOptions).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClick.onClick(i);
            }
        });
    }

    public void setData( List<CommentingBean.DataBean.CommentHighBean> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            ll = itemView.findViewById(R.id.ll);
        }
    }

    public interface IOnClick{
        void onClick(int i);
    }
}
