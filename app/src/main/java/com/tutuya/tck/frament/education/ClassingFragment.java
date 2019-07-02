package com.tutuya.tck.frament.education;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.zaixianketang.ClassingAdapter;
import com.tutuya.tck.base.BaseFragment;

import butterknife.BindView;

/*
* 四大教育分支课程的viewpager
* create  田羽衡
* */

public class ClassingFragment extends BaseFragment {
    ClassingAdapter adapter;
    @BindView(R.id.rec)
    RecyclerView rec;

    @Override
    protected void initData() {
        adapter = new ClassingAdapter();
        rec.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rec.setAdapter(adapter);
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_classing;
    }

}
