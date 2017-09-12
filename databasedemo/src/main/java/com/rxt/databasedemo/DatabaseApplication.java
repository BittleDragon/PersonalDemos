package com.rxt.databasedemo;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by raoxuting on 2017/7/10.
 */

public class DatabaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
