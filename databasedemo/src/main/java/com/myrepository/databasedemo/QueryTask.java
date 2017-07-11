package com.myrepository.databasedemo;

import android.os.AsyncTask;

/**
 * asyctask
 * Created by raoxuting on 2017/7/11.
 */
public class QueryTask extends AsyncTask<String, Integer, Boolean>{

    //任务开始时执行,UI线程
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //后台线程,不可更新UI
    @Override
    protected Boolean doInBackground(String... params) {
        publishProgress(100);
        return false;
    }

    //更新进度时调用, 参数来自于publishProgress,UI线程
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //完成时调用,方法中的参数来自于doInBackground的返回值, UI线程
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
