package com.rxt.rxjavasample.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.annotations.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 自定义gsonConverterFactory, 上传string、responseBody转换
 * Created by raoxuting on 2017/9/18.
 */

public class MyConverterFactory extends Converter.Factory {

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type instanceof ResponseBody) {
            return null;
        }
        return new ResponseBodyConverter<>(type);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        return new RequestBodyConverter<>(type);
    }

    public class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {

        private Type type;
        private Gson gson;

        public ResponseBodyConverter(Type type) {
            this.type = type;
            gson = new GsonBuilder().create();
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            String string = value.string();
            T t = gson.fromJson(string, type);
            return t;
        }
    }

    public class RequestBodyConverter<T> implements Converter<T, RequestBody> {

        private Gson gson;

        public RequestBodyConverter(Type type) {
            gson = new GsonBuilder().create();
        }

        @Override
        public RequestBody convert(T value) throws IOException {
            if (value instanceof String) {
                return RequestBody.create(MediaType.parse("text/plain; charset=UTF-8"), (String) value);
            } else {
                String string = gson.toJson(value);
                return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), string);
            }
        }
    }
}
