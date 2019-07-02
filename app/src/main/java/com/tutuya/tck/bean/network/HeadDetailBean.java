package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：脑测评详情bean
 * @date 创建时间：2019/4/18
 */
public class HeadDetailBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"data":{"id":"110","user_identity":"1003","user_id":"268","code":"882019041815528","name":"uu","birth":"1980-04-18","sex":"1","handednes":"左手","phone":"19845269890","evaluation_type":"2","city_partner_id":"1172","school_id":"1306","school_name":"北京绿地幼儿园","class_id":"127","class_name":"幼儿一班","address":"山西省晋城市中心小学","occupation":"","extend24":"","extend25":"","extend30":"","status":"0","msg":"","appo_date":"2019-04-18","appo_tm":"","create_tm":"2019-04-18 15:30:39","dcode":"","doc_url":"http://test.res.tutuyaedu.com","status_show":"未支付","sex_show":"男","evaluation":null,"pro_name":"田羽衡","update_tm":"","show_pic":1,"zip_url":"http://test.res.tutuyaedu.com"}}
     */

    private int errorcode;
    private String errormessage;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : {"id":"110","user_identity":"1003","user_id":"268","code":"882019041815528","name":"uu","birth":"1980-04-18","sex":"1","handednes":"左手","phone":"19845269890","evaluation_type":"2","city_partner_id":"1172","school_id":"1306","school_name":"北京绿地幼儿园","class_id":"127","class_name":"幼儿一班","address":"山西省晋城市中心小学","occupation":"","extend24":"","extend25":"","extend30":"","status":"0","msg":"","appo_date":"2019-04-18","appo_tm":"","create_tm":"2019-04-18 15:30:39","dcode":"","doc_url":"http://test.res.tutuyaedu.com","status_show":"未支付","sex_show":"男","evaluation":null,"pro_name":"田羽衡","update_tm":"","show_pic":1,"zip_url":"http://test.res.tutuyaedu.com"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 110
             * user_identity : 1003
             * user_id : 268
             * code : 882019041815528
             * name : uu
             * birth : 1980-04-18
             * sex : 1
             * handednes : 左手
             * phone : 19845269890
             * evaluation_type : 2
             * city_partner_id : 1172
             * school_id : 1306
             * school_name : 北京绿地幼儿园
             * class_id : 127
             * class_name : 幼儿一班
             * address : 山西省晋城市中心小学
             * occupation :
             * extend24 :
             * extend25 :
             * extend30 :
             * status : 0
             * msg :
             * appo_date : 2019-04-18
             * appo_tm :
             * create_tm : 2019-04-18 15:30:39
             * dcode :
             * doc_url : http://test.res.tutuyaedu.com
             * status_show : 未支付
             * sex_show : 男
             * evaluation : null
             * pro_name : 田羽衡
             * update_tm :
             * show_pic : 1
             * zip_url : http://test.res.tutuyaedu.com
             */

            private String id;
            private String user_identity;
            private String user_id;
            private String code;
            private String name;
            private String birth;
            private String sex;
            private String handednes;
            private String phone;
            private String evaluation_type;
            private String city_partner_id;
            private String school_id;
            private String school_name;
            private String class_id;
            private String class_name;
            private String address;
            private String occupation;
            private String extend24;
            private String extend25;
            private String extend30;
            private String status;
            private String msg;
            private String appo_date;
            private String appo_tm;
            private String create_tm;
            private String dcode;
            private String doc_url;
            private String status_show;
            private String sex_show;
            private Object evaluation;
            private String pro_name;
            private String update_tm;
            private int show_pic;
            private String zip_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_identity() {
                return user_identity;
            }

            public void setUser_identity(String user_identity) {
                this.user_identity = user_identity;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getHandednes() {
                return handednes;
            }

            public void setHandednes(String handednes) {
                this.handednes = handednes;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEvaluation_type() {
                return evaluation_type;
            }

            public void setEvaluation_type(String evaluation_type) {
                this.evaluation_type = evaluation_type;
            }

            public String getCity_partner_id() {
                return city_partner_id;
            }

            public void setCity_partner_id(String city_partner_id) {
                this.city_partner_id = city_partner_id;
            }

            public String getSchool_id() {
                return school_id;
            }

            public void setSchool_id(String school_id) {
                this.school_id = school_id;
            }

            public String getSchool_name() {
                return school_name;
            }

            public void setSchool_name(String school_name) {
                this.school_name = school_name;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getExtend24() {
                return extend24;
            }

            public void setExtend24(String extend24) {
                this.extend24 = extend24;
            }

            public String getExtend25() {
                return extend25;
            }

            public void setExtend25(String extend25) {
                this.extend25 = extend25;
            }

            public String getExtend30() {
                return extend30;
            }

            public void setExtend30(String extend30) {
                this.extend30 = extend30;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getAppo_date() {
                return appo_date;
            }

            public void setAppo_date(String appo_date) {
                this.appo_date = appo_date;
            }

            public String getAppo_tm() {
                return appo_tm;
            }

            public void setAppo_tm(String appo_tm) {
                this.appo_tm = appo_tm;
            }

            public String getCreate_tm() {
                return create_tm;
            }

            public void setCreate_tm(String create_tm) {
                this.create_tm = create_tm;
            }

            public String getDcode() {
                return dcode;
            }

            public void setDcode(String dcode) {
                this.dcode = dcode;
            }

            public String getDoc_url() {
                return doc_url;
            }

            public void setDoc_url(String doc_url) {
                this.doc_url = doc_url;
            }

            public String getStatus_show() {
                return status_show;
            }

            public void setStatus_show(String status_show) {
                this.status_show = status_show;
            }

            public String getSex_show() {
                return sex_show;
            }

            public void setSex_show(String sex_show) {
                this.sex_show = sex_show;
            }

            public Object getEvaluation() {
                return evaluation;
            }

            public void setEvaluation(Object evaluation) {
                this.evaluation = evaluation;
            }

            public String getPro_name() {
                return pro_name;
            }

            public void setPro_name(String pro_name) {
                this.pro_name = pro_name;
            }

            public String getUpdate_tm() {
                return update_tm;
            }

            public void setUpdate_tm(String update_tm) {
                this.update_tm = update_tm;
            }

            public int getShow_pic() {
                return show_pic;
            }

            public void setShow_pic(int show_pic) {
                this.show_pic = show_pic;
            }

            public String getZip_url() {
                return zip_url;
            }

            public void setZip_url(String zip_url) {
                this.zip_url = zip_url;
            }
        }
    }
}
