package com.tutuya.tck.bean.network;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：首页轮播图实体类
 * @date 创建时间：2019/4/19
 */
public class HomeBannerBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : [{"img":"http://test.res.tutuyaedu.com/images/201812/15856.jpg","url":"1","to":"0"},{"img":"http://test.res.tutuyaedu.com/images/201812/44600.jpg","url":"www.tutuya.com","to":"0"}]
     */

    private int errorcode;
    private String errormessage;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * img : http://test.res.tutuyaedu.com/images/201812/15856.jpg
         * url : 1
         * to : 0
         */

        private String img;
        private String url;
        private String to;

        protected DataBean(Parcel in) {
            img = in.readString();
            url = in.readString();
            to = in.readString();
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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(img);
            dest.writeString(url);
            dest.writeString(to);
        }
    }
}
