package com.example.collegemessageonline.Controller.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.collegemessageonline.Model.Base.BaseActivity;
import com.example.collegemessageonline.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class DiSanFangLogin extends BaseActivity {


    private UMAuthListener umAuthListener;
    private UMShareAPI umShareAPI;

    @Override
    protected void initData() {
        umAuthListener = new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //授权开始的回调
            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
            }
        };
        //用初始化好的友盟对象调用验证方法
    }

    @Override
    protected void onClick() {
        findViewById(R.id.qq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI.get(DiSanFangLogin.this).doOauthVerify(DiSanFangLogin.this, SHARE_MEDIA.QQ, umAuthListener);
            }
        });
        findViewById(R.id.weibo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI.get(DiSanFangLogin.this).doOauthVerify(DiSanFangLogin.this, SHARE_MEDIA.SINA, umAuthListener);
            }
        });
        findViewById(R.id.xue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiSanFangLogin.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initId() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_di_san_fang_login;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
