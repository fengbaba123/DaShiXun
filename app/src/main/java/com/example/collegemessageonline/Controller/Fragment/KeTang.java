package com.example.collegemessageonline.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.collegemessageonline.Adapter.KeTangAdapter;
import com.example.collegemessageonline.Controller.ShiTi.KeTangShiTi;
import com.example.collegemessageonline.Model.Base.BaseFragment;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.Model.Base.RefreshLayout;
import com.example.collegemessageonline.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;


public class KeTang extends BaseFragment {

    private ArrayList<KeTangShiTi.DataBean> arrayList;
    private KeTangShiTi keTang;
    private RefreshLayout ketang_refresh;
    private ListView ketang_listview;
    private long plot=0;

    @Override
    protected void initData() throws IOException {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    final ResponseBody okhttp = Okhttp.okhttp("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&catid=3&controller=content&action=index&page=" + plot + "&time=1499742788");
                    final String string = okhttp.string();
                    Log.e("134567879456987", string);
                    Gson gson = new Gson();
                    keTang = gson.fromJson(string, KeTangShiTi.class);
                    arrayList.addAll(keTang.getData());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           KeTangAdapter adapter = new KeTangAdapter(getActivity(), arrayList);
                            ketang_listview.setAdapter(adapter);
                        }
                    });
                    ketang_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(getActivity(),Xiangqing.class);
                            intent.putExtra("idd",arrayList.get(position).getContentid());
                            intent.setAction("abc");
                            getActivity().sendBroadcast(intent);
                            startActivity(intent);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    @Override
    protected void initView(View view) {
        arrayList = new ArrayList<>();
        ketang_refresh = (RefreshLayout) view.findViewById(R.id.KeTang_refresh);
        ketang_listview = (ListView) view.findViewById(R.id.KeTang_listview);
        ketang_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {


                ketang_refresh.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        // 更新数据
                        arrayList.clear();
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ketang_refresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        // 加载监听器
        ketang_refresh.setOnLoadListener(new RefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {


                ketang_refresh.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        plot++;
                        ketang_refresh.setLoading(false);
                    }
                }, 1500);

            }
        });


    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_read;
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
}
