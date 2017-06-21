package com.gxw.mymedia.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 网络请求
 * Created by Administrator on 2017/4/26 0026.
 */

public class HttpConfig {
    private static final String BASE_URL = "http://cztest.ruiqi100.com";


    public static String getBaseUrl(String bodyurl){
        return BASE_URL+bodyurl;
    };
}
