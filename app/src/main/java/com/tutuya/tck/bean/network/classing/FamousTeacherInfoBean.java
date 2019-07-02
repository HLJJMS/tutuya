package com.tutuya.tck.bean.network.classing;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/26
 */
public class FamousTeacherInfoBean  {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"data":{"id":"40","channel_id":"1","name":"鲁晋","introduction":"春三月，此谓发陈，天地俱生，万物以荣，夜卧早起，广（多）步（走）于庭，被发缓形（意喻不受束缚），以使志生。生而勿杀，予而勿夺，赏而勿罚，此春气之应，养生之道也。逆之则伤肝，夏为寒变，奉长者少。","video_url":"/videos/201903/15946.mp4","cover_img":"http://test.res.tutuyaedu.com/images/201903/57510.jpg","life_img":["http://test.res.tutuyaedu.com/images/201903/37257.jpg","http://test.res.tutuyaedu.com/images/201903/37257.jpg"],"graduate":"","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"recommend_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg"}}
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
         * data : {"id":"40","channel_id":"1","name":"鲁晋","introduction":"春三月，此谓发陈，天地俱生，万物以荣，夜卧早起，广（多）步（走）于庭，被发缓形（意喻不受束缚），以使志生。生而勿杀，予而勿夺，赏而勿罚，此春气之应，养生之道也。逆之则伤肝，夏为寒变，奉长者少。","video_url":"/videos/201903/15946.mp4","cover_img":"http://test.res.tutuyaedu.com/images/201903/57510.jpg","life_img":["http://test.res.tutuyaedu.com/images/201903/37257.jpg","http://test.res.tutuyaedu.com/images/201903/37257.jpg"],"graduate":"","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"recommend_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 40
             * channel_id : 1
             * name : 鲁晋
             * introduction : 春三月，此谓发陈，天地俱生，万物以荣，夜卧早起，广（多）步（走）于庭，被发缓形（意喻不受束缚），以使志生。生而勿杀，予而勿夺，赏而勿罚，此春气之应，养生之道也。逆之则伤肝，夏为寒变，奉长者少。
             * video_url : /videos/201903/15946.mp4
             * cover_img : http://test.res.tutuyaedu.com/images/201903/57510.jpg
             * life_img : ["http://test.res.tutuyaedu.com/images/201903/37257.jpg","http://test.res.tutuyaedu.com/images/201903/37257.jpg"]
             * graduate :
             * tags : ["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"]
             * recommend_img : http://test.res.tutuyaedu.com/images/201903/37257.jpg
             */

            private String id;
            private String channel_id;
            private String name;
            private String introduction;
            private String video_url;
            private String cover_img;
            private String graduate;
            private String recommend_img;
            private List<String> life_img;
            private List<String> tags;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getChannel_id() {
                return channel_id;
            }

            public void setChannel_id(String channel_id) {
                this.channel_id = channel_id;
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

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }

            public String getGraduate() {
                return graduate;
            }

            public void setGraduate(String graduate) {
                this.graduate = graduate;
            }

            public String getRecommend_img() {
                return recommend_img;
            }

            public void setRecommend_img(String recommend_img) {
                this.recommend_img = recommend_img;
            }

            public List<String> getLife_img() {
                return life_img;
            }

            public void setLife_img(List<String> life_img) {
                this.life_img = life_img;
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
