package com.tutuya.tck.adapter.zaixianketang;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.bean.network.classing.FamousTeacherVideoListPlayBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//四大教育 的 adapter
public class ClassingAdapter extends RecyclerView.Adapter<ClassingAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_classing_select, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.ll.getBackground().setAlpha(0);

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.teacher)
        TextView teacher;
        @BindView(R.id.all)
        TextView all;
        @BindView(R.id.eye)
        ImageView eye;
        @BindView(R.id.et_eye)
        TextView etEye;
        @BindView(R.id.like_img)
        CheckBox likeImg;
        @BindView(R.id.et_like)
        TextView etLike;
        @BindView(R.id.ll)
        ConstraintLayout ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
