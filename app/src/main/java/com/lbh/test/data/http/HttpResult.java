package com.lbh.test.data.http;


import com.lbh.test.data.bean.BaseWrapperResInfo;

import io.reactivex.functions.Function;

/**
 * @Author: 林炳煌
 * @CreateDate: 2020/5/22 03:26
 * @Description: 错误统一处理
 */
public class HttpResult<T> implements Function<BaseWrapperResInfo<T>, T> {

    @Override
    public T apply(BaseWrapperResInfo<T> tBaseResultWrapper) throws Exception {
        if (tBaseResultWrapper.code == 0) {
            if (tBaseResultWrapper.data == null) {
                tBaseResultWrapper.data = (T) new Object();
            }
            return tBaseResultWrapper.data;
        }
        throw new HttpError(tBaseResultWrapper);

    }


}
