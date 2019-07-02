package com.tutuya.tck.base;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
* 抓取崩溃日志
* create  by  田羽衡
* */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Context mContext;
    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private String newLine = "\r\n";
    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        printWriter.close();
        String result = writer.toString();
        sb.append(time).append(newLine).append("设备厂商 :").append(Build.BOARD).append(newLine).append("型号 ：").append(android.os.Build.BRAND).append(Build.MODEL).append(newLine).append(result);
        Log.e("崩溃结果",sb.toString());
        mDefaultHandler.uncaughtException(t, e);
    }
}
