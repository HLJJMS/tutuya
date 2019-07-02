package com.tutuya.tck.diyview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;

/**
 * @version 1.0
 * @author  tyh
 * @功能：可滑动按钮
 * @date 创建时间：2019/4/11
 */
public class DragFloatActionButton extends android.support.v7.widget.AppCompatImageView {
    private int sl, st, sr, sb, lastX, lastY, width, height, layoutLeft, layoutRight, layoutTop, layoutBottom, imageWidth, imageHeight;

    public DragFloatActionButton(Context context) {
        super(context);
    }

    public DragFloatActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        width = dm.widthPixels;     // 屏幕宽度（像素）
        height = dm.heightPixels;   // 屏幕高度（像素）
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        imageHeight = MeasureSpec.getSize(heightMeasureSpec);
        imageWidth = MeasureSpec.getSize(widthMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        //获取手机触摸的坐标
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                sl = getLeft();
                sr = getRight();
                st = getTop();
                sb = getBottom();
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                final float xDistance = x - lastX;
                final float yDistance = y - lastY;
                if (Math.abs(xDistance) > 10 || Math.abs(yDistance) > 10) {
                    if (x < 0) {
                        layoutLeft = imageWidth;
                        layoutRight = imageWidth*2;
                    } else if (x > width) {
                        layoutLeft = width - imageWidth*2;
                        layoutRight = width-imageWidth;
                    } else {
                        layoutLeft = sl + x - lastX;
                        layoutRight = sr + x - lastX;
                    }

                    if (y < 200) {
                        layoutTop=200;
                        layoutBottom=200+imageHeight;
                    } else if (y > height - 100) {
                        layoutTop=height-100-imageHeight;
                        layoutBottom=height-100;
                    }else{
                        layoutTop=st + y - lastY;
                        layoutBottom=sb + y - lastY;
                    }
                    layout(layoutLeft, layoutTop, layoutRight, layoutBottom);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
