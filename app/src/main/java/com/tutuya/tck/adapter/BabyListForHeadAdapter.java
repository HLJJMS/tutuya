package com.tutuya.tck.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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
import com.tutuya.tck.R;
import com.tutuya.tck.activity.baby.AddBabyActivity;
import com.tutuya.tck.activity.baby.AddUnSchoolBabyActivity;
import com.tutuya.tck.activity.headtest.AddHeadTestActivity;
import com.tutuya.tck.bean.network.BabyListBean;
import com.tutuya.tck.diyview.SwipeRecycler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*//
宝贝列表adapter
create 田羽衡
*/
public class BabyListForHeadAdapter extends RecyclerView.Adapter<BabyListForHeadAdapter.ViewHolder> {
    private View view;
    private List<BabyListBean.DataBean> listBean = new ArrayList<>();
    private WeakReference<Context> context;

    public void setData(List<BabyListBean.DataBean> listBean) {
        this.listBean.clear();
        this.listBean.addAll(listBean);
        notifyDataSetChanged();
    }

    private DelItem delItem;

    public BabyListForHeadAdapter(Context context) {

        this.context = new WeakReference<>(context);
    }

    public void setDelItem(DelItem delItem) {
        this.delItem = delItem;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_babylist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        ViewGroup.LayoutParams lp = viewHolder.cl.getLayoutParams();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        viewHolder.edit.setText("选择");
        viewHolder.name.setText(listBean.get(i).getName());
        viewHolder.iclass.setText(listBean.get(i).getClass_name());
        viewHolder.school.setText(listBean.get(i).getSchool_name());
        Glide.with(context.get()).load(listBean.get(i).getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(viewHolder.img);
        viewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listBean.get(i).getIs_tck().equals("0")) {
                    Intent editIntent = new Intent(context.get(), AddHeadTestActivity.class);
                    editIntent.putExtra("source","不在园");
                    editIntent.putExtra("id", listBean.get(i).getBaby_id());
                    context.get().startActivity(editIntent);
                } else {
                    Intent editIntent = new Intent(context.get(), AddHeadTestActivity.class);
                    editIntent.putExtra("id", listBean.get(i).getBaby_id());
                    editIntent.putExtra("source","在园");
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
        //模拟删除
        notifyItemRemoved(i);
        notifyItemRangeChanged(0, listBean.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name, iclass, school, edit;
        private Button del;
        private ConstraintLayout cl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.headimg);
            name = itemView.findViewById(R.id.name);
            iclass = itemView.findViewById(R.id.iclass);
            edit = itemView.findViewById(R.id.edit);
            del = itemView.findViewById(R.id.del);
            school = itemView.findViewById(R.id.school);
            cl = itemView.findViewById(R.id.cl);
        }
    }

    public interface DelItem {
        void del(int i, String id);
    }
}
