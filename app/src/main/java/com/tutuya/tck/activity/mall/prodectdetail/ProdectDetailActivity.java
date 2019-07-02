package com.tutuya.tck.activity.mall.prodectdetail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutuya.tck.R;
import com.tutuya.tck.adapter.education.CommentAdapter;
import com.tutuya.tck.adapter.mall.MallCommentAdapter;
import com.tutuya.tck.base.BaseMvpActivity;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.diyview.HomeTitle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* create by 田羽衡
 *商品详情界面
 * 20190402
 *
 * */
public class ProdectDetailActivity extends BaseMvpActivity implements IProdectDetailView {


    @BindView(R.id.bt_prodect)
    TextView btProdect;
    @BindView(R.id.bt_comment)
    TextView btComment;
    @BindView(R.id.bt_detail)
    TextView btDetail;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.bt_car)
    ImageView btCar;
    @BindView(R.id.bt_much)
    ImageView btMuch;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.ckeck_like)
    CheckBox ckeckLike;
    @BindView(R.id.txt_shunfeng)
    TextView txtShunfeng;
    @BindView(R.id.bt_sell_number)
    TextView btSellNumber;
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.txt_store)
    TextView txtStore;
    @BindView(R.id.txt_buy_address)
    TextView txtBuyAddress;
    @BindView(R.id.txt_kg)
    TextView txtKg;
    @BindView(R.id.bt_comment_much)
    HomeTitle btCommentMuch;
    @BindView(R.id.comment_rec)
    RecyclerView commentRec;
    @BindView(R.id.customer_service)
    TextView customerService;
    @BindView(R.id.bt_share)
    ImageView btShare;
    @BindView(R.id.share)
    TextView share;
    @BindView(R.id.bt_add_car)
    TextView btAddCar;
    @BindView(R.id.bt_buy)
    TextView btBuy;
    private ProdectDetailPresent present;
    private MallCommentAdapter adapter;

    @Override
    protected BasePresenter createPresenter() {
        present = new ProdectDetailPresent();
        return present;
    }

    @Override
    protected void initPresenter() {
        present.getActivity();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_prodect_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        aboutRecycler();
    }

    private void aboutRecycler() {
        adapter = new MallCommentAdapter(this);
        commentRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        commentRec.setNestedScrollingEnabled(false);
        commentRec.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return this;
    }


    @OnClick({R.id.bt_buy,R.id.bt_prodect, R.id.bt_comment, R.id.bt_detail, R.id.back, R.id.bt_car, R.id.bt_much, R.id.ckeck_like, R.id.bt_sell_number, R.id.txt_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_prodect:
                break;
            case R.id.bt_comment:
                break;
            case R.id.bt_detail:
                break;
            case R.id.back:
                break;
            case R.id.bt_car:
                break;
            case R.id.bt_much:
                break;
            case R.id.ckeck_like:
                break;
            case R.id.bt_sell_number:
                break;
            case R.id.txt_address:
                break;
            case R.id.bt_buy:
                present.showPopup(this, getMyApplication().getWidth(), LayoutInflater.from(this).inflate(R.layout.activity_prodect_detail, null), btBuy.getHeight());
                break;
        }
    }
}
