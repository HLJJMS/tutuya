package com.tutuya.tck.frament.education;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.education.HotClassAdapter;
import com.tutuya.tck.adapter.education.RmvbAdapter;
import com.tutuya.tck.base.BaseFragment;
import com.tutuya.tck.diyview.HomeTitle;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
/*
* 视频viewpager
* create  by  田羽衡
*
* */
public class RmvbFramgent extends BaseFragment {
    @BindView(R.id.bt_grid)
    HomeTitle btGrid;
    @BindView(R.id.grid_rec)
    RecyclerView gridRec;
    @BindView(R.id.title_hrec)
    TextView titleHrec;
    @BindView(R.id.hot_rec)
    RecyclerView hotRec;
    Unbinder unbinder;
    private RmvbAdapter rmvbAdapter;
    private HotClassAdapter hotClassAdapter;

    @Override
    protected void initData() {
        aboutRmvbAdapter();
        aboutHotAdapter();
    }

    private void aboutHotAdapter() {
        hotClassAdapter = new HotClassAdapter(mContext, getWidth());
        hotRec.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        hotRec.setNestedScrollingEnabled(false);
        hotRec.setAdapter(hotClassAdapter);
    }

    private void aboutRmvbAdapter() {
        rmvbAdapter = new RmvbAdapter(mContext, getWidth());
        gridRec.setLayoutManager(new GridLayoutManager(mContext,2));
        gridRec.setNestedScrollingEnabled(false);
        gridRec.setAdapter(rmvbAdapter);
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.framgent_rmvb;
    }

    @OnClick(R.id.bt_grid)
    public void onViewClicked() {
    }
}
