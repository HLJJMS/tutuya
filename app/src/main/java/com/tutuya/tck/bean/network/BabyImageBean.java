package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：宝宝头像实体类
 * @date 创建时间：2019/4/18
 */
public class BabyImageBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"photo":"/app/baby/201904/155554977592.png","photo_show":"http://test.res.tutuyaedu.com/app/baby/201904/155554977592.png"}
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
         * photo : /app/baby/201904/155554977592.png
         * photo_show : http://test.res.tutuyaedu.com/app/baby/201904/155554977592.png
         */

        private String photo;
        private String photo_show;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPhoto_show() {
            return photo_show;
        }

        public void setPhoto_show(String photo_show) {
            this.photo_show = photo_show;
        }
    }
}
