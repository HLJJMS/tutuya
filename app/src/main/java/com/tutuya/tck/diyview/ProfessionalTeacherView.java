package com.tutuya.tck.diyview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/12
 */
public class ProfessionalTeacherView extends View {
    int smallTextColor, columnColor, txtColor, size, density, paddingLeft = 0, paddingRight = 0, paddingTop = 0, paddingBottom = 0, WRAP_WIDTH, WRAP_HEIGHT;

    public ProfessionalTeacherView(Context context) {
        super(context);
    }

    public ProfessionalTeacherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widtMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();
        if (widtMode == MeasureSpec.AT_MOST || widtMode == MeasureSpec.UNSPECIFIED) {

        } else {
            WRAP_WIDTH = widthSize + paddingLeft + paddingRight;
        }
        if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED) {

        } else {
            WRAP_HEIGHT = heightSize + paddingBottom + paddingTop;
        }
    }
}
