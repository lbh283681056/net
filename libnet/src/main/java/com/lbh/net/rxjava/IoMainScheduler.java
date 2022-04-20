package com.lbh.net.rxjava;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * description:切换线程
 */
public class IoMainScheduler<T> extends BaseScheduler<T> {
    public IoMainScheduler() {
        super(Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
