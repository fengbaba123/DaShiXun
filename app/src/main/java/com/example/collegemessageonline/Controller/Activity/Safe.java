package com.example.collegemessageonline.Controller.Activity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Safe extends BaseActivity {


    private RelativeLayout safe_phone;
    private RelativeLayout safe_youxiang;
    private EditText pwd;
    private Button sure;
    private String password;
    private RelativeLayout pwd_safe;
    private TextView safe;

    @Override
    protected void initData() {
        SharedPreferences sharedPreferences = getSharedPreferences("msg", MODE_PRIVATE);
        final String userauth = sharedPreferences.getString("userauth", null);
        Log.e("tag===========",userauth);
        findViewById(R.id.safe_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (safe.getText() != null) {
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            final String string = pwd.getText().toString();
                            Log.e("TAG--------------",string);
                            OkHttpClient okHttpClient = new OkHttpClient();
                            Request request = new Request.Builder().url("http://uzone.univs.cn/appValidateUserPwd.action?app=mobile&type=mobile&userauth=" + userauth + "&pwd=" + string).build();
                            okHttpClient.newCall(request).enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Safe.this, "修改失败", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(Safe.this, "修改成功", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });


                        }
                    }.start();
                } else {
                    Toast.makeText(Safe.this, "密码为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {
        pwd_safe = (RelativeLayout) findViewById(R.id.pwd_safe);
        safe_youxiang = (RelativeLayout) findViewById(R.id.youxiang_safe);
        safe = (TextView) findViewById(R.id.safe_pwd);
        pwd_safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(Safe.this).create();
                View view = LayoutInflater.from(Safe.this).inflate(R.layout.pwd, null);
                alertDialog.setView(view);
                alertDialog.show();
                pwd = (EditText) alertDialog.getWindow().findViewById(R.id.edit_pwd);

                sure = (Button) alertDialog.getWindow().findViewById(R.id.pwd_sure);
                sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        password = pwd.getText().toString();
                        safe.setText(password);
                        safe.setVisibility(View.GONE);
                        alertDialog.dismiss();
                    }
                });
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_safe;
    }
}
