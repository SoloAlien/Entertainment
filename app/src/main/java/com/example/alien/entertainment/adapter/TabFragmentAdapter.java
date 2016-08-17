package com.example.alien.entertainment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Alien on 2016/8/16.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList;
    public TabFragmentAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        this.arrayList=arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
