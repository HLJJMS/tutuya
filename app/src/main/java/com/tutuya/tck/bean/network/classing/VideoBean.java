package com.tutuya.tck.bean.network.classing;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/26
 */
public class VideoBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"id":"28","theme_id":"11","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201812/17545.jpg","name":"22222","introduction":"22222","video_url":"http://test.res.tutuyaedu.com/videos/201812/82783.mp4","voice_url":"","duration":"30:40:00","try_duration":"60","lecturer":"2222","lecturer_id":"5","play_num":"2223","praise_num":"2222","virtual_coin":"111","inside_coin":null,"sort":"1","detail":"详情详情详情详情<\/p>","is_free":"1","status":"0","update_time":"2019-04-26 14:09:28","create_time":"2018-12-17 10:12:41","is_buy":0,"is_praise":0,"test":60}
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
         * id : 28
         * theme_id : 11
         * type : 0
         * cover_img : http://test.res.tutuyaedu.com/images/201812/17545.jpg
         * name : 22222
         * introduction : 22222
         * video_url : http://test.res.tutuyaedu.com/videos/201812/82783.mp4
         * voice_url :
         * duration : 30:40:00
         * try_duration : 60
         * lecturer : 2222
         * lecturer_id : 5
         * play_num : 2223
         * praise_num : 2222
         * virtual_coin : 111
         * inside_coin : null
         * sort : 1
         * detail : 详情详情详情详情</p>
         * is_free : 1
         * status : 0
         * update_time : 2019-04-26 14:09:28
         * create_time : 2018-12-17 10:12:41
         * is_buy : 0
         * is_praise : 0
         * test : 60
         */

        private String id;
        private String theme_id;
        private String type;
        private String cover_img;
        private String name;
        private String introduction;
        private String video_url;
        private String voice_url;
        private String duration;
        private String try_duration;
        private String lecturer;
        private String lecturer_id;
        private String play_num;
        private String praise_num;
        private String virtual_coin;
        private Object inside_coin;
        private String sort;
        private String detail;
        private String is_free;
        private String status;
        private String update_time;
        private String create_time;
        private int is_buy;
        private int is_praise;
        private int test;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTheme_id() {
            return theme_id;
        }

        public void setTheme_id(String theme_id) {
            this.theme_id = theme_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getVoice_url() {
            return voice_url;
        }

        public void setVoice_url(String voice_url) {
            this.voice_url = voice_url;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getTry_duration() {
            return try_duration;
        }

        public void setTry_duration(String try_duration) {
            this.try_duration = try_duration;
        }

        public String getLecturer() {
            return lecturer;
        }

        public void setLecturer(String lecturer) {
            this.lecturer = lecturer;
        }

        public String getLecturer_id() {
            return lecturer_id;
        }

        public void setLecturer_id(String lecturer_id) {
            this.lecturer_id = lecturer_id;
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

        public Object getInside_coin() {
            return inside_coin;
        }

        public void setInside_coin(Object inside_coin) {
            this.inside_coin = inside_coin;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getIs_free() {
            return is_free;
        }

        public void setIs_free(String is_free) {
            this.is_free = is_free;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
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

        public int getTest() {
            return test;
        }

        public void setTest(int test) {
            this.test = test;
        }
    }
}
