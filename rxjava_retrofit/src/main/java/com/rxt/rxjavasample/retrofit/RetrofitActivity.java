package com.rxt.rxjavasample.retrofit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rxt.rxjavasample.R;
import com.rxt.rxjavasample.ToastUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit测试
 * Created by raoxuting on 2017/9/14.
 */

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "RetrofitActivity";
    private int page = 1;
    private ApiStore apiStore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Button test = (Button) findViewById(R.id.btn_get);
        Button post = (Button) findViewById(R.id.btn_post);
        Button login = (Button) findViewById(R.id.btn_login);
        test.setOnClickListener(this);
        post.setOnClickListener(this);
        login.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiStore.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiStore = retrofit.create(ApiStore.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                getTest();
                break;
            case R.id.btn_post:
                postTest();
                break;
            case R.id.btn_login:
                login();
//                ToastUtils.show(this, "登录");
                break;
        }
    }

    private void login() {
        Call<ResponseBody> loginCall = apiStore.getUserInfo("hzcm", "123123");
        loginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body().string();
                        Log.e(TAG, "onResponse: 登录：" + s);
                        LoginData loginData = parseJson2Bean(s, LoginData.class);
                        if (loginData.getErrorCode() > 0) {
                            ToastUtils.show(RetrofitActivity.this, "登录成功");
                            SharedPreferences sp = getSharedPreferences("appsp", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putInt("userid", loginData.getUser().getTPIUserId());
                            editor.putString("token", loginData.getUser().getTicketToken());
                            editor.apply();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void postTest() {
        SharedPreferences sp = getSharedPreferences("appsp", MODE_PRIVATE);
        int userid = sp.getInt("userid", 0);
        String token = sp.getString("token", null);
        if (userid != 0 && token != null) {

        }
    }

    private void getTest() {
        /*
          无参数
         */
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiStore.baseUrl)
//                .build();
//        ApiStore apiStore = retrofit.create(ApiStore.class);
//        Call<ResponseBody> call = apiStore.getHomeData();
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse
//                    (@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
//                try {
//                    if (response.isSuccessful()) {
//                        String s = response.body().string();
//                        Log.e(TAG, "onResponse: successful: " + s);
//                    }else {
//                        String s = response.errorBody().string();
//                        Log.e(TAG, "onResponse: error: " + s);
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
////                String result = null;
////                try {
////                    result = "message: " + response.message() + "** toString: " + response.toString()
////                            + "** errorBody: " + response.errorBody().string() + "** headers: " + response.headers()
////                            .toString() + "** isSuccessful: " + response.isSuccessful();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////                Log.e("response各项信息", result);
////                Log.e(TAG, "onResponse: code: " + response.code());
////                if (response.body() != null) {
////                    String s = response.body().toString();
////                    Log.e(TAG, "onResponse: " + s);
////                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
//                Log.e(TAG, "onFailure: " + t.getMessage());
//            }
//        });

        /*
        有参数
         */
//        Call<ResponseBody> solutionsCall = apiStore.getSolutions(page++);
//        solutionsCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    if (response.isSuccessful()) {
//                        String result = response.body().string();
//                        Log.e(TAG, "onResponse: successful: " + result);
//                    } else {
//                        String error = response.errorBody().string();
//                        Log.e(TAG, "onResponse: error: " + error);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        /*
        使用gsonConverter解析json数据
         */
        Retrofit retro = new Retrofit.Builder()
                .baseUrl("http://wthrcdn.etouch.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiStore apis = retro.create(ApiStore.class);
        Call<AreaJsonBean> weatherCall = apis.getWeather("杭州");
        weatherCall.enqueue(new Callback<AreaJsonBean>() {
            @Override
            public void onResponse(Call<AreaJsonBean> call, Response<AreaJsonBean> response) {
                Log.e(TAG, "onResponse: 执行了");
                if (response.isSuccessful()) {
                    AreaJsonBean body = response.body();
                    String city = body.getData().getCity();
                    Log.e(TAG, "onResponse: " + city);
                }
            }

            @Override
            public void onFailure(Call<AreaJsonBean> call, Throwable t) {
                Log.e(TAG, "onFailure: 执行了");
            }
        });


    }

    public <T> T parseJson2Bean(String json, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new GsonBuilder().create();
            t = gson.fromJson(json, cls);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

}
