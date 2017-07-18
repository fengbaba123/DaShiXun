package com.example.collegemessageonline.Controller.Activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.Model.Base.Okhttp;
import com.example.collegemessageonline.R;

import java.io.IOException;

import okhttp3.ResponseBody;

public class RegisterActivity extends BaseActivity {

    private EditText pnumber;
    private String phonenumber;

    @Override
    protected void initData() {


    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {
        pnumber = (EditText) findViewById(R.id.phonenumber);

        findViewById(R.id.back_registe).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,VerifyActivity.class);
                startActivity(intent);
           register();
            }
        });
    }

    private void register() {
        new  Thread(){
            @Override
            public void run() {
                super.run();
                phonenumber = pnumber.getText().toString().trim();
                try {
                    final ResponseBody okhttp = Okhttp.okhttp("http://uzone.univs.cn/validMobile.action?app=mobile&type=mobile&mobile=" + phonenumber);
                    final String string = okhttp.toString();
                    Log.e("TAG------------",string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }
}
