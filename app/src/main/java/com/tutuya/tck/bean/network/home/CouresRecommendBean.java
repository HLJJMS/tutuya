package com.tutuya.tck.bean.network.home;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/25
 */
public class CouresRecommendBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"course":[{"id":"72","cover_img":"http://test.res.tutuyaedu.com/images/201904/54140.jpg","theme_name":"测试主题17","lecturer":"诺一","play_num":"333","praise_num":"333","virtual_coin":"1000","video_num":"1","category_id":"10","category_name":"健康教育-健康","is_praise":0},{"id":"2","cover_img":"http://test.res.tutuyaedu.com/files/approva/201811/154140187529.jpg","theme_name":"测试2","lecturer":"孔总","play_num":"1657","praise_num":"461","virtual_coin":"20","video_num":"13","category_id":"2","category_name":"教师视频-教师学习","is_praise":0}]}
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
        private List<CourseBean> course;

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public static class CourseBean {
            /**
             * id : 72
             * cover_img : http://test.res.tutuyaedu.com/images/201904/54140.jpg
             * theme_name : 测试主题17
             * lecturer : 诺一
             * play_num : 333
             * praise_num : 333
             * virtual_coin : 1000
             * video_num : 1
             * category_id : 10
             * category_name : 健康教育-健康
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
            private String category_id;
            private String category_name;
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

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
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
