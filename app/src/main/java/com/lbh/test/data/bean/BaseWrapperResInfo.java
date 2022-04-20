package com.lbh.test.data.bean;


import java.io.Serializable;


/**
 * Created by linbinghuang on 2016/4/12.
 */
public class BaseWrapperResInfo<T> implements Serializable {
    public String msg;
    public int code;
    public T data;
    public String sign;
    public int r;

    public BaseWrapperResInfo(String msg) {
        this.msg = msg;
    }

    public BaseWrapperResInfo() {
    }
}


