package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：个人信息bean
 * @date 创建时间：2019/4/15
 */
public class UserInfoBean  {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"nickname":"","headimgurl":"http://app.tutuyaedu.com/image/noimage.jpeg","phone":"19845269239","realname":"","username":"19845269239","relationship":"","sex":"0","occupation":"0","address":"","id_type":"1","id_val":"","vc_balance":"0","baby_name":"","school_name":"","sex_show":"","id_type_show":"身份证","occupation_show":""}
     */

    private String errorcode;
    private String errormessage;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nickname :
         * headimgurl : http://app.tutuyaedu.com/image/noimage.jpeg
         * phone : 19845269239
         * realname :
         * username : 19845269239
         * relationship :
         * sex : 0
         * occupation : 0
         * address :
         * id_type : 1
         * id_val :
         * vc_balance : 0
         * baby_name :
         * school_name :
         * sex_show :
         * id_type_show : 身份证
         * occupation_show :
         */

        private String nickname;
        private String headimgurl;
        private String phone;
        private String realname;
        private String username;
        private String relationship;
        private String sex;
        private String occupation;
        private String address;
        private String id_type;
        private String id_val;
        private String vc_balance;
        private String baby_name;
        private String school_name;
        private String sex_show;
        private String id_type_show;
        private String occupation_show;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRelationship() {
            return relationship;
        }

        public void setRelationship(String relationship) {
            this.relationship = relationship;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getId_type() {
            return id_type;
        }

        public void setId_type(String id_type) {
            this.id_type = id_type;
        }

        public String getId_val() {
            return id_val;
        }

        public void setId_val(String id_val) {
            this.id_val = id_val;
        }

        public String getVc_balance() {
            return vc_balance;
        }

        public void setVc_balance(String vc_balance) {
            this.vc_balance = vc_balance;
        }

        public String getBaby_name() {
            return baby_name;
        }

        public void setBaby_name(String baby_name) {
            this.baby_name = baby_name;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }

        public String getSex_show() {
            return sex_show;
        }

        public void setSex_show(String sex_show) {
            this.sex_show = sex_show;
        }

        public String getId_type_show() {
            return id_type_show;
        }

        public void setId_type_show(String id_type_show) {
            this.id_type_show = id_type_show;
        }

        public String getOccupation_show() {
            return occupation_show;
        }

        public void setOccupation_show(String occupation_show) {
            this.occupation_show = occupation_show;
        }
    }
}
