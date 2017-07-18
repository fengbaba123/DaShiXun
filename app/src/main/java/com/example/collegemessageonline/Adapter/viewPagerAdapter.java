package com.example.collegemessageonline.Adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 陆向阳 on 2017/6/20.
 */

public class viewPagerAdapter extends PagerAdapter {
        private List<ImageView> mList;
    public viewPagerAdapter(List<ImageView> mList) {
            this.mList=mList;
        Log.e("TAG---------------",mList.toString());
    };

    @Override
    public int getCount() {
        int MAX=9999;
        return MAX;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int i=position%mList.size();
        container.addView(mList.get(i));
        return mList.get(i);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
