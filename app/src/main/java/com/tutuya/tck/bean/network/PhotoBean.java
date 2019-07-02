package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/16
 */
public class PhotoBean {
    private String errorcode;
    private String errormessage;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
