package com.tutuya.tck.tools;

/**
 * @version 1.0
 * @author  tyh
 * @功能：权限申请类
 * @date 创建时间：2019/4/28
 */
public class RequestPermissions {
    private static RequestPermissions requestPermissions;
    public static RequestPermissions getInstance(){
        if(requestPermissions == null){
            requestPermissions = new RequestPermissions();
        }
        return requestPermissions;
    }
}
