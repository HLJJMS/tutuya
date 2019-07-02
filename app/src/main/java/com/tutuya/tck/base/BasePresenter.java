package com.tutuya.tck.base;

import com.tutuya.tck.base.retrofit.InterfaceForRetrofit;
import com.tutuya.tck.base.retrofit.Retrofit;
import com.tutuya.tck.base.retrofit.RetrofitGM;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;




/**
 * 功能：基础MVPAcitvity
 * Created by wen.ji on 2017/6/1.inter = retrofit.getService();
 *
 * 防止强引用内存泄露
 */
public abstract class BasePresenter<T> {
    protected Retrofit retrofit = Retrofit.getRetrofit();
    protected InterfaceForRetrofit inter=retrofit.getService();
    protected RetrofitGM retrofitGM = RetrofitGM.getRetrofit();
    protected InterfaceForRetrofit interGM=retrofitGM.getService();
    protected Reference<T> mViewRef; //View接口类型的弱引用

    public void attachView(T view){
        mViewRef = new WeakReference<T>(view); //建立关联
    }

    /****
     * 获取View
     * @return View
     */
    protected T getView(){
        return mViewRef.get(); //获取View
    }

    /****
     * 判断是否与View建立关联
     * @return boolean
     */
    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView(){
        if( mViewRef != null){
            mViewRef.clear(); //解除关联
            mViewRef = null;
        }
    }



}
