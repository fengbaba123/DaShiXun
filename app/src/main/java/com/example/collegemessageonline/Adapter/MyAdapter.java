package com.example.collegemessageonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Controller.ShiTi.Bean;
import com.example.collegemessageonline.R;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class MyAdapter extends BaseAdapter {

    private ArrayList<Bean.DataBean> list;
    private Context context;

    public MyAdapter(Context context, ArrayList<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem, null);
            viewholder = new Viewholder();
            viewholder.textView = (TextView) convertView.findViewById(R.id.title);
            viewholder.textView2 = (TextView) convertView.findViewById(R.id.provide);
            viewholder.imageView= (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.textView.setText(list.get(position).getTitle());
        viewholder.textView2.setText(list.get(position).getDescription());
        Glide.with(context).load(list.get(position).getThumb()).into(viewholder.imageView);
        return convertView;
    }

    class Viewholder {
        ImageView imageView;
        TextView textView;
        TextView textView2;
    }
}


