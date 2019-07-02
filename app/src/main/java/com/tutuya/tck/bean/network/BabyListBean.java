package com.tutuya.tck.bean.network;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：宝宝列表
 * @date 创建时间：2019/4/16
 */
public class BabyListBean {

    /**
     * errorcode :
     * errormessage :
     * data : [{"baby_id":"","photo":"","name":"","school_name":"","class_name":""}]
     */

    private String errorcode;
    private String errormessage;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements IPickerViewData  {
        /**
         * baby_id :
         * photo :
         * name :
         * school_name :
         * class_name :
         */

        private String baby_id;
        private String photo;
        private String name;
        private String school_name;
        private String class_name;
        private String is_tck;

        public String getIs_tck() {
            return is_tck;
        }

        public void setIs_tck(String is_tck) {
            this.is_tck = is_tck;
        }

        public String getBaby_id() {
            return baby_id;
        }

        public void setBaby_id(String baby_id) {
            this.baby_id = baby_id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }


        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
