package com.rxt.retrofit;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 生成OkHttpClient
 * Created by raoxuting on 2017/9/18.
 */

public class OkHttpUtils {

    private static OkHttpUtils mInstance;

    private OkHttpUtils() {}

    public static OkHttpUtils getInstance() {
        if (mInstance == null) {
            mInstance = new OkHttpUtils();
        }
        return mInstance;
    }

    private OkHttpClient client;

    public OkHttpClient obtainOkHttpClient() {
        if (client == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder()
                    .addNetworkInterceptor(loggingInterceptor)
//                    .addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request orginalRequest = chain.request();
//                    String headers = orginalRequest.headers().toString();
//                    Log.e("拦截器", "intercept: " + headers);
//                    Log.e("请求体", orginalRequest.body().contentLength()
//                            + "******" + orginalRequest.body().contentType());
//                    return chain.proceed(orginalRequest);
//                }
//            })
                    .build();
        }
        return client;
    }

    public class HttpLogger implements HttpLoggingInterceptor.Logger {

        @Override
        public void log(String message) {
            Log.e("网络日志打印", "log: " + message);
        }
    }
}
