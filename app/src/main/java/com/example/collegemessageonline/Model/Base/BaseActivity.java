package com.example.collegemessageonline.Model.Base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.collegemessageonline.global.MyApp;

/**
 * Created by 陆向阳 on 2017/7/10.
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(getLayout());
        MyApp.mBaseActivity = this;
        initId();
        onClick();
        initData();
    }

    protected abstract void initData();

    protected abstract void onClick();

    protected abstract void initId();

    protected abstract int getLayout();

    @Override
    protected void onResume() {
        super.onResume();
        MyApp.mBaseActivity = this;
    }
}
