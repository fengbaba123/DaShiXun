package com.example.collegemessageonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Controller.ShiTi.KeTangShiTi;
import com.example.collegemessageonline.R;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class KeTangAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<KeTangShiTi.DataBean> arraylist;

    public KeTangAdapter(Context context, ArrayList<KeTangShiTi.DataBean> arrayList) {
        this.context = context;
        this.arraylist = arrayList;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ketangitem, null);
            viewholder=new Viewholder();
            viewholder.image= (ImageView) convertView.findViewById(R.id.ketangimage);
            viewholder.title= (TextView) convertView.findViewById(R.id.ketang_title);
            viewholder.describe= (TextView) convertView.findViewById(R.id.ketang_provide);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.title.setText(arraylist.get(position).getTitle());
        viewholder.describe.setText(arraylist.get(position).getDescription());
        if (!arraylist.get(position).getThumb().isEmpty()){
            Glide.with(context).load(arraylist.get(position).getThumb()).into(viewholder.image);
        } else {
            viewholder.image.setImageResource(R.drawable.a);
        }
        return convertView;
    }
    class Viewholder{
        ImageView image;
        TextView title;
        TextView describe;
    }
}

