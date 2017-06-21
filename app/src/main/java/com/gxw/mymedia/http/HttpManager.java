package com.gxw.mymedia.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求 分发
 * Created by Administrator on 2017/4/26 0026.
 */

public class HttpManager {
    private static OkHttpClient okHttpClient;
    public static final String TAG = HttpManager.class.getSimpleName();
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    static {
        okHttpClient = new OkHttpClient();
    }

    public static void get(String bodyUrl, HttpCallback callback){
        Request request = new Request.Builder().addHeader("UserAgent","Android").url(HttpConfig.getBaseUrl(bodyUrl)).build();
        sendRequest(request,callback);
    }

    public static void post(String url,RequestBody requestBody,HttpCallback callback){
        Request request = new Request.Builder().addHeader("UserAgent","Android").url(HttpConfig.getBaseUrl(url)).post(requestBody).build();
        sendRequest(request,callback);
    }

    public static void sendRequest(Request request, final HttpCallback callback){
        Log.d(TAG,request.toString());

        String method=request.method();
        if("POST".equals(method)){
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                Log.d(TAG, "| RequestParams:{"+sb.toString()+"}");
            }
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful())
                    onSuccess(callback,response.body().string());
                else
                    onError(callback,response.message());

            }
        });
    }


    private static void onStart(HttpCallback httpCallback){
        if (httpCallback != null)
            onStart(httpCallback);
    }

    private static void onSuccess(final HttpCallback httpCallback, final String msg){
        if (httpCallback !=null){
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    httpCallback.onSuccess(msg);
                }
            });
        }
    }

    private static void onError(final HttpCallback httpCallback, final String error){
        if (httpCallback != null)
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    httpCallback.onError(error);
                }
            });
    }

    /**
     * 回调
     */
    public static abstract class HttpCallback{
        public void onStart(){}
        public abstract void onSuccess(String msg);
        public void onError(String error){}
    }

}
