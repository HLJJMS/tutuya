package com.tutuya.tck.bean.network.classing;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/26
 */
public class FamousTeacherVideoListPlayBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"theme_info":{"id":"28","category_top_id":"13","category_id":"28","type":"0","theme_name":"手工培训课程","cover_img":"http://test.res.tutuyaedu.com/images/201901/65402.jpg","introduction":"课程名称：3招写出高分作文 课时费用：99元/12课时 课时设置：40分*12 更新频率：周三/五更新一次","lecturer":"李涂涂","lecturer_id":"40","play_num":"1013","praise_num":"991","video_num":"3","virtual_coin":"200","inside_coin":"0","is_recommend":"0","sort":"1","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","status":"0","create_tm":"2019-01-10 11:45:09","update_tm":"2019-03-23 13:57:35","category_name":"养成教育-能力","parent_id":"13","is_praise":0,"is_buy":0},"video_list":[{"id":"82","theme_id":"28","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201901/72180.jpg","name":"手工培训01","introduction":"手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。","video_url":"http://test.res.tutuyaedu.com/videos/201901/72178.mp4","voice_url":"","duration":"3:13","try_duration":"60","lecturer":"李涂涂","lecturer_id":"17","play_num":"669","praise_num":"666","virtual_coin":"100","inside_coin":null,"sort":"1","detail":" <\/p>  手工指非机器设备批量<\/a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率<\/a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线<\/a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。<\/p>","is_free":"1","is_praise":0,"test":60},{"id":"83","theme_id":"28","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201901/56847.jpg","name":"手工培训02","introduction":"手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。","video_url":"http://test.res.tutuyaedu.com/videos/201901/21629.mp4","voice_url":"","duration":"3:13","try_duration":"60","lecturer":"李涂涂","lecturer_id":"18","play_num":"662","praise_num":"661","virtual_coin":"100","inside_coin":null,"sort":"1","detail":"手工指非机器设备批量<\/a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率<\/a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线<\/a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。<\/p>","is_free":"0","is_praise":0,"test":60},{"id":"84","theme_id":"28","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201901/80405.jpg","name":"手工培训03","introduction":"手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。","video_url":"http://test.res.tutuyaedu.com/videos/201901/64802.mp4","voice_url":"","duration":"3:12","try_duration":"60","lecturer":"李涂涂","lecturer_id":"19","play_num":"667","praise_num":"667","virtual_coin":"100","inside_coin":null,"sort":"1","detail":"手工指非机器设备批量<\/a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率<\/a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线<\/a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。<\/p>","is_free":"1","is_praise":0,"test":60}]}
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
         * theme_info : {"id":"28","category_top_id":"13","category_id":"28","type":"0","theme_name":"手工培训课程","cover_img":"http://test.res.tutuyaedu.com/images/201901/65402.jpg","introduction":"课程名称：3招写出高分作文 课时费用：99元/12课时 课时设置：40分*12 更新频率：周三/五更新一次","lecturer":"李涂涂","lecturer_id":"40","play_num":"1013","praise_num":"991","video_num":"3","virtual_coin":"200","inside_coin":"0","is_recommend":"0","sort":"1","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","status":"0","create_tm":"2019-01-10 11:45:09","update_tm":"2019-03-23 13:57:35","category_name":"养成教育-能力","parent_id":"13","is_praise":0,"is_buy":0}
         * video_list : [{"id":"82","theme_id":"28","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201901/72180.jpg","name":"手工培训01","introduction":"手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。","video_url":"http://test.res.tutuyaedu.com/videos/201901/72178.mp4","voice_url":"","duration":"3:13","try_duration":"60","lecturer":"李涂涂","lecturer_id":"17","play_num":"669","praise_num":"666","virtual_coin":"100","inside_coin":null,"sort":"1","detail":" <\/p>  手工指非机器设备批量<\/a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率<\/a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线<\/a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。<\/p>","is_free":"1","is_praise":0,"test":60},{"id":"83","theme_id":"28","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201901/56847.jpg","name":"手工培训02","introduction":"手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。","video_url":"http://test.res.tutuyaedu.com/videos/201901/21629.mp4","voice_url":"","duration":"3:13","try_duration":"60","lecturer":"李涂涂","lecturer_id":"18","play_num":"662","praise_num":"661","virtual_coin":"100","inside_coin":null,"sort":"1","detail":"手工指非机器设备批量<\/a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率<\/a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线<\/a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。<\/p>","is_free":"0","is_praise":0,"test":60},{"id":"84","theme_id":"28","type":"0","cover_img":"http://test.res.tutuyaedu.com/images/201901/80405.jpg","name":"手工培训03","introduction":"手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。","video_url":"http://test.res.tutuyaedu.com/videos/201901/64802.mp4","voice_url":"","duration":"3:12","try_duration":"60","lecturer":"李涂涂","lecturer_id":"19","play_num":"667","praise_num":"667","virtual_coin":"100","inside_coin":null,"sort":"1","detail":"手工指非机器设备批量<\/a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率<\/a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线<\/a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。<\/p>","is_free":"1","is_praise":0,"test":60}]
         */

        private ThemeInfoBean theme_info;
        private List<VideoListBean> video_list;

        public ThemeInfoBean getTheme_info() {
            return theme_info;
        }

        public void setTheme_info(ThemeInfoBean theme_info) {
            this.theme_info = theme_info;
        }

        public List<VideoListBean> getVideo_list() {
            return video_list;
        }

        public void setVideo_list(List<VideoListBean> video_list) {
            this.video_list = video_list;
        }

        public static class ThemeInfoBean {
            /**
             * id : 28
             * category_top_id : 13
             * category_id : 28
             * type : 0
             * theme_name : 手工培训课程
             * cover_img : http://test.res.tutuyaedu.com/images/201901/65402.jpg
             * introduction : 课程名称：3招写出高分作文 课时费用：99元/12课时 课时设置：40分*12 更新频率：周三/五更新一次
             * lecturer : 李涂涂
             * lecturer_id : 40
             * play_num : 1013
             * praise_num : 991
             * video_num : 3
             * virtual_coin : 200
             * inside_coin : 0
             * is_recommend : 0
             * sort : 1
             * start_tm : 2019-01-11 00:00:00
             * end_tm : 2020-01-08 00:00:00
             * status : 0
             * create_tm : 2019-01-10 11:45:09
             * update_tm : 2019-03-23 13:57:35
             * category_name : 养成教育-能力
             * parent_id : 13
             * is_praise : 0
             * is_buy : 0
             */

            private String id;
            private String category_top_id;
            private String category_id;
            private String type;
            private String theme_name;
            private String cover_img;
            private String introduction;
            private String lecturer;
            private String lecturer_id;
            private String play_num;
            private String praise_num;
            private String video_num;
            private String virtual_coin;
            private String inside_coin;
            private String is_recommend;
            private String sort;
            private String start_tm;
            private String end_tm;
            private String status;
            private String create_tm;
            private String update_tm;
            private String category_name;
            private String parent_id;
            private int is_praise;
            private int is_buy;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTheme_name() {
                return theme_name;
            }

            public void setTheme_name(String theme_name) {
                this.theme_name = theme_name;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
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

            public String getVideo_num() {
                return video_num;
            }

            public void setVideo_num(String video_num) {
                this.video_num = video_num;
            }

            public String getVirtual_coin() {
                return virtual_coin;
            }

            public void setVirtual_coin(String virtual_coin) {
                this.virtual_coin = virtual_coin;
            }

            public String getInside_coin() {
                return inside_coin;
            }

            public void setInside_coin(String inside_coin) {
                this.inside_coin = inside_coin;
            }

            public String getIs_recommend() {
                return is_recommend;
            }

            public void setIs_recommend(String is_recommend) {
                this.is_recommend = is_recommend;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }

            public int getIs_buy() {
                return is_buy;
            }

            public void setIs_buy(int is_buy) {
                this.is_buy = is_buy;
            }
        }

        public static class VideoListBean {
            /**
             * id : 82
             * theme_id : 28
             * type : 0
             * cover_img : http://test.res.tutuyaedu.com/images/201901/72180.jpg
             * name : 手工培训01
             * introduction : 手工指非机器设备批量生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线生产出的毫无差别和特色的产品，手工制品又恢复了活力。
             * video_url : http://test.res.tutuyaedu.com/videos/201901/72178.mp4
             * voice_url :
             * duration : 3:13
             * try_duration : 60
             * lecturer : 李涂涂
             * lecturer_id : 17
             * play_num : 669
             * praise_num : 666
             * virtual_coin : 100
             * inside_coin : null
             * sort : 1
             * detail :  </p>  手工指非机器设备批量</a>生产而是由人工制作生产。在工业化刚刚兴起时，手工一词一度成为生产率</a>低下、质量参差不齐的代名词。然而，在当代工业生产高度发达的年代，人们逐渐厌倦了由工厂流水线</a>生产出的毫无差别和特色的产品，手工制品又恢复了活力。</p>
             * is_free : 1
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
}
