package com.tutuya.tck.diyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.tutuya.tck.R;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/12
 */
public class ClassingTitle extends View {
    String bigTxt, smallTxt;
    int lineAndText, top,middle,bottom, bigSize, smallSize, txtColor, size, density, paddingLeft = 0, paddingRight = 0, paddingTop = 0, paddingBottom = 0, WRAP_WIDTH, WRAP_HEIGHT;

    public ClassingTitle(Context context) {
        super(context);
    }

    public ClassingTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        density = (int) dm.density;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ClassingTitle);
        bigTxt = typedArray.getString(R.styleable.ClassingTitle_bigText);
        smallTxt = typedArray.getString(R.styleable.ClassingTitle_smallText);
        bigSize = 16 * density;
        smallSize = 8 * density;
        typedArray.recycle();
        middle = 5*density;
        top = 10 *density;
        bottom = 10*density;
        lineAndText = 5 *density;
        WRAP_HEIGHT = middle + top + bottom + bigSize + smallSize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();
        WRAP_WIDTH = width;
        if (heightMode == MeasureSpec.UNSPECIFIED || heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, WRAP_HEIGHT + paddingBottom + paddingTop);
        } else {
            setMeasuredDimension(width, height + paddingBottom + paddingTop);
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint bigPaint = new Paint();
        Paint smallPaint = new Paint();
        Paint linePaint = new Paint();
        bigPaint.setTextSize(bigSize);
        bigPaint.setTextAlign(Paint.Align.CENTER);
        bigPaint.setColor(0xff333333);
        bigPaint.setStrokeWidth(10f);
        bigPaint.setStyle(Paint.Style.FILL);
        bigPaint.setFakeBoldText(true);
        smallPaint.setTextSize(smallSize);
        smallPaint.setTextAlign(Paint.Align.CENTER);
        smallPaint.setColor(0xff333333);
        smallPaint.setStrokeWidth(10f);
        smallPaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeWidth(2f);
        linePaint.setColor(Color.BLACK);
        Paint.FontMetricsInt bigMetrics = bigPaint.getFontMetricsInt();
        Paint.FontMetricsInt smallMetrics = smallPaint.getFontMetricsInt();
        int bigBaseLine = top+paddingTop+bigSize;
        int smallBaseLine = getHeight()-bottom-paddingBottom;
        int lineY= getHeight() - paddingBottom-bottom - smallSize/2;
        int lineLeftX =(int) (getWidth() - smallPaint.measureText(smallTxt))/2-lineAndText;
        int lineRightY = (int)(getWidth() + smallPaint.measureText(smallTxt))/2+lineAndText;
        canvas.drawText(bigTxt, getWidth() / 2, bigBaseLine, bigPaint);
        canvas.drawLine(10*density, lineY, lineLeftX, lineY, linePaint);
        canvas.drawLine(lineRightY, lineY, getWidth()-10*density, lineY, linePaint);
        canvas.drawText(smallTxt, getWidth() / 2, smallBaseLine, smallPaint);

    }
}
