package com.tutuya.tck.bean.network.classing;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/26
 */
public class ClassHomeBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"list1":[{"id":"5","cover_img_min":"/images/201903/72012.jpg","cover_img":"http://test.res.tutuyaedu.com"}],"list2":[],"list3":[{"id":"6","cover_img_min":"/images/201903/98598.jpg","cover_img":"http://test.res.tutuyaedu.com"}]}
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
        private List<List1Bean> list1;
        private List<?> list2;
        private List<List3Bean> list3;

        public List<List1Bean> getList1() {
            return list1;
        }

        public void setList1(List<List1Bean> list1) {
            this.list1 = list1;
        }

        public List<?> getList2() {
            return list2;
        }

        public void setList2(List<?> list2) {
            this.list2 = list2;
        }

        public List<List3Bean> getList3() {
            return list3;
        }

        public void setList3(List<List3Bean> list3) {
            this.list3 = list3;
        }

        public static class List1Bean {
            /**
             * id : 5
             * cover_img_min : /images/201903/72012.jpg
             * cover_img : http://test.res.tutuyaedu.com
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

        public static class List3Bean {
            /**
             * id : 6
             * cover_img_min : /images/201903/98598.jpg
             * cover_img : http://test.res.tutuyaedu.com
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
