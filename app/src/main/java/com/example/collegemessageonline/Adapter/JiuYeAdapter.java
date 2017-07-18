package com.example.collegemessageonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Controller.Fragment.JiuYe;
import com.example.collegemessageonline.R;

import java.util.ArrayList;

/**
 * Created by 陆向阳 on 2017/7/12.
 */

public class JiuYeAdapter extends BaseAdapter{


    private Context context;
    private  ArrayList<JiuYe.DataBean> arrayList;

    public JiuYeAdapter(Context context, ArrayList<JiuYe.DataBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.jiuyeitem, null);
            viewholder=new Viewholder();
            viewholder.image= (ImageView) convertView.findViewById(R.id.jiuyeimage);
            viewholder.title= (TextView) convertView.findViewById(R.id.jiuye_title);
            viewholder.describe= (TextView) convertView.findViewById(R.id.jiuye_provide);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.title.setText(arrayList.get(position).getTitle());
        viewholder.describe.setText(arrayList.get(position).getDescription());
        if (!arrayList.get(position).getThumb().isEmpty()){
            Glide.with(context).load(arrayList.get(position).getThumb()).into(viewholder.image);
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

