package com.rxt.retrofit;

import com.rxt.retrofit.model.AddressBean;
import com.rxt.retrofit.model.AreaJsonBean;
import com.rxt.retrofit.model.LoginData;
import com.rxt.retrofit.model.NewsBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiManager {
    //http://wthrcdn.etouch.cn/weather_mini?city=%E6%9D%AD%E5%B7%9E%E5%B8%82

    String baseUrl = "http://www.gtrsp.com:8081/";
    String baseUrl2 = "http://gank.io/";

    @GET("api/index/GetIndex")
    Call<ResponseBody> getHomeData();

    @GET("api/TestService/getTestServiceList")
    Call<ResponseBody> getSolutions(@Query("page") int page);

    @GET("api/Login/GetLogin")
    Call<LoginData> getUserInfo(@Query("strUserName") String userName,
                                @Query("strPwd") String password);

    @GET("weather_mini")
    Call<AreaJsonBean> getWeather(@Query("city") String cityname);

    //    Call<ResponseBody> addAddress(@Header("Authorization")String header, @Body AddressBean bean);
    @POST("api/User/PostInsertAddress")
    Call<ResponseBody> addAddress(@Body AddressBean bean, @Header("Authorization") String authorization);

    @POST("api/UserQusetions/PostSaveUserQusetion")
    Call<ResponseBody> release(@Body String bean);

    @GET("api/data/{category}/{count}/{page}")
    Observable<NewsBean> getNews(@Path("category") String category,
                                 @Path("count") int count, @Path("page") int page);

}