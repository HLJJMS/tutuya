package com.tutuya.tck.diyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.tutuya.tck.R;

import java.lang.ref.WeakReference;
/*
* 数字选择器
* create by 田羽衡
*
* */


public class NumberView extends View {
    int VIEW_WIDTH, VIEW_HEIGHT, size, value = 0;

        WeakReference<Context> context;
    public NumberView(Context context) {
        super(context);

    }

    public NumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = new WeakReference<Context>(context);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int density = (int) dm.density;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberView);
        size = (int) typedArray.getDimension(R.styleable.NumberView_number_txtSize, 14 * density);
        VIEW_HEIGHT = size + 20;
    }

    public NumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthModel = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightModel = MeasureSpec.getMode(heightMeasureSpec);
        if (heightModel != MeasureSpec.AT_MOST) {
            VIEW_HEIGHT = heightSize;
        }
        VIEW_WIDTH = VIEW_HEIGHT * 6;
        if (widthModel != MeasureSpec.AT_MOST) {
            VIEW_WIDTH = widthSize;
        }
        setMeasuredDimension(VIEW_WIDTH + getPaddingLeft() + getPaddingRight(), VIEW_HEIGHT + getPaddingBottom() + getPaddingTop());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(size);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(10f);
        float top = paint.getFontMetrics().top;
        float bottom = paint.getFontMetrics().bottom;
        int baseLine = (int) (VIEW_HEIGHT - top - bottom) / 2;
        canvas.drawText("—", VIEW_WIDTH / 6, baseLine, paint);
        canvas.drawText(String.valueOf(value), VIEW_WIDTH / 2, baseLine, paint);
        canvas.drawText("+", VIEW_WIDTH / 6 * 5, baseLine, paint);
        Paint linePaint = new Paint();
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(2f);
//        两条竖线
        canvas.drawLine(VIEW_WIDTH / 3, 0, VIEW_WIDTH / 3, VIEW_HEIGHT, linePaint);
        canvas.drawLine(VIEW_WIDTH / 3 * 2, 0, VIEW_WIDTH / 3 * 2, VIEW_HEIGHT, linePaint);

//        两条横线
        canvas.drawLine(VIEW_HEIGHT/2, 0, VIEW_WIDTH - VIEW_HEIGHT/2, 0, linePaint);
        canvas.drawLine(VIEW_HEIGHT/2, VIEW_HEIGHT, VIEW_WIDTH - VIEW_HEIGHT/2, VIEW_HEIGHT, linePaint);


        canvas.drawArc(new RectF(VIEW_WIDTH - VIEW_HEIGHT, 0, VIEW_WIDTH, VIEW_HEIGHT), -270, -180, false, linePaint);
        canvas.drawArc(new RectF(0, 0, VIEW_HEIGHT, VIEW_HEIGHT), -90, -180, false, linePaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float startX = event.getX();
                float startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                float endX = event.getX();
                float endY = event.getY();
                Log.e("点击",String.valueOf(endX));
                Log.e("点击点击",String.valueOf(endY));
                if (endX < VIEW_WIDTH / 3) {
                    if (value == 1) {
                        Toast.makeText(context.get(),"已到最小值", Toast.LENGTH_LONG).show();
                    } else {
                        value = value - 1;
                        invalidate();
                    }

                } else if (endX > VIEW_WIDTH / 3 * 2) {
                    value = value + 1;
                    invalidate();
                }
                break;
        }

        return true;//消耗了
//        return super.onTouchEvent(event);
    }
}
