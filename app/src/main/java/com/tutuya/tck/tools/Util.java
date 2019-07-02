package com.tutuya.tck.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.tutuya.tck.bean.base.GMCheckNullBean;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by terry on 25/10/2017.
 */
/*
 * 杂项工具类
 **/
public class Util {
    //    dp换算px
    public static int Dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static String formatFloat(float value) {
        return String.format(Locale.getDefault(), "%.3f", value);
    }

    //    获取view的高度
    public static int getViewHeight(View view) {
        if (null == view) {
            return 0;
        } else {
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            view.measure(h, 0);
            return view.getMeasuredHeight();
        }

    }

    //    获取view的宽度
    public static int getViewWidth(View view) {
        if (null == view) {
            return 0;
        } else {
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            view.measure(0, w);
            return view.getMeasuredHeight();
        }
    }

    //设置view 的margin
    public static ViewGroup.MarginLayoutParams setMargins(View view, int left, int top, int right, int bottom) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginParams = null;
        //获取view的margin设置参数
        if (params instanceof ViewGroup.MarginLayoutParams) {
            marginParams = (ViewGroup.MarginLayoutParams) params;
        } else {
            //不存在时创建一个新的参数
            marginParams = new ViewGroup.MarginLayoutParams(params);
        }
        marginParams.setMargins(left, top, right, bottom);
        return marginParams;
    }

    //    常规非空验证
    public static String checkNull(List<GMCheckNullBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getData().equals("") || list.get(i).getData().equals(null)) {
                return list.get(i).getTxt() + "不能为空";
            }
        }
        return "ok";
    }


    //带手机号的非空验证
    public static String checkNull(List<GMCheckNullBean> list, String phone) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("") || list.get(i).equals(null)) {
                return list.get(i).getTxt() + "不能为空";
            }
        }
        if (isMobile(phone)) {
            return "ok";
        } else {
            return "手机号码格式错误";
        }
    }
//    手机验证

    public static boolean isMobile(String mobile) {
        String str = mobile;
        String pattern = "^(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57]|19[89]|166)[0-9]{8}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    /*------------------------------------------------身份证验证----------------------------------------------------------*/
    public static boolean validateIdNumber(String idNumber) {
        //
        Pattern p1 = Pattern.compile("(\\d{17}[0-9xX]|\\d{14}[0-9xX])");
        Matcher matcher = p1.matcher(idNumber);
        if (matcher.matches()) {
            Pattern p2 = Pattern.compile("\\d{6}(\\d{8}).*"); // 用于提取出生日字符串
            Pattern p3 = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");// 用于将生日字符串进行分解为年月日
            Matcher matcher2 = p2.matcher(idNumber);
            boolean flag = matcher2.find();
            if (flag) {
                String date = matcher2.group(1);
                Matcher matcher3 = p3.matcher(date);
                if (matcher3.find()) {
                    String year = matcher3.group(1);
                    int month = Integer.parseInt(matcher3.group(2));
                    int day = Integer.parseInt(matcher3.group(3));
                    if (month < 1 || month > 12) {
                        return false;
                    }
                    if (day > getDays(year, month) || day < 1) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static int getDays(String year, int month) {
        int days = 0;
        switch (month) {
            case 1:
                days = 31;
                break;
            case 3:
                days = 31;
                break;
            case 5:
                days = 31;
                break;
            case 7:
                days = 31;
                break;
            case 8:
                days = 31;
                break;
            case 10:
                days = 31;
                break;
            case 12:
                days = 31;
                break;
            case 2:
                if (isLeapYear(year))
                    days = 29;
                else
                    days = 28;
                break;
            default:
                days = 30;
        }
        return days;
    }

    public static boolean isLeapYear(String year) {
        Long yearL = Long.parseLong(year);
        if ((yearL % 4 == 0) && (yearL % 100 != 0) || (yearL % 400 == 0)) {
            return true;
        }
        return false;
    }


    /*-------------------------------------------身份证验证结束------------------------------------------*/

}
