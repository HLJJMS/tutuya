package com.tutuya.tck.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutuya.tck.R;

/*
* 四大教育部分
* create by
*田羽衡
* */
public class CourseRecommendationAdapter extends RecyclerView.Adapter<CourseRecommendationAdapter.ViewHolder> {
    @NonNull
    @Override
    public CourseRecommendationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_select_white, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRecommendationAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
