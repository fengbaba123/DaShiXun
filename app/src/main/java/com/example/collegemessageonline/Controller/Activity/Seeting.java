package com.example.collegemessageonline.Controller.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collegemessageonline.R;

public class Seeting extends AppCompatActivity implements View.OnClickListener {
    private WindowManager mWindowManager;
    private View myView;
    private ImageView btn_dayAndnight;
    private SharedPreferences skinSp;
    private final static String DAY = "day";
    private final static String NIGHT = "night";
    private int flage = 0;
    private TextView noshitext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        setContentView(R.layout.activity_seeting);
        findViewById(R.id.back_school).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    public void init() {
        skinSp = getSharedPreferences("skinchange", MODE_PRIVATE);
        noshitext = (TextView) findViewById(R.id.moshitext);
        btn_dayAndnight = (ImageView) findViewById(R.id.moshi);
        btn_dayAndnight.setOnClickListener(this);

        String mode = skinSp.getString("skin", DAY);
        Log.e("TAG-------------", mode);
        if (mode.equals(NIGHT)) {
            night();
        } else {
            day();
        }
    }

    @Override
    public void onClick(View v) {
        if (flage % 2 == 0) {
            day();
            noshitext.setText("夜间模式");
            noshitext.setTextColor(Color.BLACK);
            flage++;
        } else {
            night();
            noshitext.setText("日间模式");
            noshitext.setTextColor(Color.BLACK);
            flage++;
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
        SharedPreferences.Editor edit = skinSp.edit();
        edit.putString("skin", NIGHT);
        edit.commit();
    }

    public void day() {
        if (myView != null) {
            mWindowManager.removeView(myView);
            SharedPreferences.Editor edit = skinSp.edit();
            edit.putString("skin", DAY);
            edit.commit();
        }
    }


    public void removeSkin() {
        if (myView != null) {
            mWindowManager.removeView(myView);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String mode = skinSp.getString("skin", DAY);
        if (mode.equals(NIGHT)) {
            removeSkin();
        }

    }
}
