package com.tutuya.tck.bean.network;



import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/23
 */
public class BabyInClassBean  {

    /**
     * errorcode :
     * errormessage :
     * data : [{"baby_id":"","name":"","idcard":""}]
     */

    private String errorcode;
    private String errormessage;
    private List<DataBean> data;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
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

    public static class DataBean implements IPickerViewData {
        /**
         * baby_id :
         * name :
         * idcard :
         */

        private String baby_id;
        private String name;
        private String idcard;

        public String getBaby_id() {
            return baby_id;
        }

        public void setBaby_id(String baby_id) {
            this.baby_id = baby_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
