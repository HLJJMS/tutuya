package com.tutuya.tck.diyview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

public class FlowRadioGroup extends RadioGroup {
    public FlowRadioGroup(Context context) {
        super(context);
    }

    public FlowRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = 0, measuredHeight = 0;
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widtMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int groupHeight = compute(widthSize-getPaddingRight());
        if (heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,groupHeight);
        }else{
            setMeasuredDimension(widthSize,heightSize);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Rect rect = (Rect) getChildAt(i).getTag();
            child.layout(rect.left,rect.top,rect.right,rect.bottom);
        }
    }
    private int compute(int size) {
        int heightSum = 0;
        int widthSum = 0;
        MarginLayoutParams marginParams;//子元素margin
        int sum = getChildCount();
        for (int i = 0; i < sum; i++) {
            View view = getChildAt(i);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            marginParams = (MarginLayoutParams) view.getLayoutParams();
            int viewWidth = width + marginParams.leftMargin + marginParams.rightMargin;
            int viewHeight = height + marginParams.topMargin + marginParams.bottomMargin;

            if (viewWidth + widthSum > size) {
                widthSum = 0;
                heightSum = heightSum + viewHeight;
            }
            widthSum = widthSum + viewWidth;
            view.setTag(new Rect(widthSum - viewWidth + marginParams.leftMargin, heightSum + marginParams.topMargin, widthSum - marginParams.rightMargin, heightSum - marginParams.bottomMargin + viewHeight));

            if (i == sum - 1) {
                heightSum = heightSum + viewHeight;
            }
        }
        return heightSum;
    }
}
