package com.lbh.test.data.http.converter;


import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * Created by linbinghuang on 2016/11/12.
 * 获取qq
 */
public class HttpNoJsonConverter<T> implements Converter<ResponseBody, T> {

    private Type type;

    public HttpNoJsonConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String tempStr = bufferedSource.readUtf8();
        bufferedSource.close();
        return (T) tempStr;
    }

}
