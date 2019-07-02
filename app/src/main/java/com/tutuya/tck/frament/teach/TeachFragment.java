package com.tutuya.tck.frament.teach;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.ClassingProfessionAdapter;
import com.tutuya.tck.adapter.education.ClassingThreeAdapter;
import com.tutuya.tck.base.BaseFragment;
import com.tutuya.tck.bean.network.classing.ClassHomeBean;
import com.tutuya.tck.diyview.ClassingTitle;
import com.tutuya.tck.frament.IHomeActivityToFramgent;
import com.tutuya.tck.leochuan.CenterSnapHelper;
import com.tutuya.tck.leochuan.ScaleLayoutManager;
import com.tutuya.tck.tools.Util;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeachFragment extends BaseFragment implements IHomeActivityToFramgent {


    @BindView(R.id.title1)
    ClassingTitle title1;
    @BindView(R.id.rec_one)
    RecyclerView recOne;
    @BindView(R.id.title2)
    ClassingTitle title2;
    @BindView(R.id.name_one)
    TextView nameOne;
    @BindView(R.id.detail_one)
    TextView detailOne;
    @BindView(R.id.detail_two)
    TextView detailTwo;
    @BindView(R.id.detail_three)
    TextView detailThree;
    @BindView(R.id.name_two)
    TextView nameTwo;
    @BindView(R.id.name_three)
    TextView nameThree;
    @BindView(R.id.lingxing1)
    ImageView lingxing1;
    @BindView(R.id.lingxing2)
    ImageView lingxing2;
    @BindView(R.id.lingxing3)
    ImageView lingxing3;
    @BindView(R.id.title3)
    ClassingTitle title3;
    @BindView(R.id.rec_two)
    RecyclerView recTwo;
    private CenterSnapHelper centerSnapHelper = new CenterSnapHelper();
    ClassingProfessionAdapter classingProfessionAdapter;
    ClassingThreeAdapter classingThreeAdapter;

    @Override
    protected void initData() {
        aboutAdapterOne();
        aboutAdapterThree();
        getData();
    }

    private void aboutAdapterThree() {
        classingThreeAdapter = new ClassingThreeAdapter(getContext(), getWidth());
        recTwo.setAdapter(classingThreeAdapter);
        recTwo.setLayoutManager(new GridLayoutManager(getContext(), 4));

    }

    private void aboutAdapterOne() {
        classingProfessionAdapter = new ClassingProfessionAdapter(getContext(), getWidth());
        recOne.setAdapter(classingProfessionAdapter);
        ScaleLayoutManager scaleLayoutManager = new ScaleLayoutManager(getContext(), Util.Dp2px(getContext(), 10));
        scaleLayoutManager.setMinScale(0.5f);
        recOne.setLayoutManager(scaleLayoutManager);
        centerSnapHelper.attachToRecyclerView(recOne);
    }

    @Override
    protected void initView(View rootView) {
        mContext = getActivity();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_teach;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void getToken(String token, boolean vip) {

    }

    public void getData() {

        Call<ClassHomeBean> call = inter.getClassing("comment/index");
        call.enqueue(new Callback<ClassHomeBean>() {
            @Override
            public void onResponse(Call<ClassHomeBean> call, Response<ClassHomeBean> response) {
                if (response.body().getErrorcode() == 200) {
                    setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<ClassHomeBean> call, Throwable t) {

            }
        });

    }

    private void setData(ClassHomeBean bean) {
        if (bean.getData().getList2().size() > 0) {
        }
        if (bean.getData().getList1().size() > 0) {
            classingProfessionAdapter.setData(bean.getData().getList1());
        }
        if (bean.getData().getList3().size() > 0) {
            classingThreeAdapter.setData(bean.getData().getList3());
        }
    }
}
