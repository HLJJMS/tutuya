package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：注册/登录实体类
 * @date 创建时间：2019/4/10
 */
public class LoginBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"token":"dtHuVt0udyXal_haXp2pFwcCwyNjgO0O0O"}
     */

    private int errorcode;
    private String errormessage;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : dtHuVt0udyXal_haXp2pFwcCwyNjgO0O0O
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
