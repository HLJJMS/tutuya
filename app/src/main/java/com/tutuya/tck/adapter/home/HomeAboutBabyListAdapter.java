package com.tutuya.tck.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.activity.FamilyConnectActivity;
import com.tutuya.tck.activity.baby.BabyListActivity;
import com.tutuya.tck.activity.headtest.HeadTestListActivity;
import com.tutuya.tck.bean.base.MyBean;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
 * 宝贝相关的那一部分
 * create by
 *  田羽衡
 * */
public class HomeAboutBabyListAdapter extends RecyclerView.Adapter<HomeAboutBabyListAdapter.ViewHolder> {
    private View view;
    private int width;
    private Reference<Context> context;
    private List<MyBean> list = new ArrayList<>();
    private Resources resources;
    private Drawable drawable;

    public HomeAboutBabyListAdapter(int width, Context context) {
        this.width = new Double(width * 0.92).intValue();
        this.context = new WeakReference<Context>(context);
        resources = context.getResources();
        drawable = resources.getDrawable(R.drawable.corner_white_solid);
        addList();
    }


    private void addList() {
        list.add(new MyBean(R.mipmap.icon_babyinfo, "宝宝信息", new Intent(context.get(), BabyListActivity.class), 3));
        list.add(new MyBean(R.mipmap.icon_home, "家园互通",  new Intent(context.get(), FamilyConnectActivity.class), 3));
        list.add(new MyBean(R.mipmap.icon_head, "脑象测评",new Intent(context.get(), HeadTestListActivity.class), 3));
    }

    @NonNull
    @Override
    public HomeAboutBabyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAboutBabyListAdapter.ViewHolder viewHolder, final int i) {
        ViewGroup.LayoutParams llt = viewHolder.ll.getLayoutParams();
        llt.width = width / list.get(i).getDivisor();
        viewHolder.ll.setLayoutParams(llt);
        viewHolder.ll.setBackground(drawable);
        viewHolder.title.setVisibility(View.GONE);
        viewHolder.beautyImage.setImageResource(list.get(i).getImg());
        viewHolder.nameTv.setText(list.get(i).getTxt());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.get().startActivity(list.get(i).getIntent());

            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView beautyImage;
        TextView nameTv, title;
        LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            beautyImage = itemView.findViewById(R.id.image_item);
            nameTv = itemView.findViewById(R.id.name_item);
            ll = itemView.findViewById(R.id.ll);
            title = itemView.findViewById(R.id.title);
        }
    }
}
