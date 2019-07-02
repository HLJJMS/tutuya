package com.tutuya.tck.frament.professionalteacher;

import android.view.View;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BaseFragment;


public class CommentFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_comment_pressional_teacher;
    }
}
