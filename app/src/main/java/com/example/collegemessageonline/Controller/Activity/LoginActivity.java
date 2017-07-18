package com.example.collegemessageonline.Controller.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegemessageonline.Controller.ShiTi.LoginShiTi;
import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "简单点";
    private EditText username;
    private EditText password;
    private TextView register;
    private TextView forget;
    private TextView qiehuan;
    private String un;
    private String pwd;
    private String password1;
    private LoginShiTi loginShiTi;
    private long exitTime = 0;

    @Override
    protected void initData() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        qiehuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DiSanFangLogin.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.login_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                pwd = password.getText().toString().trim();
                un = username.getText().toString().trim();
                try {
                    final ResponseBody okhttp = Okhttp.okhttp("http://uzone.univs.cn/appUserAccountLogin.action?app=mobile&type=mobile&toUrl=&pwd=" + pwd + "&account=" + un);
                    final String string = okhttp.string();
                    Log.e("Tag--------", string);
                    Gson gson = new Gson();
                    loginShiTi = gson.fromJson(string, LoginShiTi.class);
                    SharedPreferences sharedPreferences = getSharedPreferences("msg", MODE_PRIVATE);
                    final SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("state", loginShiTi.isState());
                    edit.putString("username", loginShiTi.getData().getNickname());
                    edit.putString("school", loginShiTi.getData().getUnivname());
                    edit.putString("account", loginShiTi.getData().getEmail());
                    edit.putString("touxiang", loginShiTi.getData().getUserlogo());
                    edit.putString("userauth", loginShiTi.getData().getUserauth());
                    edit.commit();
                    if (loginShiTi.isState()) {
                        finish();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pwd);
        register = (TextView) findViewById(R.id.register);
        forget = (TextView) findViewById(R.id.forget);
        qiehuan = (TextView) findViewById(R.id.qiehuan);
        findViewById(R.id.login_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

}
