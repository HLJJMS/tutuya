package com.tutuya.tck.bean.network.classing;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/26
 */
public class FamousTeacherVideoListBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"page":"1","page_size":"10","data":[{"id":"12","cover_img":"http://test.res.tutuyaedu.comhttp://test.res.tutuyaedu.com/images/201812/21855.jpg","theme_name":"3w","lecturer":"www","play_num":"0","praise_num":"0","virtual_coin":0,"video_num":"0","category_id":"18","start_tm":"2018-12-19 00:00:00","end_tm":"2018-12-28 00:00:00","category_name":"拓展教育","is_buy":1,"is_praise":0},{"id":"28","cover_img":"http://test.res.tutuyaedu.com/images/201901/65402.jpg","theme_name":"手工培训课程","lecturer":"李涂涂","play_num":"1013","praise_num":"991","virtual_coin":"200","video_num":"3","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育","is_buy":0,"is_praise":0}]}
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
         * data : [{"id":"12","cover_img":"http://test.res.tutuyaedu.comhttp://test.res.tutuyaedu.com/images/201812/21855.jpg","theme_name":"3w","lecturer":"www","play_num":"0","praise_num":"0","virtual_coin":0,"video_num":"0","category_id":"18","start_tm":"2018-12-19 00:00:00","end_tm":"2018-12-28 00:00:00","category_name":"拓展教育","is_buy":1,"is_praise":0},{"id":"28","cover_img":"http://test.res.tutuyaedu.com/images/201901/65402.jpg","theme_name":"手工培训课程","lecturer":"李涂涂","play_num":"1013","praise_num":"991","virtual_coin":"200","video_num":"3","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育","is_buy":0,"is_praise":0}]
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
             * id : 12
             * cover_img : http://test.res.tutuyaedu.comhttp://test.res.tutuyaedu.com/images/201812/21855.jpg
             * theme_name : 3w
             * lecturer : www
             * play_num : 0
             * praise_num : 0
             * virtual_coin : 0
             * video_num : 0
             * category_id : 18
             * start_tm : 2018-12-19 00:00:00
             * end_tm : 2018-12-28 00:00:00
             * category_name : 拓展教育
             * is_buy : 1
             * is_praise : 0
             */

            private String id;
            private String cover_img;
            private String theme_name;
            private String lecturer;
            private String play_num;
            private String praise_num;
            private int virtual_coin;
            private String video_num;
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

            public int getVirtual_coin() {
                return virtual_coin;
            }

            public void setVirtual_coin(int virtual_coin) {
                this.virtual_coin = virtual_coin;
            }

            public String getVideo_num() {
                return video_num;
            }

            public void setVideo_num(String video_num) {
                this.video_num = video_num;
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
