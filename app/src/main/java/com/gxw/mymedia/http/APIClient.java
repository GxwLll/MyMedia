package com.gxw.mymedia.http;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * 网络请求
 * Created by Administrator on 2017/4/26 0026.
 */

public class APIClient {

    /**
     * post
     * @param mobile
     * @param password
     * @param callback
     */
    public static void postLogin(String mobile, String password, HttpManager.HttpCallback callback){

        RequestBody  requestBody = new FormBody.Builder().add("mobile",mobile).add("password",password).build();

        HttpManager.post("/appmanager/login",requestBody,callback);
    }

    /**
     * get
     * @param mobile
     * @param password
     * @param callback
     */
    public static void getLogin(String mobile, String password, HttpManager.HttpCallback callback){

        HttpManager.get("/appmanager/login",callback);
    }
}
