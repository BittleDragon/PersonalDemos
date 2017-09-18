package com.rxt.rxjavasample.retrofit;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitInterceptor implements Interceptor {

    public static final String TAG = "拦截器";

    private String token;

    public RetrofitInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        Log.e(TAG, "intercept: 请求链接：" + originalRequest.url().toString());
//        Headers newHeaders = originalRequest.headers().newBuilder()
//                .add("Authorization", "BasicAuth " + token).build();

//        Request newRequest = originalRequest.newBuilder()
                //Basic Authentication,也可用于token验证,OAuth验证
//                .headers(newHeaders)
//                .header("Authorization", "BasicAuth " + token)
//                .addHeader("Authorization", "BasicAuth " + token)
//                .build();

//        Log.e(TAG, "intercept: 处理后的请求头：" + newRequest.headers().toString());

//        Response originalResponse = chain.proceed(request);
//        Response.Builder responseBuilder =
//                //Cache control设置缓存
//                originalResponse.newBuilder().header("Cache-Control", cacheControl);

//        Request request = requestBuilder.build();


        return chain.proceed(chain.request());
    }

}