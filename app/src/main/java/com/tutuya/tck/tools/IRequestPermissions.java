package com.tutuya.tck.tools;

import android.app.Activity;

/**
 * @version 1.0
 * @author  tyh
 * @功能：权限申请接口
 * @date 创建时间：2019/4/28
 */
public interface IRequestPermissions {
    boolean requestPermissions(Activity activity, String[] permissions, int resultCode);
}
