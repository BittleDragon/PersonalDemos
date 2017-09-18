package com.rxt.rxjavasample.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.annotations.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 自定义gsonConverterFactory
 * Created by raoxuting on 2017/9/18.
 */

public class MyGsonConverterFactory extends Converter.Factory {

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return super.responseBodyConverter(type, annotations, retrofit);
    }
}
