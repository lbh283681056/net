package com.lbh.test.data.http;


/**
 * @Author: 林炳煌
 * @CreateDate: 2020/5/22 03:37
 * @Description: http错误异常
 */
public class HttpErrorHandler {

    public static String errorHandlerMsg(Throwable throwable) {
        if (throwable instanceof HttpError) {
            HttpError httpError = (HttpError) throwable;
            if (httpError.wrapper != null) {
                return httpError.wrapper.msg;
            }
        }
        return "";
    }
    public static HttpError errorHandler(Throwable throwable) {
        if (throwable instanceof HttpError) {
            HttpError httpError = (HttpError) throwable;
            return httpError;
        }
        return null;
    }

}
