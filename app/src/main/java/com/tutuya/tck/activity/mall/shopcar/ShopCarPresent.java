package com.tutuya.tck.activity.mall.shopcar;

import com.tutuya.tck.base.BasePresenter;

public class ShopCarPresent extends BasePresenter<IShopCarView> {
    private IShopCarView view;

    // 初始化VIEW
    public void getActivity() {
        if (isViewAttached()) {
            view = getView();
        } else {
            return;
        }
    }
}
