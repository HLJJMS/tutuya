package com.tutuya.tck.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tutuya.tck.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/*
* 家庭教育列表
* 田羽衡 create
*
* */
public class GMAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmetnmanager;  //创建FragmentManager
    private List<BaseFragment> listfragment =new ArrayList<>(); //创建一个List<Fragment>

    public GMAdapter(FragmentManager fm, List<BaseFragment> listfragment) {
        super(fm);
        this.fragmetnmanager=fm;
        this.listfragment.addAll(listfragment);
    }

    @Override
    public Fragment getItem(int i) {
        return listfragment.get(i);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}
