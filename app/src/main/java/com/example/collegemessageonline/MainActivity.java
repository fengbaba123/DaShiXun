package com.example.collegemessageonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.collegemessageonline.Controller.Activity.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

import cn.smssdk.EventHandler;

public class MainActivity extends AppCompatActivity {


    private EventHandler eventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                timer.cancel();
                finish();
            }
        };
        timer.schedule(timerTask, 2000, 2000);
    }
}
