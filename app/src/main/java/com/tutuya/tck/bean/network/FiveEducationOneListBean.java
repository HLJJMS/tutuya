package com.tutuya.tck.bean.network;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/29
 */
public class FiveEducationOneListBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"page":"1","data":[{"id":"58","cover_img":"http://test.res.tutuyaedu.com/images/201903/73133.jpg","theme_name":"测试主题4","lecturer":"孟雪","play_num":"447","praise_num":"445","virtual_coin":"400","video_num":"1","category_top_id":"11","category_id":"12","start_tm":"2019-03-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"52","cover_img":"http://test.res.tutuyaedu.com/images/201903/50343.jpg","theme_name":"5月动手能力","lecturer":"刘笑彤","play_num":"1208","praise_num":"889","virtual_coin":"1000","video_num":"3","category_top_id":"11","category_id":"12","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"42","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"测试主题名称","lecturer":"测试测试","play_num":"46","praise_num":"1","virtual_coin":"100","video_num":"1","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":0,"is_praise":0},{"id":"41","cover_img":"http://test.res.tutuyaedu.com/images/201901/33414.jpg","theme_name":"测试测试主题","lecturer":"测试","play_num":"5","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":1,"is_praise":0},{"id":"24","cover_img":"http://test.res.tutuyaedu.com/images/201812/22099.jpg","theme_name":"ddd","lecturer":"ddd","play_num":"26","praise_num":"223","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-27 00:00:00","end_tm":"2018-12-28 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"23","cover_img":"http://test.res.tutuyaedu.com/images/201812/98720.jpg","theme_name":"www","lecturer":"www","play_num":"5","praise_num":"1","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-27 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"22","cover_img":"http://test.res.tutuyaedu.com/images/201812/60561.jpg","theme_name":"ceshi","lecturer":"ceshi","play_num":"25","praise_num":"22","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"3","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-29 00:00:00","category_name":"家庭教育-创造力","is_buy":1,"is_praise":0}]}
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
         * data : [{"id":"58","cover_img":"http://test.res.tutuyaedu.com/images/201903/73133.jpg","theme_name":"测试主题4","lecturer":"孟雪","play_num":"447","praise_num":"445","virtual_coin":"400","video_num":"1","category_top_id":"11","category_id":"12","start_tm":"2019-03-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"52","cover_img":"http://test.res.tutuyaedu.com/images/201903/50343.jpg","theme_name":"5月动手能力","lecturer":"刘笑彤","play_num":"1208","praise_num":"889","virtual_coin":"1000","video_num":"3","category_top_id":"11","category_id":"12","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"42","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"测试主题名称","lecturer":"测试测试","play_num":"46","praise_num":"1","virtual_coin":"100","video_num":"1","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":0,"is_praise":0},{"id":"41","cover_img":"http://test.res.tutuyaedu.com/images/201901/33414.jpg","theme_name":"测试测试主题","lecturer":"测试","play_num":"5","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":1,"is_praise":0},{"id":"24","cover_img":"http://test.res.tutuyaedu.com/images/201812/22099.jpg","theme_name":"ddd","lecturer":"ddd","play_num":"26","praise_num":"223","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-27 00:00:00","end_tm":"2018-12-28 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"23","cover_img":"http://test.res.tutuyaedu.com/images/201812/98720.jpg","theme_name":"www","lecturer":"www","play_num":"5","praise_num":"1","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-27 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"22","cover_img":"http://test.res.tutuyaedu.com/images/201812/60561.jpg","theme_name":"ceshi","lecturer":"ceshi","play_num":"25","praise_num":"22","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"3","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-29 00:00:00","category_name":"家庭教育-创造力","is_buy":1,"is_praise":0}]
         */

        private String page;
        private List<DataBean> data;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 58
             * cover_img : http://test.res.tutuyaedu.com/images/201903/73133.jpg
             * theme_name : 测试主题4
             * lecturer : 孟雪
             * play_num : 447
             * praise_num : 445
             * virtual_coin : 400
             * video_num : 1
             * category_top_id : 11
             * category_id : 12
             * start_tm : 2019-03-30 00:00:00
             * end_tm : 2020-01-08 00:00:00
             * category_name : 家庭教育-亲子
             * is_buy : 0
             * is_praise : 0
             */

            private String id;
            private String cover_img;
            private String theme_name;
            private String lecturer;
            private String play_num;
            private String praise_num;
            private String virtual_coin;
            private String video_num;
            private String category_top_id;
            private String category_id;
            private String start_tm;
            private String end_tm;
            private String category_name;
            private int is_buy;
            private int is_praise;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }

            public String getTheme_name() {
                return theme_name;
            }

            public void setTheme_name(String theme_name) {
                this.theme_name = theme_name;
            }

            public String getLecturer() {
                return lecturer;
            }

            public void setLecturer(String lecturer) {
                this.lecturer = lecturer;
            }

            public String getPlay_num() {
                return play_num;
            }

            public void setPlay_num(String play_num) {
                this.play_num = play_num;
            }

            public String getPraise_num() {
                return praise_num;
            }

            public void setPraise_num(String praise_num) {
                this.praise_num = praise_num;
            }

            public String getVirtual_coin() {
                return virtual_coin;
            }

            public void setVirtual_coin(String virtual_coin) {
                this.virtual_coin = virtual_coin;
            }

            public String getVideo_num() {
                return video_num;
            }

            public void setVideo_num(String video_num) {
                this.video_num = video_num;
            }

            public String getCategory_top_id() {
                return category_top_id;
            }

            public void setCategory_top_id(String category_top_id) {
                this.category_top_id = category_top_id;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getStart_tm() {
                return start_tm;
            }

            public void setStart_tm(String start_tm) {
                this.start_tm = start_tm;
            }

            public String getEnd_tm() {
                return end_tm;
            }

            public void setEnd_tm(String end_tm) {
                this.end_tm = end_tm;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getIs_buy() {
                return is_buy;
            }

            public void setIs_buy(int is_buy) {
                this.is_buy = is_buy;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }
        }
    }
}
