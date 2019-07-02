package com.tutuya.tck.adapter.my;

import android.content.Context;
import android.content.Intent;
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

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
 * 个人中心列表
 *
 * create by   田羽衡
 * */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int width;
    private WeakReference<Context> context;
    private View view;
    private List<MyBean> list = new ArrayList<>();
    public PostData postData;

    public void CallBackData(PostData postData){
        this.postData = postData;
    }


    public MyAdapter(Context context, int width) {
        this.context = new WeakReference<Context>(context);
        this.width = new Double(width * 0.92).intValue();
        addList();
    }

    public void addList() {
        list.add(new MyBean(R.mipmap.icon_babyinfo, "宝宝信息", new Intent(context.get(), BabyListActivity.class), 3, "家园共育"));
        list.add(new MyBean(R.mipmap.icon_vip, "我的会员", new Intent(context.get(), BabyListActivity.class), 4, "我的钱包"));
        list.add(new MyBean(R.mipmap.icon_order, "全部订单", new Intent(context.get(), BabyListActivity.class), 5, "我的商城"));
        list.add(new MyBean(R.mipmap.icon_feedback, "问题反馈", new Intent(context.get(), BabyListActivity.class), 3, "联系我们"));
        list.add(new MyBean(R.mipmap.icon_wallet, "待付款", new Intent(context.get(), BabyListActivity.class), 5));
        list.add(new MyBean(R.mipmap.icon_up, "我的收益", new Intent(context.get(), BabyListActivity.class), 4));

        list.add(new MyBean(R.mipmap.icon_home, "家园互通", new Intent(context.get(), FamilyConnectActivity.class), 3));
        list.add(new MyBean(R.mipmap.icon_tel, "联系我们", new Intent(context.get(), BabyListActivity.class), 3));
        list.add(new MyBean(R.mipmap.icon_car, "待收货", new Intent(context.get(), BabyListActivity.class), 5));
        list.add(new MyBean(R.mipmap.icon_record, "消费记录", new Intent(context.get(), BabyListActivity.class), 4));
        list.add(new MyBean(R.mipmap.icon_good, "待评价", new Intent(context.get(), BabyListActivity.class), 5));
        list.add(new MyBean(R.mipmap.icon_head, "脑象测评", new Intent(context.get(), HeadTestListActivity.class), 3));
        list.add(new MyBean(R.mipmap.icon_book, "知识产权告知书", new Intent(context.get(), BabyListActivity.class), 3));


        list.add(new MyBean(R.mipmap.icon_wallet, "我的银行卡", new Intent(context.get(), BabyListActivity.class), 4));
        list.add(new MyBean(R.mipmap.icon_after, "退换/售后", new Intent(context.get(), BabyListActivity.class), 5));

    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, final int i) {
        if (i < 4) {
            viewHolder.title.setText(list.get(i).getTitle());
        }
        ViewGroup.LayoutParams llt = viewHolder.ll.getLayoutParams();
        llt.width = width / list.get(i).getDivisor();
        viewHolder.ll.setLayoutParams(llt);
        viewHolder.beautyImage.setImageResource(list.get(i).getImg());
        viewHolder.nameTv.setText(list.get(i).getTxt());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==6){
                    postData.setFamilyData();
                }else{
                    context.get().startActivity(list.get(i).getIntent());
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return 15;
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

    public interface PostData{
        void setFamilyData();
    }

}
