package com.tutuya.tck.bean.network;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/24
 */
public class GiftListForTeacherBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"page":"1","base_url":"http://test.res.tutuyaedu.com","gift_list":[{"id":"401","user_id":"268","receiver_type":"1","receiver_id":"2","vc_amount":"100","vc_per_amount":"100","vc_gift_id":"2","vc_gift_count":"1","vc_gift_sp_count":"1","anonymous":"1","create_tm":"2019-04-24 19:31:55","update_tm":"2019-04-24 19:31:55","nickname":"梵宮月澤","gift_name":"花束","gift_photo":"/weixin/tck/gift/2.jpg","gift_thumb_photo":"/weixin/tck/gift/2_s.jpg"}]}
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
         * page : 1
         * base_url : http://test.res.tutuyaedu.com
         * gift_list : [{"id":"401","user_id":"268","receiver_type":"1","receiver_id":"2","vc_amount":"100","vc_per_amount":"100","vc_gift_id":"2","vc_gift_count":"1","vc_gift_sp_count":"1","anonymous":"1","create_tm":"2019-04-24 19:31:55","update_tm":"2019-04-24 19:31:55","nickname":"梵宮月澤","gift_name":"花束","gift_photo":"/weixin/tck/gift/2.jpg","gift_thumb_photo":"/weixin/tck/gift/2_s.jpg"}]
         */

        private String page;
        private String base_url;
        private List<GiftListBean> gift_list;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getBase_url() {
            return base_url;
        }

        public void setBase_url(String base_url) {
            this.base_url = base_url;
        }

        public List<GiftListBean> getGift_list() {
            return gift_list;
        }

        public void setGift_list(List<GiftListBean> gift_list) {
            this.gift_list = gift_list;
        }

        public static class GiftListBean {
            /**
             * id : 401
             * user_id : 268
             * receiver_type : 1
             * receiver_id : 2
             * vc_amount : 100
             * vc_per_amount : 100
             * vc_gift_id : 2
             * vc_gift_count : 1
             * vc_gift_sp_count : 1
             * anonymous : 1
             * create_tm : 2019-04-24 19:31:55
             * update_tm : 2019-04-24 19:31:55
             * nickname : 梵宮月澤
             * gift_name : 花束
             * gift_photo : /weixin/tck/gift/2.jpg
             * gift_thumb_photo : /weixin/tck/gift/2_s.jpg
             */

            private String id;
            private String user_id;
            private String receiver_type;
            private String receiver_id;
            private String vc_amount;
            private String vc_per_amount;
            private String vc_gift_id;
            private String vc_gift_count;
            private String vc_gift_sp_count;
            private String anonymous;
            private String create_tm;
            private String update_tm;
            private String nickname;
            private String gift_name;
            private String gift_photo;
            private String gift_thumb_photo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getReceiver_type() {
                return receiver_type;
            }

            public void setReceiver_type(String receiver_type) {
                this.receiver_type = receiver_type;
            }

            public String getReceiver_id() {
                return receiver_id;
            }

            public void setReceiver_id(String receiver_id) {
                this.receiver_id = receiver_id;
            }

            public String getVc_amount() {
                return vc_amount;
            }

            public void setVc_amount(String vc_amount) {
                this.vc_amount = vc_amount;
            }

            public String getVc_per_amount() {
                return vc_per_amount;
            }

            public void setVc_per_amount(String vc_per_amount) {
                this.vc_per_amount = vc_per_amount;
            }

            public String getVc_gift_id() {
                return vc_gift_id;
            }

            public void setVc_gift_id(String vc_gift_id) {
                this.vc_gift_id = vc_gift_id;
            }

            public String getVc_gift_count() {
                return vc_gift_count;
            }

            public void setVc_gift_count(String vc_gift_count) {
                this.vc_gift_count = vc_gift_count;
            }

            public String getVc_gift_sp_count() {
                return vc_gift_sp_count;
            }

            public void setVc_gift_sp_count(String vc_gift_sp_count) {
                this.vc_gift_sp_count = vc_gift_sp_count;
            }

            public String getAnonymous() {
                return anonymous;
            }

            public void setAnonymous(String anonymous) {
                this.anonymous = anonymous;
            }

            public String getCreate_tm() {
                return create_tm;
            }

            public void setCreate_tm(String create_tm) {
                this.create_tm = create_tm;
            }

            public String getUpdate_tm() {
                return update_tm;
            }

            public void setUpdate_tm(String update_tm) {
                this.update_tm = update_tm;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getGift_name() {
                return gift_name;
            }

            public void setGift_name(String gift_name) {
                this.gift_name = gift_name;
            }

            public String getGift_photo() {
                return gift_photo;
            }

            public void setGift_photo(String gift_photo) {
                this.gift_photo = gift_photo;
            }

            public String getGift_thumb_photo() {
                return gift_thumb_photo;
            }

            public void setGift_thumb_photo(String gift_thumb_photo) {
                this.gift_thumb_photo = gift_thumb_photo;
            }
        }
    }
}
