package com.tutuya.tck.bean.network;

import java.util.List;

/**
 * @version 1.0
 * @author  tyh
 * @功能：
 * @date 创建时间：2019/4/29
 */
public class HomeClassingNewBean {


    /**
     * errorcode : 200
     * errormessage : 成功
     * data : {"page":"1","data":[{"id":"72","cover_img":"http://test.res.tutuyaedu.com/images/201904/54140.jpg","theme_name":"测试主题17","lecturer":"诺一","play_num":"333","praise_num":"333","virtual_coin":"1000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-04-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"71","cover_img":"http://test.res.tutuyaedu.com/images/201904/45281.jpg","theme_name":"测试主题16","lecturer":"王晶","play_num":"445","praise_num":"334","virtual_coin":"33","video_num":"3","category_top_id":"13","category_id":"28","start_tm":"2019-04-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"70","cover_img":"http://test.res.tutuyaedu.com/images/201904/92262.jpg","theme_name":"测试主题15","lecturer":"鲁晋","play_num":"9999","praise_num":"10000","virtual_coin":"655","video_num":"2","category_top_id":"13","category_id":"14","start_tm":"2019-04-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"69","cover_img":"http://test.res.tutuyaedu.com/images/201904/62491.jpg","theme_name":"测试主题14","lecturer":"谷传玲","play_num":"1007","praise_num":"888","virtual_coin":"8","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-04-07 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"68","cover_img":"http://test.res.tutuyaedu.com/images/201904/55491.jpg","theme_name":"测试主题13","lecturer":"吉超","play_num":"558","praise_num":"555","virtual_coin":"50","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-04-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"67","cover_img":"http://test.res.tutuyaedu.com/images/201904/12108.jpg","theme_name":"测试主题12","lecturer":"陈玉荣","play_num":"111","praise_num":"112","virtual_coin":"10","video_num":"3","category_top_id":"13","category_id":"14","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"66","cover_img":"http://test.res.tutuyaedu.com/images/201904/89383.jpg","theme_name":"测试主题11","lecturer":"王晶","play_num":"666","praise_num":"666","virtual_coin":"60","video_num":"1","category_top_id":"13","category_id":"14","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"65","cover_img":"http://test.res.tutuyaedu.com/images/201904/16285.jpg","theme_name":"测试主题10","lecturer":"王晶","play_num":"336","praise_num":"333","virtual_coin":"800","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"64","cover_img":"http://test.res.tutuyaedu.com/images/201904/57387.jpg","theme_name":"测试主题9","lecturer":"陈玉荣","play_num":"447","praise_num":"444","virtual_coin":"500","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"63","cover_img":"http://test.res.tutuyaedu.com/images/201904/34836.jpg","theme_name":"测试主题8","lecturer":"吉超","play_num":"777","praise_num":"777","virtual_coin":"400","video_num":"1","category_top_id":"13","category_id":"14","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"62","cover_img":"http://test.res.tutuyaedu.com/images/201904/95118.jpg","theme_name":"测试主题7","lecturer":"谷传玲","play_num":"897","praise_num":"888","virtual_coin":"1000","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"60","cover_img":"http://test.res.tutuyaedu.com/images/201903/64356.jpg","theme_name":"测试主题6","lecturer":"孟雪","play_num":"666","praise_num":"666","virtual_coin":"1000","video_num":"1","category_top_id":"13","category_id":"14","start_tm":"2019-03-28 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"59","cover_img":"http://test.res.tutuyaedu.com/images/201903/50913.jpg","theme_name":"测试主题5","lecturer":"孟雪","play_num":"670","praise_num":"666","virtual_coin":"600","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-03-29 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"58","cover_img":"http://test.res.tutuyaedu.com/images/201903/73133.jpg","theme_name":"测试主题4","lecturer":"孟雪","play_num":"447","praise_num":"445","virtual_coin":"400","video_num":"1","category_top_id":"11","category_id":"12","start_tm":"2019-03-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"57","cover_img":"http://test.res.tutuyaedu.com/images/201903/28192.jpg","theme_name":"测试主题3","lecturer":"吕途","play_num":"666","praise_num":"666","virtual_coin":"500","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-03-28 14:09:34","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"56","cover_img":"http://test.res.tutuyaedu.com/images/201903/86589.jpg","theme_name":"测试主题2","lecturer":"张明月","play_num":"890","praise_num":"888","virtual_coin":"2000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-03-28 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"55","cover_img":"http://test.res.tutuyaedu.com/images/201903/30516.jpg","theme_name":"测试主题1","lecturer":"张明月","play_num":"223","praise_num":"222","virtual_coin":"1000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-03-28 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"54","cover_img":"http://test.res.tutuyaedu.com/images/201903/82341.jpg","theme_name":"测试主题","lecturer":"吕途","play_num":"669","praise_num":"666","virtual_coin":"2000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-03-27 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"53","cover_img":"http://test.res.tutuyaedu.com/images/201903/24224.jpg","theme_name":"语言表达能力","lecturer":"刘笑彤","play_num":"777","praise_num":"777","virtual_coin":"100","video_num":"4","category_top_id":"9","category_id":"10","start_tm":"2019-03-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"52","cover_img":"http://test.res.tutuyaedu.com/images/201903/50343.jpg","theme_name":"5月动手能力","lecturer":"刘笑彤","play_num":"1208","praise_num":"889","virtual_coin":"1000","video_num":"3","category_top_id":"11","category_id":"12","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"51","cover_img":"http://test.res.tutuyaedu.com/images/201903/28192.jpg","theme_name":"语言表达力讲座","lecturer":"吕途","play_num":"1026","praise_num":"1000","virtual_coin":"300","video_num":"2","category_top_id":"13","category_id":"28","start_tm":"2019-03-26 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"49","cover_img":"http://test.res.tutuyaedu.com/images/201903/69620.jpg","theme_name":"3月表达力","lecturer":"张明月","play_num":"597","praise_num":"665","virtual_coin":"200","video_num":"6","category_top_id":"13","category_id":"28","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"48","cover_img":"http://test.res.tutuyaedu.com","theme_name":"4月判断力","lecturer":"候艳云","play_num":"84","praise_num":"1","virtual_coin":"100","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-04-01 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"47","cover_img":"http://test.res.tutuyaedu.com","theme_name":"eeee","lecturer":"测试名称","play_num":"22","praise_num":"33","virtual_coin":"33","video_num":"3","category_top_id":"34","category_id":"42","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"第十三周-","is_buy":0,"is_praise":0},{"id":"46","cover_img":"http://test.res.tutuyaedu.com","theme_name":"dddd","lecturer":"","play_num":"11","praise_num":"11","virtual_coin":"0","video_num":"0","category_top_id":"34","category_id":"42","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"第十三周-","is_buy":1,"is_praise":0},{"id":"45","cover_img":"http://test.res.tutuyaedu.com/images/201902/45201.jpg","theme_name":"哇哇哇哇","lecturer":"请选择","play_num":"1","praise_num":"1","virtual_coin":"0","video_num":"0","category_top_id":"9","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-第七周","is_buy":1,"is_praise":0},{"id":"44","cover_img":"http://test.res.tutuyaedu.com/images/201901/96476.jpg","theme_name":"范德萨发","lecturer":"123","play_num":"142","praise_num":"124","virtual_coin":"666","video_num":"1","category_top_id":"9","category_id":"26","start_tm":"2019-01-31 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-第六周","is_buy":0,"is_praise":0},{"id":"43","cover_img":"http://test.res.tutuyaedu.com/images/201901/46218.jpg","theme_name":"测试积分","lecturer":"莉莉娅","play_num":"551","praise_num":"345","virtual_coin":"999","video_num":"2","category_top_id":"34","category_id":"42","start_tm":"2019-01-31 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"第十三周-","is_buy":0,"is_praise":0},{"id":"42","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"测试主题名称","lecturer":"测试测试","play_num":"46","praise_num":"1","virtual_coin":"100","video_num":"1","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":0,"is_praise":0},{"id":"41","cover_img":"http://test.res.tutuyaedu.com/images/201901/33414.jpg","theme_name":"测试测试主题","lecturer":"测试","play_num":"5","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":1,"is_praise":0},{"id":"40","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"sdafasdasdff","lecturer":"的说法地方","play_num":"0","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"9","category_id":"42","start_tm":"2019-01-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-","is_buy":1,"is_praise":0},{"id":"39","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"沙发斯蒂芬","lecturer":"阀手动阀","play_num":"0","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"13","category_id":"42","start_tm":"2019-01-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"34","cover_img":"http://test.res.tutuyaedu.com/images/201901/33414.jpg","theme_name":"测试宝宝教育1.16","lecturer":"王晶","play_num":"1198","praise_num":"890","virtual_coin":"200","video_num":"6","category_top_id":"15","category_id":"42","start_tm":"2019-01-17 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"拓展教育-","is_buy":0,"is_praise":0},{"id":"33","cover_img":"http://test.res.tutuyaedu.com/images/201901/57571.jpg","theme_name":"测试园长","lecturer":"莉莉娅","play_num":"1034","praise_num":"1000","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":1,"is_praise":0},{"id":"32","cover_img":"http://test.res.tutuyaedu.com/images/201901/70993.jpg","theme_name":"音乐发音培训","lecturer":"娜娜","play_num":"1028","praise_num":"1004","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"36","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"31","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"手工艺拼图培训","lecturer":"丫丫","play_num":"1067","praise_num":"898","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"41","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"30","cover_img":"http://test.res.tutuyaedu.com/images/201901/27711.jpg","theme_name":"手工艺黏土培训","lecturer":"图图","play_num":"754","praise_num":"669","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"41","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"29","cover_img":"http://test.res.tutuyaedu.com/images/201901/26778.jpg","theme_name":"手工艺折纸培训","lecturer":"涂涂鸦","play_num":"1037","praise_num":"1000","virtual_coin":"300","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"28","cover_img":"http://test.res.tutuyaedu.com/images/201901/65402.jpg","theme_name":"手工培训课程","lecturer":"李涂涂","play_num":"1013","praise_num":"994","virtual_coin":"200","video_num":"3","category_top_id":"13","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":1},{"id":"27","cover_img":"http://test.res.tutuyaedu.com/images/201901/27526.jpg","theme_name":"各国语言基础培训","lecturer":"Lina","play_num":"1164","praise_num":"1006","virtual_coin":"0","video_num":"4","category_top_id":"13","category_id":"39","start_tm":"2019-01-10 11:35:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"26","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"www","lecturer":"www","play_num":"0","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"1","category_id":"4","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"教师视频-测试001","is_buy":1,"is_praise":0},{"id":"25","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"eee","lecturer":"eee","play_num":"0","praise_num":"0","virtual_coin":0,"video_num":"0","category_top_id":"5","category_id":"28","start_tm":"2019-01-26 00:00:00","end_tm":"2019-01-31 00:00:00","category_name":"园长分享-能力","is_buy":1,"is_praise":0},{"id":"24","cover_img":"http://test.res.tutuyaedu.com/images/201812/22099.jpg","theme_name":"ddd","lecturer":"ddd","play_num":"26","praise_num":"223","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-27 00:00:00","end_tm":"2018-12-28 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"23","cover_img":"http://test.res.tutuyaedu.com/images/201812/98720.jpg","theme_name":"www","lecturer":"www","play_num":"5","praise_num":"1","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-27 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"22","cover_img":"http://test.res.tutuyaedu.com/images/201812/60561.jpg","theme_name":"ceshi","lecturer":"ceshi","play_num":"25","praise_num":"22","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"3","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-29 00:00:00","category_name":"家庭教育-创造力","is_buy":1,"is_praise":0},{"id":"21","cover_img":"http://test.res.tutuyaedu.com/images/201812/92480.jpg","theme_name":"主题名称主题名称","lecturer":"讲师讲师讲师","play_num":"207","praise_num":"11","virtual_coin":0,"video_num":"1","category_top_id":"5","category_id":"27","start_tm":"2018-12-19 00:00:00","end_tm":"2018-12-27 00:00:00","category_name":"园长分享-第七周","is_buy":1,"is_praise":0},{"id":"20","cover_img":"http://test.res.tutuyaedu.com/images/201812/56056.jpg","theme_name":"宝宝动手能力","lecturer":"Lina","play_num":"1007","praise_num":"2357","virtual_coin":0,"video_num":"0","category_top_id":"8","category_id":"10","start_tm":"2018-12-19 00:00:00","end_tm":"2018-12-31 00:00:00","category_name":"创造力-健康","is_buy":1,"is_praise":0},{"id":"19","cover_img":"http://test.res.tutuyaedu.com/images/201812/48813.jpg","theme_name":"测试脑动力","lecturer":"123","play_num":"753","praise_num":"591","virtual_coin":0,"video_num":"1","category_top_id":"8","category_id":"10","start_tm":"2018-12-17 14:00:00","end_tm":"2018-12-17 14:05:00","category_name":"创造力-健康","is_buy":1,"is_praise":0},{"id":"18","cover_img":"http://test.res.tutuyaedu.com/images/201812/10201.jpg","theme_name":"e","lecturer":"e","play_num":"10","praise_num":"1","virtual_coin":0,"video_num":"0","category_top_id":"8","category_id":"10","start_tm":"2018-12-18 00:00:00","end_tm":"2018-12-26 00:00:00","category_name":"创造力-健康","is_buy":1,"is_praise":0},{"id":"17","cover_img":"http://test.res.tutuyaedu.com/images/201812/79417.jpg","theme_name":"开发脑动力，增加脑智慧，开发脑动力，增加脑智慧开发脑动力","lecturer":"李静","play_num":"696","praise_num":"970","virtual_coin":0,"video_num":"1","category_top_id":"8","category_id":"10","start_tm":"2018-12-19 11:42:00","end_tm":"2018-12-19 11:50:00","category_name":"创造力-健康","is_buy":1,"is_praise":0}]}
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
         * page : 1
         * data : [{"id":"72","cover_img":"http://test.res.tutuyaedu.com/images/201904/54140.jpg","theme_name":"测试主题17","lecturer":"诺一","play_num":"333","praise_num":"333","virtual_coin":"1000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-04-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"71","cover_img":"http://test.res.tutuyaedu.com/images/201904/45281.jpg","theme_name":"测试主题16","lecturer":"王晶","play_num":"445","praise_num":"334","virtual_coin":"33","video_num":"3","category_top_id":"13","category_id":"28","start_tm":"2019-04-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"70","cover_img":"http://test.res.tutuyaedu.com/images/201904/92262.jpg","theme_name":"测试主题15","lecturer":"鲁晋","play_num":"9999","praise_num":"10000","virtual_coin":"655","video_num":"2","category_top_id":"13","category_id":"14","start_tm":"2019-04-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"69","cover_img":"http://test.res.tutuyaedu.com/images/201904/62491.jpg","theme_name":"测试主题14","lecturer":"谷传玲","play_num":"1007","praise_num":"888","virtual_coin":"8","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-04-07 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"68","cover_img":"http://test.res.tutuyaedu.com/images/201904/55491.jpg","theme_name":"测试主题13","lecturer":"吉超","play_num":"558","praise_num":"555","virtual_coin":"50","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-04-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"67","cover_img":"http://test.res.tutuyaedu.com/images/201904/12108.jpg","theme_name":"测试主题12","lecturer":"陈玉荣","play_num":"111","praise_num":"112","virtual_coin":"10","video_num":"3","category_top_id":"13","category_id":"14","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"66","cover_img":"http://test.res.tutuyaedu.com/images/201904/89383.jpg","theme_name":"测试主题11","lecturer":"王晶","play_num":"666","praise_num":"666","virtual_coin":"60","video_num":"1","category_top_id":"13","category_id":"14","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"65","cover_img":"http://test.res.tutuyaedu.com/images/201904/16285.jpg","theme_name":"测试主题10","lecturer":"王晶","play_num":"336","praise_num":"333","virtual_coin":"800","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"64","cover_img":"http://test.res.tutuyaedu.com/images/201904/57387.jpg","theme_name":"测试主题9","lecturer":"陈玉荣","play_num":"447","praise_num":"444","virtual_coin":"500","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"63","cover_img":"http://test.res.tutuyaedu.com/images/201904/34836.jpg","theme_name":"测试主题8","lecturer":"吉超","play_num":"777","praise_num":"777","virtual_coin":"400","video_num":"1","category_top_id":"13","category_id":"14","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"62","cover_img":"http://test.res.tutuyaedu.com/images/201904/95118.jpg","theme_name":"测试主题7","lecturer":"谷传玲","play_num":"897","praise_num":"888","virtual_coin":"1000","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-04-02 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"60","cover_img":"http://test.res.tutuyaedu.com/images/201903/64356.jpg","theme_name":"测试主题6","lecturer":"孟雪","play_num":"666","praise_num":"666","virtual_coin":"1000","video_num":"1","category_top_id":"13","category_id":"14","start_tm":"2019-03-28 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-习惯","is_buy":0,"is_praise":0},{"id":"59","cover_img":"http://test.res.tutuyaedu.com/images/201903/50913.jpg","theme_name":"测试主题5","lecturer":"孟雪","play_num":"670","praise_num":"666","virtual_coin":"600","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-03-29 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"58","cover_img":"http://test.res.tutuyaedu.com/images/201903/73133.jpg","theme_name":"测试主题4","lecturer":"孟雪","play_num":"447","praise_num":"445","virtual_coin":"400","video_num":"1","category_top_id":"11","category_id":"12","start_tm":"2019-03-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"57","cover_img":"http://test.res.tutuyaedu.com/images/201903/28192.jpg","theme_name":"测试主题3","lecturer":"吕途","play_num":"666","praise_num":"666","virtual_coin":"500","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-03-28 14:09:34","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"56","cover_img":"http://test.res.tutuyaedu.com/images/201903/86589.jpg","theme_name":"测试主题2","lecturer":"张明月","play_num":"890","praise_num":"888","virtual_coin":"2000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-03-28 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"55","cover_img":"http://test.res.tutuyaedu.com/images/201903/30516.jpg","theme_name":"测试主题1","lecturer":"张明月","play_num":"223","praise_num":"222","virtual_coin":"1000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-03-28 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"54","cover_img":"http://test.res.tutuyaedu.com/images/201903/82341.jpg","theme_name":"测试主题","lecturer":"吕途","play_num":"669","praise_num":"666","virtual_coin":"2000","video_num":"1","category_top_id":"9","category_id":"10","start_tm":"2019-03-27 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"53","cover_img":"http://test.res.tutuyaedu.com/images/201903/24224.jpg","theme_name":"语言表达能力","lecturer":"刘笑彤","play_num":"777","praise_num":"777","virtual_coin":"100","video_num":"4","category_top_id":"9","category_id":"10","start_tm":"2019-03-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"52","cover_img":"http://test.res.tutuyaedu.com/images/201903/50343.jpg","theme_name":"5月动手能力","lecturer":"刘笑彤","play_num":"1208","praise_num":"889","virtual_coin":"1000","video_num":"3","category_top_id":"11","category_id":"12","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-亲子","is_buy":0,"is_praise":0},{"id":"51","cover_img":"http://test.res.tutuyaedu.com/images/201903/28192.jpg","theme_name":"语言表达力讲座","lecturer":"吕途","play_num":"1026","praise_num":"1000","virtual_coin":"300","video_num":"2","category_top_id":"13","category_id":"28","start_tm":"2019-03-26 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"49","cover_img":"http://test.res.tutuyaedu.com/images/201903/69620.jpg","theme_name":"3月表达力","lecturer":"张明月","play_num":"597","praise_num":"665","virtual_coin":"200","video_num":"6","category_top_id":"13","category_id":"28","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"48","cover_img":"http://test.res.tutuyaedu.com","theme_name":"4月判断力","lecturer":"候艳云","play_num":"84","praise_num":"1","virtual_coin":"100","video_num":"2","category_top_id":"9","category_id":"10","start_tm":"2019-04-01 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-健康","is_buy":0,"is_praise":0},{"id":"47","cover_img":"http://test.res.tutuyaedu.com","theme_name":"eeee","lecturer":"测试名称","play_num":"22","praise_num":"33","virtual_coin":"33","video_num":"3","category_top_id":"34","category_id":"42","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"第十三周-","is_buy":0,"is_praise":0},{"id":"46","cover_img":"http://test.res.tutuyaedu.com","theme_name":"dddd","lecturer":"","play_num":"11","praise_num":"11","virtual_coin":"0","video_num":"0","category_top_id":"34","category_id":"42","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"第十三周-","is_buy":1,"is_praise":0},{"id":"45","cover_img":"http://test.res.tutuyaedu.com/images/201902/45201.jpg","theme_name":"哇哇哇哇","lecturer":"请选择","play_num":"1","praise_num":"1","virtual_coin":"0","video_num":"0","category_top_id":"9","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-第七周","is_buy":1,"is_praise":0},{"id":"44","cover_img":"http://test.res.tutuyaedu.com/images/201901/96476.jpg","theme_name":"范德萨发","lecturer":"123","play_num":"142","praise_num":"124","virtual_coin":"666","video_num":"1","category_top_id":"9","category_id":"26","start_tm":"2019-01-31 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-第六周","is_buy":0,"is_praise":0},{"id":"43","cover_img":"http://test.res.tutuyaedu.com/images/201901/46218.jpg","theme_name":"测试积分","lecturer":"莉莉娅","play_num":"551","praise_num":"345","virtual_coin":"999","video_num":"2","category_top_id":"34","category_id":"42","start_tm":"2019-01-31 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"第十三周-","is_buy":0,"is_praise":0},{"id":"42","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"测试主题名称","lecturer":"测试测试","play_num":"46","praise_num":"1","virtual_coin":"100","video_num":"1","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":0,"is_praise":0},{"id":"41","cover_img":"http://test.res.tutuyaedu.com/images/201901/33414.jpg","theme_name":"测试测试主题","lecturer":"测试","play_num":"5","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"11","category_id":"27","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"家庭教育-第七周","is_buy":1,"is_praise":0},{"id":"40","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"sdafasdasdff","lecturer":"的说法地方","play_num":"0","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"9","category_id":"42","start_tm":"2019-01-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"健康教育-","is_buy":1,"is_praise":0},{"id":"39","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"沙发斯蒂芬","lecturer":"阀手动阀","play_num":"0","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"13","category_id":"42","start_tm":"2019-01-30 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"34","cover_img":"http://test.res.tutuyaedu.com/images/201901/33414.jpg","theme_name":"测试宝宝教育1.16","lecturer":"王晶","play_num":"1198","praise_num":"890","virtual_coin":"200","video_num":"6","category_top_id":"15","category_id":"42","start_tm":"2019-01-17 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"拓展教育-","is_buy":0,"is_praise":0},{"id":"33","cover_img":"http://test.res.tutuyaedu.com/images/201901/57571.jpg","theme_name":"测试园长","lecturer":"莉莉娅","play_num":"1034","praise_num":"1000","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":1,"is_praise":0},{"id":"32","cover_img":"http://test.res.tutuyaedu.com/images/201901/70993.jpg","theme_name":"音乐发音培训","lecturer":"娜娜","play_num":"1028","praise_num":"1004","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"36","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"31","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"手工艺拼图培训","lecturer":"丫丫","play_num":"1067","praise_num":"898","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"41","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"30","cover_img":"http://test.res.tutuyaedu.com/images/201901/27711.jpg","theme_name":"手工艺黏土培训","lecturer":"图图","play_num":"754","praise_num":"669","virtual_coin":"0","video_num":"1","category_top_id":"13","category_id":"41","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"29","cover_img":"http://test.res.tutuyaedu.com/images/201901/26778.jpg","theme_name":"手工艺折纸培训","lecturer":"涂涂鸦","play_num":"1037","praise_num":"1000","virtual_coin":"300","video_num":"1","category_top_id":"13","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":0},{"id":"28","cover_img":"http://test.res.tutuyaedu.com/images/201901/65402.jpg","theme_name":"手工培训课程","lecturer":"李涂涂","play_num":"1013","praise_num":"994","virtual_coin":"200","video_num":"3","category_top_id":"13","category_id":"28","start_tm":"2019-01-11 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-能力","is_buy":0,"is_praise":1},{"id":"27","cover_img":"http://test.res.tutuyaedu.com/images/201901/27526.jpg","theme_name":"各国语言基础培训","lecturer":"Lina","play_num":"1164","praise_num":"1006","virtual_coin":"0","video_num":"4","category_top_id":"13","category_id":"39","start_tm":"2019-01-10 11:35:00","end_tm":"2020-01-08 00:00:00","category_name":"养成教育-","is_buy":1,"is_praise":0},{"id":"26","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"www","lecturer":"www","play_num":"0","praise_num":"0","virtual_coin":"0","video_num":"0","category_top_id":"1","category_id":"4","start_tm":"2019-01-08 00:00:00","end_tm":"2020-01-08 00:00:00","category_name":"教师视频-测试001","is_buy":1,"is_praise":0},{"id":"25","cover_img":"http://test.res.tutuyaedu.com/images/201901/44152.jpg","theme_name":"eee","lecturer":"eee","play_num":"0","praise_num":"0","virtual_coin":0,"video_num":"0","category_top_id":"5","category_id":"28","start_tm":"2019-01-26 00:00:00","end_tm":"2019-01-31 00:00:00","category_name":"园长分享-能力","is_buy":1,"is_praise":0},{"id":"24","cover_img":"http://test.res.tutuyaedu.com/images/201812/22099.jpg","theme_name":"ddd","lecturer":"ddd","play_num":"26","praise_num":"223","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-27 00:00:00","end_tm":"2018-12-28 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"23","cover_img":"http://test.res.tutuyaedu.com/images/201812/98720.jpg","theme_name":"www","lecturer":"www","play_num":"5","praise_num":"1","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"13","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-27 00:00:00","category_name":"家庭教育-养成教育","is_buy":1,"is_praise":0},{"id":"22","cover_img":"http://test.res.tutuyaedu.com/images/201812/60561.jpg","theme_name":"ceshi","lecturer":"ceshi","play_num":"25","praise_num":"22","virtual_coin":0,"video_num":"0","category_top_id":"11","category_id":"3","start_tm":"2018-12-20 00:00:00","end_tm":"2018-12-29 00:00:00","category_name":"家庭教育-创造力","is_buy":1,"is_praise":0},{"id":"21","cover_img":"http://test.res.tutuyaedu.com/images/201812/92480.jpg","theme_name":"主题名称主题名称","lecturer":"讲师讲师讲师","play_num":"207","praise_num":"11","virtual_coin":0,"video_num":"1","category_top_id":"5","category_id":"27","start_tm":"2018-12-19 00:00:00","end_tm":"2018-12-27 00:00:00","category_name":"园长分享-第七周","is_buy":1,"is_praise":0},{"id":"20","cover_img":"http://test.res.tutuyaedu.com/images/201812/56056.jpg","theme_name":"宝宝动手能力","lecturer":"Lina","play_num":"1007","praise_num":"2357","virtual_coin":0,"video_num":"0","category_top_id":"8","category_id":"10","start_tm":"2018-12-19 00:00:00","end_tm":"2018-12-31 00:00:00","category_name":"创造力-健康","is_buy":1,"is_praise":0},{"id":"19","cover_img":"http://test.res.tutuyaedu.com/images/201812/48813.jpg","theme_name":"测试脑动力","lecturer":"123","play_num":"753","praise_num":"591","virtual_coin":0,"video_num":"1","category_top_id":"8","category_id":"10","start_tm":"2018-12-17 14:00:00","end_tm":"2018-12-17 14:05:00","category_name":"创造力-健康","is_buy":1,"is_praise":0},{"id":"18","cover_img":"http://test.res.tutuyaedu.com/images/201812/10201.jpg","theme_name":"e","lecturer":"e","play_num":"10","praise_num":"1","virtual_coin":0,"video_num":"0","category_top_id":"8","category_id":"10","start_tm":"2018-12-18 00:00:00","end_tm":"2018-12-26 00:00:00","category_name":"创造力-健康","is_buy":1,"is_praise":0},{"id":"17","cover_img":"http://test.res.tutuyaedu.com/images/201812/79417.jpg","theme_name":"开发脑动力，增加脑智慧，开发脑动力，增加脑智慧开发脑动力","lecturer":"李静","play_num":"696","praise_num":"970","virtual_coin":0,"video_num":"1","category_top_id":"8","category_id":"10","start_tm":"2018-12-19 11:42:00","end_tm":"2018-12-19 11:50:00","category_name":"创造力-健康","is_buy":1,"is_praise":0}]
         */

