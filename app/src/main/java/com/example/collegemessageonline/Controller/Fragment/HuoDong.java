package com.example.collegemessageonline.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.collegemessageonline.Adapter.HuoDongAdapter;
import com.example.collegemessageonline.Controller.ShiTi.HuoDongShiTi;
import com.example.collegemessageonline.Model.Base.BaseFragment;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.Model.Base.RefreshLayout;
import com.example.collegemessageonline.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;

public class HuoDong extends BaseFragment {

    private RefreshLayout recretion_refresh1;
    private RefreshLayout hupdongRefresh;
    private ListView huodonglistview;
    private ArrayList<HuoDongShiTi.DataBean> arrayList;
    private long plot=0;

    @Override
    protected void initData() throws IOException {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    final ResponseBody okhttp = Okhttp.okhttp("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&catid=12&controller=content&action=index&page=" + plot + "&time=1499742788");
                    final String string = okhttp.string();
                    Log.e("134567879456987", string);
                    Gson gson = new Gson();
                    final HuoDongShiTi huoDongShiTi = gson.fromJson(string, HuoDongShiTi.class);
                    arrayList.addAll(huoDongShiTi.getData());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            HuoDongAdapter adapter = new HuoDongAdapter(getActivity(), arrayList);
                            huodonglistview.setAdapter(adapter);
                        }
                    });
                    huodonglistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        hupdongRefresh = (RefreshLayout) view.findViewById(R.id.HuoDong_refresh);
        huodonglistview = (ListView) view.findViewById(R.id.HuoDong_listview);

        hupdongRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {


                hupdongRefresh.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        // 更新数据
                        arrayList.clear();
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        hupdongRefresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        // 加载监听器
        hupdongRefresh.setOnLoadListener(new RefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {


                hupdongRefresh.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        plot++;
                        hupdongRefresh.setLoading(false);
                    }
                }, 1500);

            }
        });


    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_job;
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
