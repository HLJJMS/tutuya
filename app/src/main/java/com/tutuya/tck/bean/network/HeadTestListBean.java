package com.tutuya.tck.bean.network;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：脑测评列表
 * @date 创建时间：2019/4/18
 */
public class HeadTestListBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"page":"1","page_size":"10","data":[{"id":"110","user_identity":"1003","user_id":"268","code":"882019041815528","name":"uu","birth":"1980-04-18","sex":"1","handednes":"1","phone":"19845269890","evaluation_type":"2","city_partner_id":"1172","school_id":"1306","school_name":"北京绿地幼儿园","class_id":"127","class_name":"幼儿一班","address":"山西省晋城市中心小学","occupation":"","memo":"","ext_queue_state":"0","ext_task_state":"0","extend24":"","extend25":"","extend30":"","extend31":"","extend32":"","status":"0","msg":"","appo_date":"2019-04-18","appo_tm":null,"create_tm":"2019-04-18 15:30:39","update_tm":null,"status_value":"未支付","status_color":"#0000FF"},{"id":"109","user_identity":"1003","user_id":"268","code":"882019041815184","name":"uu","birth":"1980-04-18","sex":"1","handednes":"1","phone":"19845263345","evaluation_type":"2","city_partner_id":"1172","school_id":"1306","school_name":"北京绿地幼儿园","class_id":"127","class_name":"幼儿一班","address":"山西省晋城市中心小学","occupation":"","memo":"","ext_queue_state":"0","ext_task_state":"0","extend24":"","extend25":"","extend30":"","extend31":"","extend32":"","status":"0","msg":"","appo_date":"2019-04-18","appo_tm":null,"create_tm":"2019-04-18 15:29:02","update_tm":null,"status_value":"未支付","status_color":"#0000FF"}]}
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
         * page : 1
         * page_size : 10
         * data : [{"id":"110","user_identity":"1003","user_id":"268","code":"882019041815528","name":"uu","birth":"1980-04-18","sex":"1","handednes":"1","phone":"19845269890","evaluation_type":"2","city_partner_id":"1172","school_id":"1306","school_name":"北京绿地幼儿园","class_id":"127","class_name":"幼儿一班","address":"山西省晋城市中心小学","occupation":"","memo":"","ext_queue_state":"0","ext_task_state":"0","extend24":"","extend25":"","extend30":"","extend31":"","extend32":"","status":"0","msg":"","appo_date":"2019-04-18","appo_tm":null,"create_tm":"2019-04-18 15:30:39","update_tm":null,"status_value":"未支付","status_color":"#0000FF"},{"id":"109","user_identity":"1003","user_id":"268","code":"882019041815184","name":"uu","birth":"1980-04-18","sex":"1","handednes":"1","phone":"19845263345","evaluation_type":"2","city_partner_id":"1172","school_id":"1306","school_name":"北京绿地幼儿园","class_id":"127","class_name":"幼儿一班","address":"山西省晋城市中心小学","occupation":"","memo":"","ext_queue_state":"0","ext_task_state":"0","extend24":"","extend25":"","extend30":"","extend31":"","extend32":"","status":"0","msg":"","appo_date":"2019-04-18","appo_tm":null,"create_tm":"2019-04-18 15:29:02","update_tm":null,"status_value":"未支付","status_color":"#0000FF"}]
         */

        private String page;
        private String page_size;
        private List<DataBean> data;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
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
             * handednes : 1
             * phone : 19845269890
             * evaluation_type : 2
             * city_partner_id : 1172
             * school_id : 1306
             * school_name : 北京绿地幼儿园
             * class_id : 127
             * class_name : 幼儿一班
             * address : 山西省晋城市中心小学
             * occupation :
             * memo :
             * ext_queue_state : 0
             * ext_task_state : 0
             * extend24 :
             * extend25 :
             * extend30 :
             * extend31 :
             * extend32 :
             * status : 0
             * msg :
             * appo_date : 2019-04-18
             * appo_tm : null
             * create_tm : 2019-04-18 15:30:39
             * update_tm : null
             * status_value : 未支付
             * status_color : #0000FF
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
            private String memo;
            private String ext_queue_state;
            private String ext_task_state;
            private String extend24;
            private String extend25;
            private String extend30;
            private String extend31;
            private String extend32;
            private String status;
            private String msg;
            private String appo_date;
            private Object appo_tm;
            private String create_tm;
            private Object update_tm;
            private String status_value;
            private String status_color;

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

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getExt_queue_state() {
                return ext_queue_state;
            }

            public void setExt_queue_state(String ext_queue_state) {
                this.ext_queue_state = ext_queue_state;
            }

            public String getExt_task_state() {
                return ext_task_state;
            }

            public void setExt_task_state(String ext_task_state) {
                this.ext_task_state = ext_task_state;
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

            public String getExtend31() {
                return extend31;
            }

            public void setExtend31(String extend31) {
                this.extend31 = extend31;
            }

            public String getExtend32() {
                return extend32;
            }

            public void setExtend32(String extend32) {
                this.extend32 = extend32;
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

            public Object getAppo_tm() {
                return appo_tm;
            }

            public void setAppo_tm(Object appo_tm) {
                this.appo_tm = appo_tm;
            }

            public String getCreate_tm() {
                return create_tm;
            }

            public void setCreate_tm(String create_tm) {
                this.create_tm = create_tm;
            }

            public Object getUpdate_tm() {
                return update_tm;
            }

            public void setUpdate_tm(Object update_tm) {
                this.update_tm = update_tm;
            }

            public String getStatus_value() {
                return status_value;
            }

            public void setStatus_value(String status_value) {
                this.status_value = status_value;
            }

            public String getStatus_color() {
                return status_color;
            }

            public void setStatus_color(String status_color) {
                this.status_color = status_color;
            }
        }
    }
}
