package com.example.collegemessageonline.Controller.Activity;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.collegemessageonline.Controller.ShiTi.XiaoNeiXinXi.Character;
import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

public class Schoolmsg extends BaseActivity {

    private TextView jiaoshi;
    private TextView student;
    private TextView fudaoyuan;
    private TextView text1;
    private ListView listview;
    private WindowManager.LayoutParams lp;
    private ArrayList<String> arrayList;
    private ListView lists;
    private String userid;
    private TextView yuanxi;
    private PopupWindow popupWindow;
    private TextView banji;
    private TextView nianfen;
    private TextView schooltext;
    private PopupWindow popupWindow2;
    private SharedPreferences.Editor edit;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences1;

    @Override
    protected void initData() {
        sharedPreferences1 = getSharedPreferences("user", MODE_PRIVATE);
        edit = sharedPreferences1.edit();
        final boolean state = sharedPreferences.getBoolean("state", false);
        Log.e("TAGF-------", state + "");
        if (sharedPreferences1.getAll().isEmpty()) {
            text1.setText("未设置");
            schooltext.setText("未设置");
            yuanxi.setText("未设置");
        } else {
            if (state) {
                final String ch = sharedPreferences1.getString("character", null);
                final String sc = sharedPreferences1.getString("schoolmsg", null);
                final String yx = sharedPreferences1.getString("yuanxi", null);
                Log.e("123465879awsda", ch);
                text1.setText(ch);
                schooltext.setText(sc);
                yuanxi.setText(yx);
            }
        }

    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {
        sharedPreferences = getSharedPreferences("msg", MODE_PRIVATE);
        userid = sharedPreferences.getString("userauth", null);
        text1 = (TextView) findViewById(R.id.textcharacter2);
        yuanxi = (TextView) findViewById(R.id.textview3);
        banji = (TextView) findViewById(R.id.textView2);
        nianfen = (TextView) findViewById(R.id.nianfen);
        schooltext = (TextView) findViewById(R.id.schooltext2);
        findViewById(R.id.character).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindown();

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            final ResponseBody okhttp = Okhttp.okhttp("http://uzone.univs.cn/appMetaData.action?userauth=" + userid + "&metaName=USERTYPE");
                            final String string = okhttp.string();
                            Log.e("789456123", string);
                            Gson gson = new Gson();
                            final Character character = gson.fromJson(string, Character.class);
                            final List<Character.DataBean> data = character.getData();
                            arrayList = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                arrayList.add(data.get(i).getName());
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ArrayAdapter arrayAdapter = new ArrayAdapter(Schoolmsg.this, android.R.layout.simple_dropdown_item_1line, arrayList);
                                    listview.setAdapter(arrayAdapter);
                                }
                            });
                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    if (popupWindow.isShowing()) {
                                        popupWindow.dismiss();
                                        lp.alpha = 1f;
                                        getWindow().setAttributes(lp);
                                        text1.setText(arrayList.get(position).toString());
                                    }
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }.start();
            }
        });
        findViewById(R.id.schoolmsg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindownlist();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
//                            http://uzone.univs.cn/appMetaData.action?userauth="+userid+"&metaName=SCHOOL&ownerID=2
                            final ResponseBody okhttp = Okhttp.okhttp("http://uzone.univs.cn/appMetaData.action?userauth=" + userid + "&metaName=PROVINCE");
                            final String string = okhttp.string();
                            Log.e("123456789132546", string);
                            Gson gson = new Gson();
                            final Character character = gson.fromJson(string, Character.class);
                            final List<Character.DataBean> data = character.getData();
                            arrayList = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                arrayList.add(data.get(i).getName());
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    ArrayAdapter arrayAdapter = new ArrayAdapter(Schoolmsg.this, android.R.layout.simple_dropdown_item_1line, arrayList);
                                    listview.setAdapter(arrayAdapter);
                                }
                            });
                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    ErJiList(id);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }.start();

            }
        });
        findViewById(R.id.yuanxi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindown();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            final ResponseBody okhttp = Okhttp.okhttp("http://uzone.univs.cn/appMetaData.action?userauth=" + userid + "&metaName=DEPT&ownerID=99");
                            final String string = okhttp.string();
                            Log.e("123456789132546", string);
                            Gson gson = new Gson();
                            final Character character = gson.fromJson(string, Character.class);
                            final List<Character.DataBean> data = character.getData();
                            arrayList = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                arrayList.add(data.get(i).getName());
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ArrayAdapter arrayAdapter = new ArrayAdapter(Schoolmsg.this, android.R.layout.simple_dropdown_item_1line, arrayList);
                                    listview.setAdapter(arrayAdapter);
                                }
                            });
                            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    if (popupWindow.isShowing()) {
                                        popupWindow.dismiss();
                                        lp.alpha = 1f;
                                        getWindow().setAttributes(lp);
                                        yuanxi.setText(arrayList.get(position).toString());
                                    }
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }.start();
            }
        });
        findViewById(R.id.banji).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.year).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.sure_school).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String string2 = text1.getText().toString();
                final String string1 = schooltext.getText().toString();
                final String string = yuanxi.getText().toString();
                Log.e("74128856522", string);
                edit.putString("character", string2);
                edit.putString("schoolmsg", string1);
                edit.putString("yuanxi", string);
                edit.commit();
                finish();
            }
        });
        findViewById(R.id.back_school).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void ErJiList(final long id) {
        popWindown();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
//                            http://uzone.univs.cn/appMetaData.action?userauth="+userid+"&metaName=SCHOOL&ownerID=2
                    final ResponseBody okhttp = Okhttp.okhttp("http://uzone.univs.cn/appMetaData.action?userauth=" + userid + "&metaName=SCHOOL&ownerID=" + id);
                    final String string = okhttp.string();
                    Log.e("123456789132546", string);
                    Gson gson = new Gson();
                    final Character character = gson.fromJson(string, Character.class);
                    final List<Character.DataBean> data = character.getData();
                    arrayList = new ArrayList<>();
                    for (int i = 0; i < data.size(); i++) {
                        arrayList.add(data.get(i).getName());
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ArrayAdapter arrayAdapter = new ArrayAdapter(Schoolmsg.this, android.R.layout.simple_dropdown_item_1line, arrayList);
                            listview.setAdapter(arrayAdapter);
                        }
                    });
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            popupWindow.dismiss();
                            popupWindow2.dismiss();
                            lp.alpha = 1f;
                            getWindow().setAttributes(lp);
                            schooltext.setText(arrayList.get(position).toString());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }.start();
    }

    private void popWindownlist() {
        popupWindow2 = new PopupWindow();
        View view = LayoutInflater.from(Schoolmsg.this).inflate(R.layout.popwindown, null);
        listview = (ListView) view.findViewById(R.id.listview_school);

        popupWindow2.setContentView(view);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view1 = LayoutInflater.from(Schoolmsg.this).inflate(R.layout.activity_schoolmsg, null);
        popupWindow2.showAtLocation(view1, Gravity.BOTTOM, 0, 0);
        lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
        popupWindow2.isShowing();
        popupWindow2.setOutsideTouchable(true);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow2.isShowing()) {
                    popupWindow2.dismiss();
                    lp.alpha = 1f;
                    getWindow().setAttributes(lp);
                }
            }
        });
    }

    private void popWindown() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(Schoolmsg.this).inflate(R.layout.popwindown, null);
        listview = (ListView) view.findViewById(R.id.listview_school);

        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view1 = LayoutInflater.from(Schoolmsg.this).inflate(R.layout.activity_schoolmsg, null);
        popupWindow.showAtLocation(view1, Gravity.BOTTOM, 0, 0);
        lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
        popupWindow.isShowing();
        popupWindow.setOutsideTouchable(true);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    lp.alpha = 1f;
                    getWindow().setAttributes(lp);
                }
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_schoolmsg;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}