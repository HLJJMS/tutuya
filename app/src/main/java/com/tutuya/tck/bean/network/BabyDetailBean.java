package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/16
 */
public class BabyDetailBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"baby_id":"485","user_id":"268","photo":"","school_id":"1307","name":"啾啾啾","idcard":"230802199506300116","birthday":"2019-04-17","sex":"1","school_name":"北京双语幼儿园","class_name":"幼儿二班","class_id":"129","province_id":"1","city_id":"2","county_id":"8","province_name":"北京","city_name":"北京市","county_name":"海淀区","sex_show":"男"}
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
         * baby_id : 485
         * user_id : 268
         * photo :
         * school_id : 1307
         * name : 啾啾啾
         * idcard : 230802199506300116
         * birthday : 2019-04-17
         * sex : 1
         * school_name : 北京双语幼儿园
         * class_name : 幼儿二班
         * class_id : 129
         * province_id : 1
         * city_id : 2
         * county_id : 8
         * province_name : 北京
         * city_name : 北京市
         * county_name : 海淀区
         * sex_show : 男
         */

        private String baby_id;
        private String user_id;
        private String photo;
        private String school_id;
        private String name;
        private String idcard;
        private String birthday;
        private String sex;
        private String school_name;
        private String class_name;
        private String class_id;
        private String province_id;
        private String city_id;
        private String county_id;
        private String province_name;
        private String city_name;
        private String county_name;
        private String sex_show;
        private String photo_show;

        public String getPhoto_show() {
            return photo_show;
        }

        public void setPhoto_show(String photo_show) {
            this.photo_show = photo_show;
        }

        public String getBaby_id() {
            return baby_id;
        }

        public void setBaby_id(String baby_id) {
            this.baby_id = baby_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getSchool_id() {
            return school_id;
        }

        public void setSchool_id(String school_id) {
            this.school_id = school_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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

        public String getClass_id() {
            return class_id;
        }

        public void setClass_id(String class_id) {
            this.class_id = class_id;
        }

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCounty_id() {
            return county_id;
        }

        public void setCounty_id(String county_id) {
            this.county_id = county_id;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCounty_name() {
            return county_name;
        }

        public void setCounty_name(String county_name) {
            this.county_name = county_name;
        }

        public String getSex_show() {
            return sex_show;
        }

        public void setSex_show(String sex_show) {
            this.sex_show = sex_show;
        }
    }
}
