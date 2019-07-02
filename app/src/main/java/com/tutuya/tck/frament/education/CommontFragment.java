package com.tutuya.tck.frament.education;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.education.CommentAdapter;
import com.tutuya.tck.base.BaseFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/*
* 评论的viewpager、
* create   田羽衡
*
* */


public class CommontFragment extends BaseFragment {
    @BindView(R.id.rec)
    RecyclerView rec;
    Unbinder unbinder;
    private CommentAdapter adapter;

    @Override
    protected void initData() {
        adapter = new CommentAdapter(getActivity());
        rec.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rec.setAdapter(adapter);
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_comment;
    }

}
