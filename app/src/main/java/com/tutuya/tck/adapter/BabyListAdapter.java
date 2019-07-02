package com.tutuya.tck.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;
import com.tutuya.tck.R;
import com.tutuya.tck.activity.baby.AddBabyActivity;
import com.tutuya.tck.activity.baby.AddUnSchoolBabyActivity;
import com.tutuya.tck.base.BaseActivity;
import com.tutuya.tck.bean.network.BabyListBean;
import com.tutuya.tck.diyview.SwipeRecycler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*//
宝贝列表adapter
create 田羽衡
*/
public class BabyListAdapter extends RecyclerView.Adapter<BabyListAdapter.ViewHolder> {
    private View view;
    private SwipeRecycler recycler;
    private List<BabyListBean.DataBean> listBean = new ArrayList<>();
    private WeakReference<Context> context;

    public void setData(List<BabyListBean.DataBean> listBean) {
        this.listBean.clear();
        this.listBean.addAll(listBean);
        notifyDataSetChanged();
    }

    private DelItem delItem;

    public BabyListAdapter(SwipeRecycler recycler, Context context) {
        this.recycler = recycler;
        this.context = new WeakReference<>(context);
    }

    public void setDelItem(DelItem delItem) {
        this.delItem = delItem;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_babylist, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = recycler.getScreenWidth() + recycler.dp2px(90);
        view.setLayoutParams(layoutParams);
        //这里假设这个txt是主view
        View main = view.findViewById(R.id.cl);
        ViewGroup.LayoutParams mainLayoutParams = main.getLayoutParams();
        mainLayoutParams.width = recycler.getScreenWidth();
        main.setLayoutParams(mainLayoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(listBean.get(i).getName());
        viewHolder.iclass.setText(listBean.get(i).getClass_name());
        viewHolder.school.setText(listBean.get(i).getSchool_name());
        Glide.with(context.get()).load(listBean.get(i).getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycler.closeExAnim();
                Log.e("位置位置", String.valueOf(i));
            }
        });
        viewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listBean.get(i).getIs_tck().equals("0")) {
                    Intent editIntent = new Intent(context.get(), AddUnSchoolBabyActivity.class);
                    editIntent.putExtra("id", listBean.get(i).getBaby_id());
                    context.get().startActivity(editIntent);
                } else {
                    Intent editIntent = new Intent(context.get(), AddBabyActivity.class);
                    editIntent.putExtra("id", listBean.get(i).getBaby_id());
                    context.get().startActivity(editIntent);
                }



            }
        });
        viewHolder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delItem.del(i, listBean.get(i).getBaby_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBean.size();
    }

    public void delItemForActivity(int i) {
        listBean.remove(i);
        recycler.closeEx();
        //模拟删除
        notifyItemRemoved(i);
        notifyItemRangeChanged(0, listBean.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name, iclass, school, edit;
        private Button del;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.headimg);
            name = itemView.findViewById(R.id.name);
            iclass = itemView.findViewById(R.id.iclass);
            edit = itemView.findViewById(R.id.edit);
            del = itemView.findViewById(R.id.del);
            school = itemView.findViewById(R.id.school);
        }
    }

    public interface DelItem {
        void del(int i, String id);
    }
}
