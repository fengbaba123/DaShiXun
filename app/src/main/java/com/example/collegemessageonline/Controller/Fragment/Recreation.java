package com.example.collegemessageonline.Controller.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.collegemessageonline.Adapter.JiuYeAdapter;
import com.example.collegemessageonline.Model.Base.BaseFragment;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.Model.Base.RefreshLayout;
import com.example.collegemessageonline.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;

public class Recreation extends BaseFragment {

    private long plot = 0;
    private ListView recretion_listview;
    private RefreshLayout recretion_refresh;
    private RefreshLayout recretion_refresh1;
    private ArrayList<JiuYe.DataBean> arrayList;
    private ListView jiuyelistview;

    @Override
    protected void initData() throws IOException {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    final ResponseBody okhttp = Okhttp.okhttp("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&catid=5&controller=content&action=index&page=" + plot + "&time=1499742788");
                    final String string = okhttp.string();
                    Log.e("134567879456987", string);
                    Gson gson = new Gson();
                    final JiuYe jiuYe = gson.fromJson(string, JiuYe.class);
                    arrayList.addAll(jiuYe.getData());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JiuYeAdapter adapter = new JiuYeAdapter(getActivity(), arrayList);
                            jiuyelistview.setAdapter(adapter);
                        }
                    });
                    jiuyelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        recretion_refresh1 = (RefreshLayout) view.findViewById(R.id.jiuye_refresh);
        jiuyelistview = (ListView) view.findViewById(R.id.jiuye_listview);

        recretion_refresh1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {


                recretion_refresh1.postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        // 更新数据
                        arrayList.clear();
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        recretion_refresh1.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        // 加载监听器
        recretion_refresh1.setOnLoadListener(new RefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {


                recretion_refresh1.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            initData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        plot++;
                        recretion_refresh1.setLoading(false);
                    }
                }, 1500);

            }
        });


    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_recreation;
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
