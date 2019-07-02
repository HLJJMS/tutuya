package com.tutuya.tck.bean.base;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/20
 */
public class MessageEvent {

    private boolean message;
    public  MessageEvent(boolean message){
        this.message=message;
    }

    public boolean getMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }
}
