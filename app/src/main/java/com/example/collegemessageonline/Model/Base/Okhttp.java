package com.example.collegemessageonline.Model.Base;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * Created by 陆向阳 on 2017/7/10.
 */

public class Okhttp {
    public static ResponseBody okhttp(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        final ResponseBody string = okHttpClient.newCall(request).execute().body();
        return string;
    }
}
