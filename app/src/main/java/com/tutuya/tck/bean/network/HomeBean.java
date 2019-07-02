package com.tutuya.tck.bean.network;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：首页实体类
 * @date 创建时间：2019/4/19
 */
public class HomeBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"cate":[{"id":11,"img_url":"http://app.tutuyaedu.com/image/nav_1@3.png"},{"id":15,"img_url":"http://app.tutuyaedu.com/image/nav_2@3.png"},{"id":9,"img_url":"http://app.tutuyaedu.com/image/nav_3@3.png"},{"id":13,"img_url":"http://app.tutuyaedu.com/image/nav_4@3.png"},{"id":0,"img_url":"http://app.tutuyaedu.com/image/nav_4@3.png"}],"lecture":[{"id":"40","name":"鲁晋","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"cover_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg","recommend_img":"/images/201903/37257.jpg","theme_id":"1","praise_num":"23146","is_praise":0},{"id":"40","name":"鲁晋","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"cover_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg","recommend_img":"/images/201903/37257.jpg","theme_id":"2","praise_num":"461","is_praise":0}],"course":[{"id":"72","cover_img":"http://test.res.tutuyaedu.com/images/201904/54140.jpg","theme_name":"测试主题17","lecturer":"诺一","play_num":"333","praise_num":"333","virtual_coin":"1000","video_num":"1","category_id":"10","category_name":"健康教育-健康","is_praise":0},{"id":"2","cover_img":"http://test.res.tutuyaedu.com/files/approva/201811/154140187529.jpg","theme_name":"测试2","lecturer":"孔总","play_num":"1657","praise_num":"461","virtual_coin":"20","video_num":"13","category_id":"2","category_name":"教师视频-教师学习","is_praise":0}],"comment_high":[{"id":"5","cover_img_min":"/images/201903/72012.jpg","cover_img":"http://test.res.tutuyaedu.com/images/201903/72012.jpg"}],"comment_low":[{"id":"6","cover_img_min":"/images/201903/98598.jpg","cover_img":"http://test.res.tutuyaedu.com/images/201903/98598.jpg"}],"shop":[{"id":"1","goods_no":"bm0000001","goods_name":"小米8","goods_cover":"http://test.res.tutuyaedu.com/images/201812/19479.jpg","ec_price":18,"sale_count":"10000"}],"shop_cart_count":0}
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

    public static class DataBean implements Parcelable  {
        /**
         * cate : [{"id":11,"img_url":"http://app.tutuyaedu.com/image/nav_1@3.png"},{"id":15,"img_url":"http://app.tutuyaedu.com/image/nav_2@3.png"},{"id":9,"img_url":"http://app.tutuyaedu.com/image/nav_3@3.png"},{"id":13,"img_url":"http://app.tutuyaedu.com/image/nav_4@3.png"},{"id":0,"img_url":"http://app.tutuyaedu.com/image/nav_4@3.png"}]
         * lecture : [{"id":"40","name":"鲁晋","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"cover_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg","recommend_img":"/images/201903/37257.jpg","theme_id":"1","praise_num":"23146","is_praise":0},{"id":"40","name":"鲁晋","tags":["华一盛世董事长","国家高级营养师","培训师，中国好声音评委"],"cover_img":"http://test.res.tutuyaedu.com/images/201903/37257.jpg","recommend_img":"/images/201903/37257.jpg","theme_id":"2","praise_num":"461","is_praise":0}]
         * course : [{"id":"72","cover_img":"http://test.res.tutuyaedu.com/images/201904/54140.jpg","theme_name":"测试主题17","lecturer":"诺一","play_num":"333","praise_num":"333","virtual_coin":"1000","video_num":"1","category_id":"10","category_name":"健康教育-健康","is_praise":0},{"id":"2","cover_img":"http://test.res.tutuyaedu.com/files/approva/201811/154140187529.jpg","theme_name":"测试2","lecturer":"孔总","play_num":"1657","praise_num":"461","virtual_coin":"20","video_num":"13","category_id":"2","category_name":"教师视频-教师学习","is_praise":0}]
         * comment_high : [{"id":"5","cover_img_min":"/images/201903/72012.jpg","cover_img":"http://test.res.tutuyaedu.com/images/201903/72012.jpg"}]
         * comment_low : [{"id":"6","cover_img_min":"/images/201903/98598.jpg","cover_img":"http://test.res.tutuyaedu.com/images/201903/98598.jpg"}]
         * shop : [{"id":"1","goods_no":"bm0000001","goods_name":"小米8","goods_cover":"http://test.res.tutuyaedu.com/images/201812/19479.jpg","ec_price":18,"sale_count":"10000"}]
         * shop_cart_count : 0
         */

        private int shop_cart_count;
        private List<CateBean> cate;
        private List<LectureBean> lecture;
        private List<CourseBean> course;
        private List<CommentHighBean> comment_high;
        private List<CommentLowBean> comment_low;
        private List<ShopBean> shop;

        protected DataBean(Parcel in) {
            shop_cart_count = in.readInt();
            cate = in.createTypedArrayList(CateBean.CREATOR);
            lecture = in.createTypedArrayList(LectureBean.CREATOR);
            course = in.createTypedArrayList(CourseBean.CREATOR);
            comment_high = in.createTypedArrayList(CommentHighBean.CREATOR);
            comment_low = in.createTypedArrayList(CommentLowBean.CREATOR);
            shop = in.createTypedArrayList(ShopBean.CREATOR);
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public int getShop_cart_count() {
            return shop_cart_count;
        }

        public void setShop_cart_count(int shop_cart_count) {
            this.shop_cart_count = shop_cart_count;
        }

        public List<CateBean> getCate() {
            return cate;
        }

        public void setCate(List<CateBean> cate) {
            this.cate = cate;
        }

        public List<LectureBean> getLecture() {
            return lecture;
        }

        public void setLecture(List<LectureBean> lecture) {
            this.lecture = lecture;
        }

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

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

        public List<ShopBean> getShop() {
            return shop;
        }

        public void setShop(List<ShopBean> shop) {
            this.shop = shop;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(shop_cart_count);
            dest.writeTypedList(cate);
            dest.writeTypedList(lecture);
            dest.writeTypedList(course);
            dest.writeTypedList(comment_high);
            dest.writeTypedList(comment_low);
            dest.writeTypedList(shop);
        }

        public static class CateBean implements Parcelable {
            /**
             * id : 11
             * img_url : http://app.tutuyaedu.com/image/nav_1@3.png
             */

            private int id;
            private String img_url;

            protected CateBean(Parcel in) {
                id = in.readInt();
                img_url = in.readString();
            }

            public static final Creator<CateBean> CREATOR = new Creator<CateBean>() {
                @Override
                public CateBean createFromParcel(Parcel in) {
                    return new CateBean(in);
                }

                @Override
                public CateBean[] newArray(int size) {
                    return new CateBean[size];
                }
            };

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(id);
                dest.writeString(img_url);
            }
        }

        public static class LectureBean implements Parcelable {
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

            protected LectureBean(Parcel in) {
                id = in.readString();
                name = in.readString();
                cover_img = in.readString();
                recommend_img = in.readString();
                theme_id = in.readString();
                praise_num = in.readString();
                is_praise = in.readInt();
                tags = in.createStringArrayList();
            }

            public static final Creator<LectureBean> CREATOR = new Creator<LectureBean>() {
                @Override
                public LectureBean createFromParcel(Parcel in) {
                    return new LectureBean(in);
                }

                @Override
                public LectureBean[] newArray(int size) {
                    return new LectureBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(name);
                dest.writeString(cover_img);
                dest.writeString(recommend_img);
                dest.writeString(theme_id);
                dest.writeString(praise_num);
                dest.writeInt(is_praise);
                dest.writeStringList(tags);
            }
        }

        public static class CourseBean implements Parcelable {
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

            protected CourseBean(Parcel in) {
                id = in.readString();
                cover_img = in.readString();
                theme_name = in.readString();
                lecturer = in.readString();
                play_num = in.readString();
                praise_num = in.readString();
                virtual_coin = in.readString();
                video_num = in.readString();
                category_id = in.readString();
                category_name = in.readString();
                is_praise = in.readInt();
            }

            public static final Creator<CourseBean> CREATOR = new Creator<CourseBean>() {
                @Override
                public CourseBean createFromParcel(Parcel in) {
                    return new CourseBean(in);
                }

                @Override
                public CourseBean[] newArray(int size) {
                    return new CourseBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(cover_img);
                dest.writeString(theme_name);
                dest.writeString(lecturer);
                dest.writeString(play_num);
                dest.writeString(praise_num);
                dest.writeString(virtual_coin);
                dest.writeString(video_num);
                dest.writeString(category_id);
                dest.writeString(category_name);
                dest.writeInt(is_praise);
            }
        }

        public static class CommentHighBean implements Parcelable{
            /**
             * id : 5
             * cover_img_min : /images/201903/72012.jpg
             * cover_img : http://test.res.tutuyaedu.com/images/201903/72012.jpg
             */

            private String id;
            private String cover_img_min;
            private String cover_img;

            protected CommentHighBean(Parcel in) {
                id = in.readString();
                cover_img_min = in.readString();
                cover_img = in.readString();
            }

            public static final Creator<CommentHighBean> CREATOR = new Creator<CommentHighBean>() {
                @Override
                public CommentHighBean createFromParcel(Parcel in) {
                    return new CommentHighBean(in);
                }

                @Override
                public CommentHighBean[] newArray(int size) {
                    return new CommentHighBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(cover_img_min);
                dest.writeString(cover_img);
            }
        }

        public static class CommentLowBean implements Parcelable {
            /**
             * id : 6
             * cover_img_min : /images/201903/98598.jpg
             * cover_img : http://test.res.tutuyaedu.com/images/201903/98598.jpg
             */

            private String id;
            private String cover_img_min;
            private String cover_img;

            protected CommentLowBean(Parcel in) {
                id = in.readString();
                cover_img_min = in.readString();
                cover_img = in.readString();
            }

            public static final Creator<CommentLowBean> CREATOR = new Creator<CommentLowBean>() {
                @Override
                public CommentLowBean createFromParcel(Parcel in) {
                    return new CommentLowBean(in);
                }

                @Override
                public CommentLowBean[] newArray(int size) {
                    return new CommentLowBean[size];
                }
            };

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(cover_img_min);
                dest.writeString(cover_img);
            }
        }

        public static class ShopBean implements Parcelable {
            /**
             * id : 1
             * goods_no : bm0000001
             * goods_name : 小米8
             * goods_cover : http://test.res.tutuyaedu.com/images/201812/19479.jpg
             * ec_price : 18
             * sale_count : 10000
             */

            private String id;
            private String goods_no;
            private String goods_name;
            private String goods_cover;
            private int ec_price;
            private String sale_count;

            protected ShopBean(Parcel in) {
                id = in.readString();
                goods_no = in.readString();
                goods_name = in.readString();
                goods_cover = in.readString();
                ec_price = in.readInt();
                sale_count = in.readString();
            }

            public static final Creator<ShopBean> CREATOR = new Creator<ShopBean>() {
                @Override
                public ShopBean createFromParcel(Parcel in) {
                    return new ShopBean(in);
                }

                @Override
                public ShopBean[] newArray(int size) {
                    return new ShopBean[size];
                }
            };

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_no() {
                return goods_no;
            }

            public void setGoods_no(String goods_no) {
                this.goods_no = goods_no;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_cover() {
                return goods_cover;
            }

            public void setGoods_cover(String goods_cover) {
                this.goods_cover = goods_cover;
            }

            public int getEc_price() {
                return ec_price;
            }

            public void setEc_price(int ec_price) {
                this.ec_price = ec_price;
            }

            public String getSale_count() {
                return sale_count;
            }

            public void setSale_count(String sale_count) {
                this.sale_count = sale_count;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(goods_no);
                dest.writeString(goods_name);
                dest.writeString(goods_cover);
                dest.writeInt(ec_price);
                dest.writeString(sale_count);
            }
        }
    }
}
