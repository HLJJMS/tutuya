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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.tutuya.tck.R;
import com.tutuya.tck.bean.base.TalkBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/25
 */
public class TalkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TalkBean.DataBean.MsgListBean> list = new ArrayList<>();
    String url;
    WeakReference<Context> contextWeakReference;
    View view;
    String myImg,teacherImg;
    public TalkAdapter(Context contextWeakReference) {
        this.contextWeakReference = new WeakReference<>(contextWeakReference);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (list.get(i).getType().equals("3")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teacher_talk_my, viewGroup, false);
            return new Teacher(view);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_talk_teacher, viewGroup, false);

            return new My(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (list.get(i).getType()) {
            case "1":
                ((My) viewHolder).gift.setVisibility(View.GONE);
                ((My) viewHolder).txt.setVisibility(View.VISIBLE);
                ((My) viewHolder).txt.setText(list.get(i).getContent());
                Glide.with(contextWeakReference.get()).load(myImg).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(((My) viewHolder).img);
                break;
            case "2":
                ((My) viewHolder).gift.setVisibility(View.VISIBLE);
                ((My) viewHolder).txt.setVisibility(View.GONE);
                Glide.with(contextWeakReference.get()).load(myImg).into(((My) viewHolder).img);
                Glide.with(contextWeakReference.get()).load(url+list.get(i).getContent()).into(((My) viewHolder).gift);
                break;
            case "3":
                ((My) viewHolder).gift.setVisibility(View.GONE);
                ((My) viewHolder).txt.setVisibility(View.VISIBLE);
                ((Teacher) viewHolder).txt.setText(list.get(i).getContent());
                Glide.with(contextWeakReference.get()).load(teacherImg).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(((Teacher) viewHolder).img);
                break;
        }
    }


    public void setData(String url, List<TalkBean.DataBean.MsgListBean> list) {
        this.url = url;
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void addData(String url, List<TalkBean.DataBean.MsgListBean> list) {
        if (list.size()>0){
            myImg = list.get(0).getUser_photo();
            teacherImg= list.get(0).getTeacher_photo();
            this.url = url;
            this.list.addAll(0,list);
            notifyDataSetChanged();
        }


    }
    public void addData(TalkBean.DataBean.MsgListBean bean) {
        this.list.add(bean);
        notifyDataSetChanged();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class My extends RecyclerView.ViewHolder {
        @BindView(R.id.gift)
        ImageView gift;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.txt)
        TextView txt;

        public My(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, view);
        }
    }

    class Teacher extends RecyclerView.ViewHolder {
        @BindView(R.id.txt)
        TextView txt;
        @BindView(R.id.img)
        ImageView img;

        public Teacher(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, view);
        }
    }
}
