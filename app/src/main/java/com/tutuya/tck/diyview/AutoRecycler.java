package com.tutuya.tck.diyview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
/*
* 自动的recyclerview  横向
* 田羽衡create
*
* */

public class AutoRecycler extends RecyclerView {
    boolean isStart=true,rule=true;
    Forward forward = new Forward();
    public AutoRecycler(@NonNull Context context) {
        super(context);

    }

    public AutoRecycler(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        forward.start();
    }

    public AutoRecycler(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                forward.stop();
                break;
            case MotionEvent.ACTION_UP:
//                forward.start();
                break;
        }
        return super.onTouchEvent(e);
    }

    class Forward implements Runnable{
        public Thread t;
        @Override
        public void run() {
            while (isStart==true){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                scrollBy(2,0);
            }
        }
        /**
         * 开始
         */
        public void start(){
            isStart = true;
            if(t==null){
                t=new Thread(this);
            }
            t.start();
        }
        /**
         * 暂停
         */
        void stop(){
            isStart = false;
            t=null;
        }

    }
}