        private String page;
        private List<DataBean> data;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 72
             * cover_img : http://test.res.tutuyaedu.com/images/201904/54140.jpg
             * theme_name : 测试主题17
             * lecturer : 诺一
             * play_num : 333
             * praise_num : 333
             * virtual_coin : 1000
             * video_num : 1
             * category_top_id : 9
             * category_id : 10
             * start_tm : 2019-04-11 00:00:00
             * end_tm : 2020-01-08 00:00:00
             * category_name : 健康教育-健康
             * is_buy : 0
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
            private String category_top_id;
            private String category_id;
            private String start_tm;
            private String end_tm;
            private String category_name;
            private int is_buy;
            private int is_praise;

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

            public String getCategory_top_id() {
                return category_top_id;
            }

            public void setCategory_top_id(String category_top_id) {
                this.category_top_id = category_top_id;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getStart_tm() {
                return start_tm;
            }

            public void setStart_tm(String start_tm) {
                this.start_tm = start_tm;
            }

            public String getEnd_tm() {
                return end_tm;
            }

            public void setEnd_tm(String end_tm) {
                this.end_tm = end_tm;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getIs_buy() {
                return is_buy;
            }

            public void setIs_buy(int is_buy) {
                this.is_buy = is_buy;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }
        }
    }
}
