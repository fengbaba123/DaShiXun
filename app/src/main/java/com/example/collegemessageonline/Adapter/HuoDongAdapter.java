package com.example.collegemessageonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Controller.ShiTi.HuoDongShiTi;
import com.example.collegemessageonline.R;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class HuoDongAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HuoDongShiTi.DataBean> arrayList;

    public HuoDongAdapter(Context context, ArrayList<HuoDongShiTi.DataBean> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.huodongitem, null);
            viewholder = new Viewholder();
            viewholder.imageView= (ImageView) convertView.findViewById(R.id.huodongimage);
            viewholder.title= (TextView) convertView.findViewById(R.id.huodong_title);
            viewholder.provide= (TextView) convertView.findViewById(R.id.huodong_provide);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.title.setText(arrayList.get(position).getTitle());
        viewholder.provide.setText(arrayList.get(position).getDescription());
        if (!arrayList.get(position).getThumb().isEmpty()){
            Glide.with(context).load(arrayList.get(position).getThumb()).into(viewholder.imageView);
        } else {
            viewholder.imageView.setImageResource(R.drawable.a);
        }
        return convertView;
    }

    class Viewholder {
        ImageView imageView;
        TextView title;
        TextView provide;
    }
}


