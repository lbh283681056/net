package com.lbh.test.data.http.converter;



import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


/**
 * Created by linbinghuang on 2016/11/12.
 */
public class HttpFastConverterFactory extends Converter.Factory {


    public static HttpFastConverterFactory create() {
        return new HttpFastConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new HttpFastResConverter<>(type);

    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {

        return new HttpFastReqConverter<>();
    }
}