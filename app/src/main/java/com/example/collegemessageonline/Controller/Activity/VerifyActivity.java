package com.example.collegemessageonline.Controller.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.R;

import java.util.Timer;
import java.util.TimerTask;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class VerifyActivity extends BaseActivity {
    int i = 60;
    private ImageView back_register;
    private TextView qiehuan;
    private EditText phone;
    private EditText edit_yanzheng;
    private Button yanzhengma;
    private String phonenumber;
    private EventHandler eventHandler;
    private TextView queding;
    private String edit_yanzheng1;
    private Timer timer;
    private TimerTask timerTask;


    @Override
    protected void initData() {
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                switch (event) {
                    case SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE:
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(VerifyActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(VerifyActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                }
                            });

                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(VerifyActivity.this, "验证失败", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                        break;
                    case SMSSDK.EVENT_GET_VERIFICATION_CODE:
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(VerifyActivity.this, "获取验证成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(VerifyActivity.this, "获取验证失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        break;
                }
            }
        };
        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);
        back_register = (ImageView) findViewById(R.id.back_register);
        back_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        queding = (TextView) findViewById(R.id.queding);
        edit_yanzheng = (EditText) findViewById(R.id.edit_yanzheng);
        phone = (EditText) findViewById(R.id.phone);

        yanzhengma = (Button) findViewById(R.id.yanzhengma);

        yanzhengma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonenumber = phone.getText().toString().trim();
//                SMSSDK.getVerificationCode("86", phonenumber);
                timer = new Timer();
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                yanzhengma.setText(i + "s");
                                if (i > 0) {
                                    i--;
                                    yanzhengma.setText(i + "s");
                                    yanzhengma.setTextColor(Color.GRAY);
                                    yanzhengma.setClickable(false);
                                }else{
                                    yanzhengma.setText("重新获取验证码");
                                    yanzhengma.setTextColor(Color.BLACK);
                                    timer.cancel();
                                    yanzhengma.setClickable(true);
                                    i=61;
                                }

                            }
                        });
                    }
                };
                timer.schedule(timerTask, 1000, 1000);
            }

        });
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonenumber = phone.getText().toString().trim();
                edit_yanzheng1 = VerifyActivity.this.edit_yanzheng.getText().toString().trim();
                SMSSDK.submitVerificationCode("86", phonenumber, edit_yanzheng1);
            }
        });

    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void initId() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_verify;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
