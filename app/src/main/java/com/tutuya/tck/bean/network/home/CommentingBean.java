package com.tutuya.tck.bean.network.home;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/25
 */
public class CommentingBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"comment_high":[{"id":"5","cover_img_min":"/images/201903/72012.jpg","cover_img":"http://test.res.tutuyaedu.com/images/201903/72012.jpg"}],"comment_low":[{"id":"6","cover_img_min":"/images/201903/98598.jpg","cover_img":"http://test.res.tutuyaedu.com/images/201903/98598.jpg"}]}
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
        private List<CommentHighBean> comment_high;
        private List<CommentLowBean> comment_low;

        public List<CommentHighBean> getComment_high() {
            return comment_high;
        }

        public void setComment_high(List<CommentHighBean> comment_high) {
            this.comment_high = comment_high;
        }

        public List<CommentLowBean> getComment_low() {
            return comment_low;
        }

        public void setComment_low(List<CommentLowBean> comment_low) {
            this.comment_low = comment_low;
        }

        public static class CommentHighBean {
            /**
             * id : 5
             * cover_img_min : /images/201903/72012.jpg
             * cover_img : http://test.res.tutuyaedu.com/images/201903/72012.jpg
             */

            private String id;
            private String cover_img_min;
            private String cover_img;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCover_img_min() {
                return cover_img_min;
            }

            public void setCover_img_min(String cover_img_min) {
                this.cover_img_min = cover_img_min;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }
        }

        public static class CommentLowBean {
            /**
             * id : 6
             * cover_img_min : /images/201903/98598.jpg
             * cover_img : http://test.res.tutuyaedu.com/images/201903/98598.jpg
             */

            private String id;
            private String cover_img_min;
            private String cover_img;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCover_img_min() {
                return cover_img_min;
            }

            public void setCover_img_min(String cover_img_min) {
                this.cover_img_min = cover_img_min;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }
        }
    }
}
