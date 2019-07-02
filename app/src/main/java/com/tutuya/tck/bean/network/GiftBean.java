package com.tutuya.tck.bean.network;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/24
 */
public class GiftBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"base_url":"http://test.res.tutuyaedu.com","gift_list":[{"id":"1","gift_category":"1","gift_name":"巧克力","gift_photo":"/weixin/tck/gift/1.jpg","gift_thumb_photo":"/weixin/tck/gift/1_s.jpg","vc_price":"50","gift_status":"1","create_tm":"2018-08-17 15:19:45","update_tm":"2018-08-17 17:51:05"},{"id":"2","gift_category":"1","gift_name":"花束","gift_photo":"/weixin/tck/gift/2.jpg","gift_thumb_photo":"/weixin/tck/gift/2_s.jpg","vc_price":"100","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"18","gift_category":"1","gift_name":"鼓掌","gift_photo":"/weixin/tck/gift/18.jpg","gift_thumb_photo":"/weixin/tck/gift/18_s.jpg","vc_price":"100","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"3","gift_category":"1","gift_name":"鲜花礼盒","gift_photo":"/weixin/tck/gift/3.jpg","gift_thumb_photo":"/weixin/tck/gift/3_s.jpg","vc_price":"150","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"6","gift_category":"1","gift_name":"口红","gift_photo":"/weixin/tck/gift/6.jpg","gift_thumb_photo":"/weixin/tck/gift/6_s.jpg","vc_price":"180","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"4","gift_category":"1","gift_name":"玫瑰","gift_photo":"/weixin/tck/gift/4.jpg","gift_thumb_photo":"/weixin/tck/gift/4_s.jpg","vc_price":"200","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"24","gift_category":"1","gift_name":"冰激凌","gift_photo":"/weixin/tck/gift/24.jpg","gift_thumb_photo":"/weixin/tck/gift/24_s.jpg","vc_price":"400","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"22","gift_category":"1","gift_name":"咖啡","gift_photo":"/weixin/tck/gift/22.jpg","gift_thumb_photo":"/weixin/tck/gift/22_s.jpg","vc_price":"500","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"12","gift_category":"2","gift_name":"魔法帽","gift_photo":"/weixin/tck/gift/12.jpg","gift_thumb_photo":"/weixin/tck/gift/12_s.jpg","vc_price":"500","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"20","gift_category":"1","gift_name":"谢谢","gift_photo":"/weixin/tck/gift/20.jpg","gift_thumb_photo":"/weixin/tck/gift/20_s.jpg","vc_price":"500","gift_status":"1","create_tm":"2018-08-17 15:19:45","update_tm":"2018-08-17 17:51:05"},{"id":"19","gift_category":"1","gift_name":"谢谢老师","gift_photo":"/weixin/tck/gift/19.jpg","gift_thumb_photo":"/weixin/tck/gift/19_s.jpg","vc_price":"600","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"16","gift_category":"1","gift_name":"巧克力礼盒","gift_photo":"/weixin/tck/gift/16.jpg","gift_thumb_photo":"/weixin/tck/gift/16_s.jpg","vc_price":"680","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"23","gift_category":"2","gift_name":"项链","gift_photo":"/weixin/tck/gift/23.jpg","gift_thumb_photo":"/weixin/tck/gift/23_s.jpg","vc_price":"1000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"21","gift_category":"1","gift_name":"高跟鞋","gift_photo":"/weixin/tck/gift/21.jpg","gift_thumb_photo":"/weixin/tck/gift/21_s.jpg","vc_price":"1000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"11","gift_category":"3","gift_name":"悍马","gift_photo":"/weixin/tck/gift/11.jpg","gift_thumb_photo":"/weixin/tck/gift/11_s.jpg","vc_price":"1000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"14","gift_category":"2","gift_name":"包包","gift_photo":"/weixin/tck/gift/14.jpg","gift_thumb_photo":"/weixin/tck/gift/14_s.jpg","vc_price":"1500","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"15","gift_category":"3","gift_name":"游艇","gift_photo":"/weixin/tck/gift/15.jpg","gift_thumb_photo":"/weixin/tck/gift/15_s.jpg","vc_price":"3000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"25","gift_category":"1","gift_name":"水晶鞋","gift_photo":"/weixin/tck/gift/25.jpg","gift_thumb_photo":"/weixin/tck/gift/25_s.jpg","vc_price":"3800","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"13","gift_category":"4","gift_name":"直升机","gift_photo":"/weixin/tck/gift/13.jpg","gift_thumb_photo":"/weixin/tck/gift/13_s.jpg","vc_price":"4000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"10","gift_category":"3","gift_name":"雪佛兰","gift_photo":"/weixin/tck/gift/10.jpg","gift_thumb_photo":"/weixin/tck/gift/10_s.jpg","vc_price":"9500","gift_status":"1","create_tm":"2018-08-17 15:19:45","update_tm":"2018-09-25 22:42:49"},{"id":"7","gift_category":"3","gift_name":"宝马跑车","gift_photo":"/weixin/tck/gift/7.jpg","gift_thumb_photo":"/weixin/tck/gift/7_s.jpg","vc_price":"10000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"5","gift_category":"3","gift_name":"玛莎拉蒂","gift_photo":"/weixin/tck/gift/5.jpg","gift_thumb_photo":"/weixin/tck/gift/5_s.jpg","vc_price":"28000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"17","gift_category":"3","gift_name":"奔驰","gift_photo":"/weixin/tck/gift/17.jpg","gift_thumb_photo":"/weixin/tck/gift/17_s.jpg","vc_price":"50000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"9","gift_category":"4","gift_name":"飞机","gift_photo":"/weixin/tck/gift/9.jpg","gift_thumb_photo":"/weixin/tck/gift/9_s.jpg","vc_price":"60000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"8","gift_category":"4","gift_name":"别墅","gift_photo":"/weixin/tck/gift/8.jpg","gift_thumb_photo":"/weixin/tck/gift/8_s.jpg","vc_price":"88000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"}]}
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
         * base_url : http://test.res.tutuyaedu.com
         * gift_list : [{"id":"1","gift_category":"1","gift_name":"巧克力","gift_photo":"/weixin/tck/gift/1.jpg","gift_thumb_photo":"/weixin/tck/gift/1_s.jpg","vc_price":"50","gift_status":"1","create_tm":"2018-08-17 15:19:45","update_tm":"2018-08-17 17:51:05"},{"id":"2","gift_category":"1","gift_name":"花束","gift_photo":"/weixin/tck/gift/2.jpg","gift_thumb_photo":"/weixin/tck/gift/2_s.jpg","vc_price":"100","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"18","gift_category":"1","gift_name":"鼓掌","gift_photo":"/weixin/tck/gift/18.jpg","gift_thumb_photo":"/weixin/tck/gift/18_s.jpg","vc_price":"100","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"3","gift_category":"1","gift_name":"鲜花礼盒","gift_photo":"/weixin/tck/gift/3.jpg","gift_thumb_photo":"/weixin/tck/gift/3_s.jpg","vc_price":"150","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"6","gift_category":"1","gift_name":"口红","gift_photo":"/weixin/tck/gift/6.jpg","gift_thumb_photo":"/weixin/tck/gift/6_s.jpg","vc_price":"180","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"4","gift_category":"1","gift_name":"玫瑰","gift_photo":"/weixin/tck/gift/4.jpg","gift_thumb_photo":"/weixin/tck/gift/4_s.jpg","vc_price":"200","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"24","gift_category":"1","gift_name":"冰激凌","gift_photo":"/weixin/tck/gift/24.jpg","gift_thumb_photo":"/weixin/tck/gift/24_s.jpg","vc_price":"400","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"22","gift_category":"1","gift_name":"咖啡","gift_photo":"/weixin/tck/gift/22.jpg","gift_thumb_photo":"/weixin/tck/gift/22_s.jpg","vc_price":"500","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"12","gift_category":"2","gift_name":"魔法帽","gift_photo":"/weixin/tck/gift/12.jpg","gift_thumb_photo":"/weixin/tck/gift/12_s.jpg","vc_price":"500","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"20","gift_category":"1","gift_name":"谢谢","gift_photo":"/weixin/tck/gift/20.jpg","gift_thumb_photo":"/weixin/tck/gift/20_s.jpg","vc_price":"500","gift_status":"1","create_tm":"2018-08-17 15:19:45","update_tm":"2018-08-17 17:51:05"},{"id":"19","gift_category":"1","gift_name":"谢谢老师","gift_photo":"/weixin/tck/gift/19.jpg","gift_thumb_photo":"/weixin/tck/gift/19_s.jpg","vc_price":"600","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"16","gift_category":"1","gift_name":"巧克力礼盒","gift_photo":"/weixin/tck/gift/16.jpg","gift_thumb_photo":"/weixin/tck/gift/16_s.jpg","vc_price":"680","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"23","gift_category":"2","gift_name":"项链","gift_photo":"/weixin/tck/gift/23.jpg","gift_thumb_photo":"/weixin/tck/gift/23_s.jpg","vc_price":"1000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"21","gift_category":"1","gift_name":"高跟鞋","gift_photo":"/weixin/tck/gift/21.jpg","gift_thumb_photo":"/weixin/tck/gift/21_s.jpg","vc_price":"1000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"11","gift_category":"3","gift_name":"悍马","gift_photo":"/weixin/tck/gift/11.jpg","gift_thumb_photo":"/weixin/tck/gift/11_s.jpg","vc_price":"1000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"14","gift_category":"2","gift_name":"包包","gift_photo":"/weixin/tck/gift/14.jpg","gift_thumb_photo":"/weixin/tck/gift/14_s.jpg","vc_price":"1500","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"15","gift_category":"3","gift_name":"游艇","gift_photo":"/weixin/tck/gift/15.jpg","gift_thumb_photo":"/weixin/tck/gift/15_s.jpg","vc_price":"3000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"25","gift_category":"1","gift_name":"水晶鞋","gift_photo":"/weixin/tck/gift/25.jpg","gift_thumb_photo":"/weixin/tck/gift/25_s.jpg","vc_price":"3800","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"13","gift_category":"4","gift_name":"直升机","gift_photo":"/weixin/tck/gift/13.jpg","gift_thumb_photo":"/weixin/tck/gift/13_s.jpg","vc_price":"4000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"10","gift_category":"3","gift_name":"雪佛兰","gift_photo":"/weixin/tck/gift/10.jpg","gift_thumb_photo":"/weixin/tck/gift/10_s.jpg","vc_price":"9500","gift_status":"1","create_tm":"2018-08-17 15:19:45","update_tm":"2018-09-25 22:42:49"},{"id":"7","gift_category":"3","gift_name":"宝马跑车","gift_photo":"/weixin/tck/gift/7.jpg","gift_thumb_photo":"/weixin/tck/gift/7_s.jpg","vc_price":"10000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"5","gift_category":"3","gift_name":"玛莎拉蒂","gift_photo":"/weixin/tck/gift/5.jpg","gift_thumb_photo":"/weixin/tck/gift/5_s.jpg","vc_price":"28000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"17","gift_category":"3","gift_name":"奔驰","gift_photo":"/weixin/tck/gift/17.jpg","gift_thumb_photo":"/weixin/tck/gift/17_s.jpg","vc_price":"50000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"9","gift_category":"4","gift_name":"飞机","gift_photo":"/weixin/tck/gift/9.jpg","gift_thumb_photo":"/weixin/tck/gift/9_s.jpg","vc_price":"60000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"},{"id":"8","gift_category":"4","gift_name":"别墅","gift_photo":"/weixin/tck/gift/8.jpg","gift_thumb_photo":"/weixin/tck/gift/8_s.jpg","vc_price":"88000","gift_status":"1","create_tm":"2018-08-17 15:21:41","update_tm":"2018-08-17 17:51:05"}]
         */

        private String base_url;
        private List<GiftListBean> gift_list;

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
             * id : 1
             * gift_category : 1
             * gift_name : 巧克力
             * gift_photo : /weixin/tck/gift/1.jpg
             * gift_thumb_photo : /weixin/tck/gift/1_s.jpg
             * vc_price : 50
             * gift_status : 1
             * create_tm : 2018-08-17 15:19:45
             * update_tm : 2018-08-17 17:51:05
             */

            private String id;
            private String gift_category;
            private String gift_name;
            private String gift_photo;
            private String gift_thumb_photo;
            private String vc_price;
            private String gift_status;
            private String create_tm;
            private String update_tm;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGift_category() {
                return gift_category;
            }

            public void setGift_category(String gift_category) {
                this.gift_category = gift_category;
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

            public String getVc_price() {
                return vc_price;
            }

            public void setVc_price(String vc_price) {
                this.vc_price = vc_price;
            }

            public String getGift_status() {
                return gift_status;
            }

            public void setGift_status(String gift_status) {
                this.gift_status = gift_status;
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
        }
    }
}
