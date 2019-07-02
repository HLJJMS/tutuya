package com.tutuya.tck.bean.base;

/**
 * @version 1.0
 * @author  tyh
 * @功能：检查为空的通用类
 * @date 创建时间：2019/4/17
 */
public class GMCheckNullBean {
    String txt;
    Object data;

    public GMCheckNullBean(String txt, Object data) {
        this.txt = txt;
        this.data = data;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
