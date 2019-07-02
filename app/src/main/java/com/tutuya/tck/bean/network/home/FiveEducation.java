package com.tutuya.tck.bean.network.home;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/25
 */
public class FiveEducation {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"cate":[{"id":11,"img_url":"http://app.tutuyaedu.com/image/nav_1@3.png"},{"id":15,"img_url":"http://app.tutuyaedu.com/image/nav_2@3.png"},{"id":9,"img_url":"http://app.tutuyaedu.com/image/nav_3@3.png"},{"id":13,"img_url":"http://app.tutuyaedu.com/image/nav_4@3.png"},{"id":0,"img_url":"http://app.tutuyaedu.com/image/nav_4@3.png"}]}
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
        private List<CateBean> cate;

        public List<CateBean> getCate() {
            return cate;
        }

        public void setCate(List<CateBean> cate) {
            this.cate = cate;
        }

        public static class CateBean {
            /**
             * id : 11
             * img_url : http://app.tutuyaedu.com/image/nav_1@3.png
             */

            private int id;
            private String img_url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
