package com.tutuya.tck.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutuya.tck.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @version 1.0
 * @author  tyh
 * @功能：麦豆界面
 * @date 创建时间：2019/4/20
 */
public class BuyBeanAdapter extends RecyclerView.Adapter<BuyBeanAdapter.ViewHolder> {
    private int width, setItem = 0;
    private Context context;
    public BuyBeanAdapter(int width,Context context) {
        this.width = width;
        this.context = context;
    }

    private String[] title = {"10豆", "20豆", "50豆", "100豆", "200豆", "500豆", "1000豆", "5000豆", "10000豆"};
    private String[] rmb = {"售价：1.00元", "售价：2.00元", "售价：5.00元", "售价：10.00元", "售价：20.00元", "售价：50.00元", "售价：100.00", "售价：500.00元", "售价：1000.00元"};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_buy_bean, viewGroup, false);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = width/3;
        lp.height =250;
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.rmb.setText(rmb[i]);
        viewHolder.title.setText(title[i]);
        if (setItem == i) {
            viewHolder.rmb.setTextColor(Color.WHITE);
            viewHolder.title.setTextColor(Color.WHITE);
            viewHolder.bg.setBackground(context.getResources().getDrawable(R.drawable.yellow_solid));
        } else {
            viewHolder.rmb.setTextColor(0xffFFAD0A);
            viewHolder.title.setTextColor(0xffFFAD0A);
            viewHolder.bg.setBackground(context.getResources().getDrawable(R.drawable.yellow_stroke));
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setItem = i;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bg)
        TextView bg;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.rmb)
        TextView rmb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
