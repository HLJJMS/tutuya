package com.tutuya.tck.diyview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SizeChangeRecyclerView extends RecyclerView {
    private Context context;
    private LinearLayoutManager layoutManager;

    public SizeChangeRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        layoutManager = new LinearLayoutManager(context);
        setLayoutManager(layoutManager);
        this.context = context;
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return super.onInterceptTouchEvent(e);
    }

    private void setPadding() {

    }
}
