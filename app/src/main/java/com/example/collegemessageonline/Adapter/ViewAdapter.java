package com.example.collegemessageonline.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/5/15.
 */
public class ViewAdapter extends StaticPagerAdapter {
    private ArrayList<String> imageurl;
    private Context context;

    public ViewAdapter(Context context, ArrayList<String> imageurl) {
        this.imageurl = imageurl;
        this.context=context;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        Glide.with(context).load(imageurl.get(position)).into(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return imageurl.size();
    }
}
