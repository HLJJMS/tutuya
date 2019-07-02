package com.tutuya.tck.activity.Classing;

import com.tutuya.tck.base.BasePresenter;
//四大教育纽带
public class ClassingPresent extends BasePresenter<IClassingView> {

    private IClassingView view;
    public void getActivity(){
        if(isViewAttached()){
            view = getView();
        }
    }


}
