package com.tutuya.tck.frament.education;

import android.view.View;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseFragment;

/*
* create by 田羽衡
* 详情部分
* */


public class DetailFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_detail;
    }
}
