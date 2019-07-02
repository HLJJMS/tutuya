package com.tutuya.tck.bean.network;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/24
 */
public class TeacherBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"teacher_id":"2","teacher_from":"0","is_tck":"1","is_pay":"0","name":"张婷","phone":"15603653205","headimgurl":"","openid":"","sex":"0","idcard":"230303199602016624","id_card_pic":null,"birthday":"2018-07-11","email":"13522566567","qq":"7837456774","weixin":"","province_id":"1","city_id":"2","county_id":"3","address":"黑龙江鸡西市恒山区柳毛乡铅矿村","graduate_from":"哈尔滨幼儿师范高等专科学校","education":"3","major":"学前教育","diploma_pic":null,"create_time":"2018-03-02 15:11:33","update_time":null,"balance":"0","status":"1","city_partner_id":"12","to_tck":"0","is_vip":"0","vip_start":"1970-01-01","vip_end":"1970-01-01","is_job":"0","vc_balance":"0","vc_total":"0","teacher_certificate":"","entry_years":"0","class_name":"000","school_name":"测试99999"}
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
         * teacher_id : 2
         * teacher_from : 0
         * is_tck : 1
         * is_pay : 0
         * name : 张婷
         * phone : 15603653205
         * headimgurl :
         * openid :
         * sex : 0
         * idcard : 230303199602016624
         * id_card_pic : null
         * birthday : 2018-07-11
         * email : 13522566567
         * qq : 7837456774
         * weixin :
         * province_id : 1
         * city_id : 2
         * county_id : 3
         * address : 黑龙江鸡西市恒山区柳毛乡铅矿村
         * graduate_from : 哈尔滨幼儿师范高等专科学校
         * education : 3
         * major : 学前教育
         * diploma_pic : null
         * create_time : 2018-03-02 15:11:33
         * update_time : null
         * balance : 0
         * status : 1
         * city_partner_id : 12
         * to_tck : 0
         * is_vip : 0
         * vip_start : 1970-01-01
         * vip_end : 1970-01-01
         * is_job : 0
         * vc_balance : 0
         * vc_total : 0
         * teacher_certificate :
         * entry_years : 0
         * class_name : 000
         * school_name : 测试99999
         */

        private String teacher_id;
        private String teacher_from;
        private String is_tck;
        private String is_pay;
        private String name;
        private String phone;
        private String headimgurl;
        private String openid;
        private String sex;
        private String idcard;
        private Object id_card_pic;
        private String birthday;
        private String email;
        private String qq;
        private String weixin;
        private String province_id;
        private String city_id;
        private String county_id;
        private String address;
        private String graduate_from;
        private String education;
        private String major;
        private Object diploma_pic;
        private String create_time;
        private Object update_time;
        private String balance;
        private String status;
        private String city_partner_id;
        private String to_tck;
        private String is_vip;
        private String vip_start;
        private String vip_end;
        private String is_job;
        private String vc_balance;
        private String vc_total;
        private String teacher_certificate;
        private String entry_years;
        private String class_name;
        private String school_name;

        public String getTeacher_id() {
            return teacher_id;
        }

        public void setTeacher_id(String teacher_id) {
            this.teacher_id = teacher_id;
        }

        public String getTeacher_from() {
            return teacher_from;
        }

        public void setTeacher_from(String teacher_from) {
            this.teacher_from = teacher_from;
        }

        public String getIs_tck() {
            return is_tck;
        }

        public void setIs_tck(String is_tck) {
            this.is_tck = is_tck;
        }

        public String getIs_pay() {
            return is_pay;
        }

        public void setIs_pay(String is_pay) {
            this.is_pay = is_pay;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public Object getId_card_pic() {
            return id_card_pic;
        }

        public void setId_card_pic(Object id_card_pic) {
            this.id_card_pic = id_card_pic;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGraduate_from() {
            return graduate_from;
        }

        public void setGraduate_from(String graduate_from) {
            this.graduate_from = graduate_from;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public Object getDiploma_pic() {
            return diploma_pic;
        }

        public void setDiploma_pic(Object diploma_pic) {
            this.diploma_pic = diploma_pic;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public Object getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Object update_time) {
            this.update_time = update_time;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCity_partner_id() {
            return city_partner_id;
        }

        public void setCity_partner_id(String city_partner_id) {
            this.city_partner_id = city_partner_id;
        }

        public String getTo_tck() {
            return to_tck;
        }

        public void setTo_tck(String to_tck) {
            this.to_tck = to_tck;
        }

        public String getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(String is_vip) {
            this.is_vip = is_vip;
        }

        public String getVip_start() {
            return vip_start;
        }

        public void setVip_start(String vip_start) {
            this.vip_start = vip_start;
        }

        public String getVip_end() {
            return vip_end;
        }

        public void setVip_end(String vip_end) {
            this.vip_end = vip_end;
        }

        public String getIs_job() {
            return is_job;
        }

        public void setIs_job(String is_job) {
            this.is_job = is_job;
        }

        public String getVc_balance() {
            return vc_balance;
        }

        public void setVc_balance(String vc_balance) {
            this.vc_balance = vc_balance;
        }

        public String getVc_total() {
            return vc_total;
        }

        public void setVc_total(String vc_total) {
            this.vc_total = vc_total;
        }

        public String getTeacher_certificate() {
            return teacher_certificate;
        }

        public void setTeacher_certificate(String teacher_certificate) {
            this.teacher_certificate = teacher_certificate;
        }

        public String getEntry_years() {
            return entry_years;
        }

        public void setEntry_years(String entry_years) {
            this.entry_years = entry_years;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }
    }
}
