package com.example.collegemessageonline.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/7/10.
 */

public class TabAdapter extends FragmentPagerAdapter {
// String[] title={"头条","社会","生活","校园","阅读","活动"};

    private ArrayList<Fragment> list;
    private ArrayList<String> arrayList;

    public TabAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> arrayList) {
        super(fm);
        this.list = list;
        this.arrayList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }
}
