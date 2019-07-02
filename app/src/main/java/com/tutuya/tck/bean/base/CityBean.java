package com.tutuya.tck.bean.base;

import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：城市选择实体类
 * @date 创建时间：2019/4/17
 */
public class CityBean implements IPickerViewData {

    /**
     * value : 1
     * label : 北京
     * children : [{"value":"2","label":"北京","children":[{"value":"3","label":"东城"},{"value":"4","label":"西城"},{"value":"5","label":"朝阳"},{"value":"6","label":"丰台"},{"value":"7","label":"石景山"},{"value":"8","label":"海淀"},{"value":"9","label":"门头沟"},{"value":"10","label":"房山"},{"value":"11","label":"通州"},{"value":"12","label":"顺义"},{"value":"13","label":"昌平"},{"value":"14","label":"大兴"},{"value":"15","label":"怀柔"},{"value":"16","label":"平谷"},{"value":"17","label":"密云"},{"value":"18","label":"延庆"}]}]
     */

    private String value;
    private String label;
    private List<ChildrenBeanX> children;

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

    public List<ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBeanX> children) {
        this.children = children;
    }

    @Override
    public String getPickerViewText() {
        return label;
    }

    public static class ChildrenBeanX implements IPickerViewData {
        /**
         * value : 2
         * label : 北京
         * children : [{"value":"3","label":"东城"},{"value":"4","label":"西城"},{"value":"5","label":"朝阳"},{"value":"6","label":"丰台"},{"value":"7","label":"石景山"},{"value":"8","label":"海淀"},{"value":"9","label":"门头沟"},{"value":"10","label":"房山"},{"value":"11","label":"通州"},{"value":"12","label":"顺义"},{"value":"13","label":"昌平"},{"value":"14","label":"大兴"},{"value":"15","label":"怀柔"},{"value":"16","label":"平谷"},{"value":"17","label":"密云"},{"value":"18","label":"延庆"}]
         */

        private String value;
        private String label;
        private List<ChildrenBean> children;

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

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        @Override
        public String getPickerViewText() {
            return label;
        }

        public static class ChildrenBean {
            /**
             * value : 3
             * label : 东城
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
        }
    }
}
