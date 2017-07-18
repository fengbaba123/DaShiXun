package com.example.collegemessageonline.Controller.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.collegemessageonline.Circleimageview.CircleImageView;
import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.collegemessageonline.R.id.account;
import static com.example.collegemessageonline.R.id.school;

public class OnlyOne extends BaseActivity {


    private TextView usernametext;
    private TextView accounttext;
    private TextView schooltext;
    private CircleImageView circle;
    private EditText edit;
    private Button zhuxiao;
    private ImageView duihao;
    private TextView renzheng;

    @Override
    protected void initData() {
        SharedPreferences sharedPreferences = getSharedPreferences("msg", MODE_PRIVATE);
        final boolean state = sharedPreferences.getBoolean("state", false);
        final String username1 = sharedPreferences.getString("username", null);
        final String school = sharedPreferences.getString("school", null);
        final String account = sharedPreferences.getString("account", null);
        final String touxiang = sharedPreferences.getString("touxiang", null);
        int code = 1;
        if (code == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        zhuxiao = (Button) findViewById(R.id.zhuxiao);
        duihao = (ImageView) findViewById(R.id.duihao);
        renzheng = (TextView) findViewById(R.id.renzheng);
        if (state) {
            duihao.setVisibility(View.VISIBLE);
            zhuxiao.setVisibility(View.VISIBLE);
            renzheng.setVisibility(View.VISIBLE);
            Glide.with(this).load(touxiang).into(circle);
            usernametext.setText(username1);
            accounttext.setText(account);
            schooltext.setText(school);
            zhuxiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edit.putBoolean("state", false);
                    edit.commit();
                    zhuxiao.setVisibility(View.GONE);
                    finish();
                }
            });

        } else {
            zhuxiao.setVisibility(View.GONE);
            renzheng.setVisibility(View.GONE);
            zhuxiao.setVisibility(View.GONE);
            duihao.setVisibility(View.GONE);
        }


    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {
        circle = (CircleImageView) findViewById(R.id.circleimageview);
        usernametext = (TextView) findViewById(R.id.username_only);
        accounttext = (TextView) findViewById(account);
        schooltext = (TextView) findViewById(school);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlyOne.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.safe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlyOne.this, Safe.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.school_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlyOne.this, Schoolmsg.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlyOne.this, Seeting.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.fankui).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(OnlyOne.this).create();
                View view = LayoutInflater.from(OnlyOne.this).inflate(R.layout.fankui, null);
                alertDialog.setView(view);
                alertDialog.show();
//                http://mapi.univs.cn/mobile/index.php?app=mobile&controller=index&action=feedback
//
//                app	mobile
//                type	mobile
//                app	mobile
//                userauth	2d2114e35d3dc49699de81c1525aadaf（用户自己的）
//                controller	index
//                app_version	2.0.2 版本号
//                system_version	23
//                action	feedback
//                content	反馈的信息
//                email	用户邮箱地址

                edit = (EditText) alertDialog.getWindow().findViewById(R.id.edit);
                alertDialog.getWindow().findViewById(R.id.sure_fankui).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String string = edit.getText().toString();
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                OkHttpClient okHttpClient = new OkHttpClient();
                                RequestBody requestBody = new FormBody.Builder().add("userauth", "lxy971106")
                                        .add("controller", "0")
                                        .add("app_version", "1.0.1")
                                        .add("content", string)
                                        .add("email", "2512420282@qq.com").build();
                                Request request = new Request.Builder().post(requestBody).url("http://mapi.univs.cn/mobile/index.php?app=mobile&controller=index&action=feedback")
                                        .build();
                                okHttpClient.newCall(request).enqueue(new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(OnlyOne.this, "反馈失败", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(OnlyOne.this, "反馈成功", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });


                            }
                        }.start();


                        alertDialog.dismiss();
                    }
                });
            }
        });
        findViewById(R.id.only_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_only_one;
    }
}
