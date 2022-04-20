package com.lbh.test.data.http.converter;




import com.lbh.test.data.JsonUtil;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * Created by linbinghuang on 2016/11/12.
 */
public class HttpFastResConverter<T> implements Converter<ResponseBody, T> {

    private  Type type;

    public HttpFastResConverter( Type type) {
        this.type = type;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String tempStr = bufferedSource.readUtf8();
        bufferedSource.close();
        String json = tempStr;

//        try {
//            json = SignUtil.decode(tempStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        json = URLDecoder.decode(json,"utf-8");
       ;
        T t =   JsonUtil.parseObject(json,type);
        return t;
    }

}
