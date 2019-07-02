package com.tutuya.tck.bean.network;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：宝宝班级bean
 * @date 创建时间：2019/4/17
 */
public class BabyClassBean {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : [{"id":"62","name":"测试"}]
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
         * id : 62
         * name : 测试
         */

        private String id;
        private String name;

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

        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
