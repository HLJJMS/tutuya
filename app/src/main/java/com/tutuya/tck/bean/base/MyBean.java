package com.tutuya.tck.bean.base;

import android.content.Intent;

public class MyBean {
    public MyBean(int img, String txt, Intent intent, int divisor,String title) {
        this.img = img;
        this.txt = txt;
        this.intent = intent;
        this.divisor = divisor;
        this.title = title;
    }

    public MyBean(int img, String txt, Intent intent, int divisor) {
        this.img = img;
        this.divisor = divisor;
        this.txt = txt;
        this.intent = intent;
    }

    int img;
    int divisor;
    String txt;
    Intent intent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
}
