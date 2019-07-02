package com.tutuya.tck.bean.network.home;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/25
 */
public class FamousTeacherBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"lecture":[{"id":"40","name":"鲁晋","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"cover_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg","recommend_img":"/images/201903/37257.jpg","theme_id":"1","praise_num":"23146","is_praise":0},{"id":"40","name":"鲁晋","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"cover_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg","recommend_img":"/images/201903/37257.jpg","theme_id":"2","praise_num":"461","is_praise":0}]}
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
        private List<LectureBean> lecture;

        public List<LectureBean> getLecture() {
            return lecture;
        }

        public void setLecture(List<LectureBean> lecture) {
            this.lecture = lecture;
        }

        public static class LectureBean {
            /**
             * id : 40
             * name : 鲁晋
             * tags : ["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"]
             * cover_img : http://test.res.tutuyaedu.com/images/201903/37257.jpg
             * recommend_img : /images/201903/37257.jpg
             * theme_id : 1
             * praise_num : 23146
             * is_praise : 0
             */

            private String id;
            private String name;
            private String cover_img;
            private String recommend_img;
            private String theme_id;
            private String praise_num;
            private int is_praise;
            private List<String> tags;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }

            public String getRecommend_img() {
                return recommend_img;
            }

            public void setRecommend_img(String recommend_img) {
                this.recommend_img = recommend_img;
            }

            public String getTheme_id() {
                return theme_id;
            }

            public void setTheme_id(String theme_id) {
                this.theme_id = theme_id;
            }

            public String getPraise_num() {
                return praise_num;
            }

            public void setPraise_num(String praise_num) {
                this.praise_num = praise_num;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }
        }
    }
}
