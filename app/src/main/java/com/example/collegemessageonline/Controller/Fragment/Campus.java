package com.example.collegemessageonline.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.collegemessageonline.Adapter.MyAdapter;
import com.example.collegemessageonline.Adapter.viewPagerAdapter;
import com.example.collegemessageonline.Controller.ShiTi.Bean;
import com.example.collegemessageonline.Model.Base.BaseFragment;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.Model.Base.RefreshLayout;
import com.example.collegemessageonline.R;
import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.ResponseBody;


public class Campus extends BaseFragment implements ViewPager.OnPageChangeListener {
    int[] image={R.drawable.a,R.drawable.ac,R.drawable.aa,R.drawable.ab,R.drawable.ad};
    private ListView listview;
    private ArrayList<ImageView> mList;
    private viewPagerAdapter vpa;
    private ViewPager vp;
    private LinearLayout linearlayout;
    private Timer timer;
    private Bean bean;
    private ArrayList<Bean.DataBean> list;
    private RefreshLayout refresh;
    private int plot;
    private RollPagerView roll;

    @Override
    protected void initData() throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final ResponseBody okhttp = Okhttp.okhttp("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&catid=2&controller=content&action=index&page=" + plot + "&time=1499742788");
                    final String string = okhttp.string();
                    Gson gson = new Gson();
                    bean = gson.fromJson(string, Bean.class);
                    final List<Bean.DataBean> data = bean.getData();
                    for (int i=0;i<data.size();i++){
                        final int contentid = data.get(i).getContentid();
                        Log.e("123546798156132",contentid+"");
                    }
                    list.addAll(bean.getData());
                    Log.e("TAG--------------", string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        ArrayList<String> imageurl = new ArrayList<>();
        imageurl.add("http://upload.univs.cn/2017/0417/thumb_640_314_1492433907753.png");
        imageurl.add("http://upload.univs.cn/2016/1114/thumb_640_314_1479103823901.jpg");
        imageurl.add("http://upload.univs.cn/2017/0417/1492432153772.jpg");
        imageurl.add(" http://upload.univs.cn/2017/0417/1492432085474.png");
        imageurl.add("http://upload.univs.cn/2017/0619/1497839111813.jpg");


    }

    @Override
    protected void initView(View view) {
//        ArrayList<String> imageurl = new ArrayList<>();
//        imageurl.add("http://upload.univs.cn/2017/0417/thumb_640_314_1492433907753.png");
//        imageurl.add("http://upload.univs.cn/2016/1114/thumb_640_314_1479103823901.jpg");
//        imageurl.add("http://upload.univs.cn/2017/0417/1492432153772.jpg");
//        imageurl.add(" http://upload.univs.cn/2017/0417/1492432085474.png");
//        imageurl.add("http://upload.univs.cn/2017/0619/1497839111813.jpg");
        refresh = (RefreshLayout) view.findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {


                refresh.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // 更新数据
                        plot = 0;
                        list.clear();
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        refresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        // 加载监听器
        refresh.setOnLoadListener(new RefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {


                refresh.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        plot++;
                        refresh.setLoading(false);
                    }
                }, 1500);

            }
        });


        listview = (ListView) view.findViewById(R.id.listview);

        View item = LayoutInflater.from(getActivity()).inflate(R.layout.item, null);
        vp = (ViewPager) item.findViewById(R.id.vpager);
        linearlayout = (LinearLayout) item.findViewById(R.id.linearlayout);
        list = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(getActivity(), list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("contentid",list.get(position).getContentid()+"");
                Intent intent=new Intent(getActivity(),Xiangqing.class);
                intent.putExtra("idd",list.get(position).getContentid());
                intent.setAction("abc");
                getActivity().sendBroadcast(intent);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();

        listview.addHeaderView(item);

        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        vp.setCurrentItem(vp.getCurrentItem() + 1);
                    }
                });
            }
        }, 2000, 2000);

        initViewpager();

        initAdapter();
    }

    private void initAdapter() {
        viewPagerAdapter vpa = new viewPagerAdapter(mList);
        vp.setAdapter(vpa);
        vp.setOnPageChangeListener(this);
        vp.setCurrentItem(4333);
    }

    private void initViewpager() {
        mList = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            View view = new View(getActivity());
            view.setBackgroundResource(R.drawable.select_shape_normal);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            if (i != 0) {
                layoutParams.leftMargin = 8;
            }
            linearlayout.addView(view, layoutParams);
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(image[i]);
            mList.add(imageView);
        }
        linearlayout.getChildAt(0).setBackgroundResource(R.drawable.select_shape_focused);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_campus;
    }

    @Override
    protected void setBundle(Bundle bundle) {

    }

    @Override
    protected void onShow() {

    }

    @Override
    protected void onHidden() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int newPosition = position % mList.size();
        for (int i = 0; i < image.length; i++) {
            if (i == newPosition) {
                linearlayout.getChildAt(i).setBackgroundResource(R.drawable.select_shape_focused);
            } else {
                linearlayout.getChildAt(i).setBackgroundResource(R.drawable.select_shape_normal);
            }
        }
    }

    @Override
    public void onDestroy() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        super.onDestroy();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
