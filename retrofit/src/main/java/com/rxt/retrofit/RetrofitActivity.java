package com.rxt.retrofit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rxt.retrofit.model.AddressBean;
import com.rxt.retrofit.model.AreaJsonBean;
import com.rxt.retrofit.model.LoginData;
import com.rxt.retrofit.model.ReleaseBean;

import org.json.JSONException;
import org.json.JSONObject;

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
    private ApiManager apiManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Button test = (Button) findViewById(R.id.btn_get);
        Button post = (Button) findViewById(R.id.btn_post);
        Button login = (Button) findViewById(R.id.btn_login);
        Button postNormal = (Button) findViewById(R.id.btn_post_normal);
        test.setOnClickListener(this);
        post.setOnClickListener(this);
        login.setOnClickListener(this);
        postNormal.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.baseUrl)
                .addConverterFactory(new MyConverterFactory())
                .client(OkHttpUtils.getInstance().obtainOkHttpClient())
//                .callFactory(OkHttpUtils.getInstance().obtainOkHttpClient())
                .build();
        apiManager = retrofit.create(ApiManager.class);
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
                break;
            case R.id.btn_post_normal:
                postTest2();
                break;
        }
    }

    /**
     * post请求体测试
     */
    private void postTest2() {
        ReleaseBean bean = new ReleaseBean();
        bean.setContactName("小乔");
        bean.setContactTel(15946365920d);
        bean.setQuestionContent("测试");

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("ContactName", "诸葛亮");
            jsonObject.put("ContactTel", "15632198706");
            jsonObject.put("QuestionContent", "测试");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<ResponseBody> releaseCall = apiManager.release(jsonObject.toString());
        releaseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e(TAG, "onResponse: ");
                try {
                    if (response.isSuccessful()) {
                        Log.e(TAG, "body: " + response.body().string());
                    } else {
                        Log.e(TAG, "出错了：errorCode: " + response.code() +
                                "\n" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: ");
            }
        });
    }

    private void login() {
        Call<LoginData> loginCall = apiManager.getUserInfo("hzcm", "123123");
        loginCall.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                if (response.isSuccessful()) {
                    LoginData body = response.body();
                    if (body.getErrorCode() > 0) {
                        ToastUtils.show(RetrofitActivity.this, "登录成功");
                        SharedPreferences sp = getSharedPreferences("appsp", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        Log.e(TAG, "userid&token: " + body.getUser().getTPIUserId() + "\n" +
                                body.getUser().getTicketToken());
                        editor.putInt("userid", body.getUser().getTPIUserId());
                        editor.putString("token", body.getUser().getTicketToken());
                        editor.apply();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     * post带请求头测试
     */
    private void postTest() {
        SharedPreferences sp = getSharedPreferences("appsp", MODE_PRIVATE);
        int userid = sp.getInt("userid", 0);
        String token = sp.getString("token", null);
        String header = "BasicAuth " + token;
        AddressBean bean = new AddressBean();
        bean.setRecipient("张飞");
        bean.setTPIUserId(68879);
        bean.setMobile(15925695081d);
        bean.setAddress("开福区");
        bean.setArea("430000, 430100");
        Log.e(TAG, "postTest: " + userid + ", " + token);
        if (userid != 0 && token != null) {
//            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(new RetrofitInterceptor(token))
//                    .build();
            Call<ResponseBody> call = apiManager.addAddress(bean, header);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        if (response.isSuccessful()) {
                            Log.e(TAG, "onResponse: " + response.body().string());
                        } else {
                            Log.e(TAG, "onResponse: code: " + response.code());
                            Log.e(TAG, "onResponse: error: " + response.errorBody().string());
                            Log.e(TAG, "onResponse: header: " + response.headers().toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, "onFailure: 执行了");
                }
            });
        }
    }

    private void getTest() {
        /*
          无参数
         */
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiManager.baseUrl)
//                .build();
//        ApiManager apiManager = retrofit.create(ApiManager.class);
//        Call<ResponseBody> call = apiManager.getHomeData();
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
//        Call<ResponseBody> solutionsCall = apiManager.getSolutions(page++);
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
        ApiManager apis = retro.create(ApiManager.class);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

}
