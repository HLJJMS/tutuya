package com.tutuya.tck.bean.network;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：查找城市脑测评地区
 * @date 创建时间：2019/4/18
 */
public class HeadCityFindAreaBean  {

    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"data":[{"value":"1","label":"山西省晋城市中心小学"}]}
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
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements IPickerViewData {
            /**
             * value : 1
             * label : 山西省晋城市中心小学
             */

            private String value;
            private String label;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            @Override
            public String getPickerViewText() {
                return label;
            }
        }
    }
}
