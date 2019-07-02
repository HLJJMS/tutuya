package com.tutuya.tck.base;

import android.content.Context;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/*
* 退出类
* 4*/
public class Quit {
    private Boolean isEnd = false;
    public void ClickTwiceQuit(Context context){
        //点击两次退出
        Handler h = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                isEnd = false;
            }
        };
        if (isEnd == true) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } else {
            isEnd = true;
            Toast.makeText(context, "再按一次退出", Toast.LENGTH_LONG).show();
            h.sendEmptyMessageDelayed(1, 2000);
        }
        context = null;
    }
}
