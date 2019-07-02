package com.tutuya.tck.frament.mall;

import com.tutuya.tck.base.BasePresenter;



public class MallPresent extends BasePresenter<IMallView> {
    private  IMallView view;
    public void getActivity(){
        if(isViewAttached()){
            view = getView();
        }
    }
}
