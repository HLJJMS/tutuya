package com.tutuya.tck.frament.familyconnnect;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.GiftListAdapter;
import com.tutuya.tck.base.BaseFragment;
import com.tutuya.tck.bean.network.GiftListForTeacherBean;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GiftListFragment extends BaseFragment {

    @BindView(R.id.rec)
    RecyclerView rec;
    private GiftListAdapter adapter;
    private String token,teacherId;
    @Override
    protected void initData() {
        token = getArguments().getString("token");
        teacherId = getArguments().getString("id");
        adapter = new GiftListAdapter(getContext());
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        rec.setAdapter(adapter);
        getData();
    }

    private void getData() {
        Call<GiftListForTeacherBean> call = inter.getGiftListForTeacher("student/giftlist",token,teacherId,"1","50");
        call.enqueue(new Callback<GiftListForTeacherBean>() {
            @Override
            public void onResponse(Call<GiftListForTeacherBean> call, Response<GiftListForTeacherBean> response) {
                if (response.body().getErrorcode()==200){
                    adapter.setData(response.body().getData().getGift_list(),response.body().getData().getBase_url());
                }
                showToast(response.body().getErrormessage());
            }

            @Override
            public void onFailure(Call<GiftListForTeacherBean> call, Throwable t) {
                showToast(inter.ERRORMESSAGE);
            }
        });



    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_gift_list;
    }


}
