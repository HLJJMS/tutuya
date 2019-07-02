package com.tutuya.tck.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tutuya.tck.frament.TellDetailOldFragment;
import com.tutuya.tck.frament.TellDetailPersonFragment;

import java.util.ArrayList;
import java.util.List;

public class TellDetailAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<Fragment>();//数据集

    public TellDetailAdapter(FragmentManager fm) {
        super(fm);
        list.add(new TellDetailPersonFragment());
        list.add(new TellDetailOldFragment());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

}
