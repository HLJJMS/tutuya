package com.tutuya.tck.adapter.education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutuya.tck.R;

import java.lang.ref.WeakReference;
/*
* 评论的adapter
* create by 田羽衡
* */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    WeakReference<Context> context;

    public CommentAdapter(Context context) {
        this.context = new WeakReference<Context>(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_education_comment,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
