package com.rxt.rxjavasample.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiStore {
    //http://wthrcdn.etouch.cn/weather_mini?city=%E6%9D%AD%E5%B7%9E%E5%B8%82

    String baseUrl = "http://www.gtrsp.com:8081/";

    @GET("api/index/GetIndex")
    Call<ResponseBody> getHomeData();

    @GET("api/TestService/getTestServiceList")
    Call<ResponseBody> getSolutions(@Query("page")int page);

//    @POST("api/User/PostInsertAddress")
//    Call<ResponseBody> getSolutions(@Body);

    @GET("api/Login/GetLogin")
    Call<ResponseBody> getUserInfo(@Query("strUserName")String userName,
                             @Query("strPwd")String password);

    @GET("weather_mini")
    Call<AreaJsonBean> getWeather(@Query("city")String cityname);
}