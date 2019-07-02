package com.tutuya.tck.activity.mall.prodectdetail;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import com.tutuya.tck.R;
import com.tutuya.tck.base.BasePresenter;
import com.tutuya.tck.diyview.FlowRadioGroup;

import java.util.ArrayList;
import java.util.List;

public class ProdectDetailPresent extends BasePresenter<IProdectDetailView> {
    IProdectDetailView view;

    // 初始化VIEW
    public void getActivity() {
        if (isViewAttached()) {
            view = getView();
        } else {
            return;
        }
    }

    public void showPopup(Context context, int width, View rootView, int height) {
        List<String> list = new ArrayList<>();
        list.add("白色");
        list.add("黑色");
        list.add("黄色");
        list.add("蓝绿色");
        list.add("橄榄色");
        list.add("藕荷色");
        list.add("蓝白色");
        list.add("海军蓝");
        list.add("红色");
        View popView = LayoutInflater.from(context).inflate(R.layout.popup_prodect_type, null);
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(popView);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        FlowRadioGroup colorFr;
        colorFr = popView.findViewById(R.id.color_fv);
        colorFr.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        for(int i=0;i<list.size();i++){
            RadioButton radioButton = new RadioButton(context);
            radioButton.setChecked(false);
            radioButton.setText(list.get(i));
            colorFr.addView(radioButton);
        }


        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, height);
    }


}
