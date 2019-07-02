package com.tutuya.tck.frament.my;

public interface IMyView {

    void showToast(String s);
    void showDialog();
    void showLoading();
    void closeLoading();
    void photoOk(String url);
    void setDataUser(String name, String school, String img, String rmb,String phone);
    void setTeacherInfo(String id,String name, String className,String photoUrl );
}
