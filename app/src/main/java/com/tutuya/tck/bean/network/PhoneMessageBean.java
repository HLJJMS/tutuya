package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：短信验证码实体类
 * @date 创建时间：2019/4/10
 */
public class PhoneMessageBean {

    /**
     * errorcode : 200
     * errormessage : 您好，验证码已发送到您的手机，请注意查收
     * data : []
     */

    private int errorcode;
    private String errormessage;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

}
