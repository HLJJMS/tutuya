package com.tutuya.tck.bean.base;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/25
 */
public class TalkBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"page":"1","base_url":"http://test.res.tutuyaedu.com","msg_list":[{"msg_id":"629","type":"1","content":"Ash. As sa www wow I owe will salkfsd ash rip do dash dasashd Ed iowdoqwad as we worship we lashdshdq q owe. As woke one wqd we\u2019d Ed ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"628","type":"1","content":"As sa.  Eweee. Ewe t. ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"626","type":"1","content":"David\u2019s. As. ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"625","type":"2","content":"/weixin/tck/gift/7.jpg","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"624","type":"1","content":"Sa as sa asd. ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"623","type":"1","content":"Asd Assad as ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"622","type":"1","content":"Asxsaxas as","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"621","type":"1","content":"Where ray ty y wet Rey e ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"620","type":"1","content":"Asd dada\u2019s sa sa ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"619","type":"2","content":"/weixin/tck/gift/1.jpg","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"}]}
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
         * msg_list : [{"msg_id":"629","type":"1","content":"Ash. As sa www wow I owe will salkfsd ash rip do dash dasashd Ed iowdoqwad as we worship we lashdshdq q owe. As woke one wqd we\u2019d Ed ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"628","type":"1","content":"As sa.  Eweee. Ewe t. ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"626","type":"1","content":"David\u2019s. As. ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"625","type":"2","content":"/weixin/tck/gift/7.jpg","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"624","type":"1","content":"Sa as sa asd. ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"623","type":"1","content":"Asd Assad as ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"622","type":"1","content":"Asxsaxas as","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"621","type":"1","content":"Where ray ty y wet Rey e ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"620","type":"1","content":"Asd dada\u2019s sa sa ","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"},{"msg_id":"619","type":"2","content":"/weixin/tck/gift/1.jpg","reply":"","teacher_photo":"http://app.tutuyaedu.com/image/noimage.jpeg","user_photo":"http://test.res.tutuyaedu.com/app/head/201904/155589608021.png"}]
         */

        private String page;
        private String base_url;
        private List<MsgListBean> msg_list;

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

        public List<MsgListBean> getMsg_list() {
            return msg_list;
        }

        public void setMsg_list(List<MsgListBean> msg_list) {
            this.msg_list = msg_list;
        }

        public static class MsgListBean {
            public MsgListBean(String type, String content) {
                this.type = type;
                this.content = content;
            }

            /**
             * msg_id : 629
             * type : 1
             * content : Ash. As sa www wow I owe will salkfsd ash rip do dash dasashd Ed iowdoqwad as we worship we lashdshdq q owe. As woke one wqd we’d Ed
             * reply :
             * teacher_photo : http://app.tutuyaedu.com/image/noimage.jpeg
             * user_photo : http://test.res.tutuyaedu.com/app/head/201904/155589608021.png
             */

            private String msg_id;
            private String type;
            private String content;
            private String reply;
            private String teacher_photo;
            private String user_photo;

            public String getMsg_id() {
                return msg_id;
            }

            public void setMsg_id(String msg_id) {
                this.msg_id = msg_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getReply() {
                return reply;
            }

            public void setReply(String reply) {
                this.reply = reply;
            }

            public String getTeacher_photo() {
                return teacher_photo;
            }

            public void setTeacher_photo(String teacher_photo) {
                this.teacher_photo = teacher_photo;
            }

            public String getUser_photo() {
                return user_photo;
            }

            public void setUser_photo(String user_photo) {
                this.user_photo = user_photo;
            }
        }
    }
}
