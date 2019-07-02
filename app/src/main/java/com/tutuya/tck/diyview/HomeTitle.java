package com.tutuya.tck.diyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.tutuya.tck.R;

import static android.graphics.Paint.Align.RIGHT;

/*
 * 通用查看更多的条子
 * create   by   田羽衡
 *
 * */

public class HomeTitle extends View {
    String txt;
    int smallTextColor, columnColor, txtColor, size, density, paddingLeft = 0, paddingRight = 0, paddingTop = 0, paddingBottom = 0, WRAP_WIDTH, WRAP_HEIGHT;

    public HomeTitle(Context context) {
        super(context);
    }

    public HomeTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        density = (int) dm.density;
        // 获取属性集合 TypedArray
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HomeTitle);
        // 获取字符串
        txt = typedArray.getString(R.styleable.HomeTitle_txt);

        // 获取字体大小
        size = (int) typedArray.getDimension(R.styleable.HomeTitle_txtSize, 16 * density);

        WRAP_HEIGHT = size;
        //薯条颜色
        columnColor = typedArray.getColor(R.styleable.HomeTitle_columnColor, R.drawable.baby_bg);
        // 文字颜色
        txtColor = typedArray.getColor(R.styleable.HomeTitle_txtColor, 0xFF666666);
        // 用完要关闭回收资源，必须的强制性的
        smallTextColor = 0xFF5EB130;
        typedArray.recycle();
    }

    public HomeTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint txtPaint = new Paint();//文字
        Paint column = new Paint();//薯条
        Paint txtLast = new Paint();//末尾文字
        Paint imgPaint = new Paint();//末尾的图片
        txtPaint.setColor(txtColor);
        txtPaint.setTextSize(size);
        column.setColor(columnColor);
        txtLast.setColor(smallTextColor);
        txtLast.setTextSize(size - 4 * density);
        txtLast.setTextAlign(RIGHT);
        txtPaint.setStyle(Paint.Style.FILL);
        column.setStyle(Paint.Style.FILL);
        txtLast.setStyle(Paint.Style.FILL);
        txtPaint.setStrokeWidth(30f);
        txtLast.setStrokeWidth(15f);
        column.setStrokeWidth(10f);
        // 获取更清晰的图像采样，防抖动
        txtPaint.setDither(true);
        txtLast.setDither(true);
        column.setDither(true);
        imgPaint.setDither(true);
        // 过滤一下，抗剧齿
        imgPaint.setFilterBitmap(true);
//        canvas.drawRect(0, 0, 3 * density, getHeight(), column);
        Paint.FontMetricsInt fontMetrics = txtLast.getFontMetricsInt();
        int top = fontMetrics.top;
        int bottom = fontMetrics.bottom;
        canvas.drawText(txt, paddingLeft, (getHeight() - top - bottom) / 2, txtPaint);
        Bitmap jiantou = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_go_green);
        canvas.drawBitmap(jiantou, getWidth() - jiantou.getWidth(), (getHeight() - jiantou.getHeight()) / 2, imgPaint);
        canvas.drawText("更多", getWidth() - jiantou.getWidth() - 20, (getHeight() - top - bottom) / 2, txtLast);
        super.onDraw(canvas);
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
        if (heightMode == MeasureSpec.UNSPECIFIED || heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, WRAP_HEIGHT + paddingBottom + paddingTop);
        } else {
            setMeasuredDimension(width, height + paddingBottom + paddingTop);
        }

    }

    public void steTxt(String txt) {
        this.txt = txt;
        invalidate();
    }
}
