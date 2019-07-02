package com.tutuya.tck.frament.professionalteacher;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.TeacherDetailClassingAdapter;
import com.tutuya.tck.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ClassingFragment extends BaseFragment {

    @BindView(R.id.rec)
    RecyclerView rec;
    Unbinder unbinder;
    TeacherDetailClassingAdapter adapter;
    @Override
    protected void initData() {
    adapter = new TeacherDetailClassingAdapter();
    rec.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    rec.setAdapter(adapter);
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_classing2;
    }
}
