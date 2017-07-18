package com.example.collegemessageonline.Controller.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.collegemessageonline.R;

public class Xiangqing extends AppCompatActivity {
    private final static String DAY = "day";
    private final static String NIGHT = "night";

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            idd = intent.getStringExtra("idd");
            Log.e("ASTSGFDGSDFgsd", idd);
        }
    };
    private WebView web;
    private String idd;
    private TextView myView;
    private WindowManager mWindowManager;
    private SharedPreferences sharedPreferences;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        moshi();
        registerReceiver(broadcastReceiver, new IntentFilter("abc"));
        web = (WebView) findViewById(R.id.webview);

        web.loadUrl("http://m.univs.cn/article/" + idd);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    private void moshi() {
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        sharedPreferences = getSharedPreferences("skinchange", MODE_PRIVATE);
        string = sharedPreferences.getString("skin", DAY);
        Log.e("sahdjklf", string);
        if (string.equals(NIGHT)) {
            night();
        } else {
            day();
        }
    }

    public void night() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.BOTTOM;
        params.y = 10;
        if (myView == null) {
            myView = new TextView(this);
            myView.setBackgroundColor(0x80000000);
        }
        mWindowManager.addView(myView, params);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("skin", NIGHT);
        edit.commit();
    }

    public void day() {
        if (myView != null) {
            mWindowManager.removeView(myView);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("skin", DAY);
            edit.commit();
        }
    }
}
