package com.lbh.test.data.http;


import com.lbh.test.data.bean.BaseWrapperResInfo;

/**
 * @Author: 林炳煌
 * @CreateDate: 2020/5/22 03:37
 * @Description: http错误异常
 */
public class HttpError extends Exception{
    public BaseWrapperResInfo wrapper;
    public HttpError(BaseWrapperResInfo wrapper) {
        this.wrapper = wrapper;
    }
}
