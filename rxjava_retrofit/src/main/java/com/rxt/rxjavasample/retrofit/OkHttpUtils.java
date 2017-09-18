package com.rxt.rxjavasample.retrofit;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * 生成OkHttpClient
 * Created by raoxuting on 2017/9/18.
 */

public class OkHttpUtils {

    private static OkHttpClient client;

    public static OkHttpClient obtainOkHttpClient(String token) {
        if (client == null) {
            client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    String headers = chain.request().headers().toString();
                    Log.e("拦截器", "intercept: " + headers);
                    return chain.proceed(chain.request());
                }
            }).build();
        }
        return client;
    }
}
