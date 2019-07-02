package com.tutuya.tck.bean.network;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：学校信息BEAN
 * @date 创建时间：2019/4/17
 */
public class SchoolBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : [{"id":"1008","name":"涂涂鸦童创客哈十幼","old_name":""},{"id":"1007","name":"涂涂鸦童创客哈九幼","old_name":""},{"id":"1006","name":"涂涂鸦童创客哈八幼","old_name":""},{"id":"1005","name":"涂涂鸦童创客哈七幼","old_name":""},{"id":"1004","name":"涂涂鸦童创客哈六幼","old_name":""},{"id":"1003","name":"涂涂鸦童创客哈五幼","old_name":""},{"id":"1001","name":"涂涂鸦童创客哈二幼","old_name":"3334"},{"id":"1000","name":"涂涂鸦童创客哈一幼","old_name":"3334444"}]
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

    public static class DataBean implements IPickerViewData {
        /**
         * id : 1008
         * name : 涂涂鸦童创客哈十幼
         * old_name :
         */

        private String id;
        private String name;
        private String old_name;

        private String director;
        private String phone;
        private String address;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOld_name() {
            return old_name;
        }

        public void setOld_name(String old_name) {
            this.old_name = old_name;
        }

        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
