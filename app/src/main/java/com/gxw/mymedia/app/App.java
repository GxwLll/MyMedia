package com.gxw.mymedia.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.gxw.mymedia.utils.MyPerference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class App extends Application {
    private static App instance;
    private static Context context;
    private MyPerference mp;
    /**
     * Thread to execute tasks in background..
     */
    private final ExecutorService backgroundExecutor;


    public static App getInstance() {
        if (instance == null)
            throw new IllegalStateException();
        return instance;
    }

    public static Context getContext() {
        return context;
    }


    public App() {
        instance = this;
        backgroundExecutor = Executors.newFixedThreadPool(8,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable,
                                "Background executor service");
                        thread.setPriority(Thread.MIN_PRIORITY);
                        thread.setDaemon(true);
                        return thread;
                    }
                });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mp = new MyPerference(this);
        mp.setUserInfo(mp);


    }


}
