package com.example.collegemessageonline.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Controller.ShiTi.HeadLineShiTi;
import com.example.collegemessageonline.R;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class HeadLineAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HeadLineShiTi.DataBean> arrayList;

    public HeadLineAdapter(Context context, ArrayList<HeadLineShiTi.DataBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        Log.e("ASFSDGSDFGSDF", arrayList.size() + "");
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.headlineitem, null);
            viewholder = new Viewholder();
            viewholder.imageView = (ImageView) convertView.findViewById(R.id.headline_image);
            viewholder.textv = (TextView) convertView.findViewById(R.id.headline_textview);
            viewholder.textv1 = (TextView) convertView.findViewById(R.id.headline_textview2);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();

        }
        viewholder.textv.setText(arrayList.get(position).getTitle());
        viewholder.textv1.setText(arrayList.get(position).getDescription());
        if (!arrayList.get(position).getThumb().isEmpty()) {
            Glide.with(context).load(arrayList.get(position).getThumb()).into(viewholder.imageView);
        } else {
            viewholder.imageView.setImageResource(R.drawable.a);
        }

        return convertView;
    }

    class Viewholder {
        ImageView imageView;
        TextView textv;
        TextView textv1;
    }
}
