package com.lbh.test.data.http.converter;


import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


/**
 * Created by linbinghuang on 2016/11/12.
 *
 */
public class HttpNoJsonConverterFactory extends Converter.Factory {

    public static HttpNoJsonConverterFactory create() {
        return new HttpNoJsonConverterFactory();
    }


    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new HttpNoJsonConverter<>(type);
    }


}