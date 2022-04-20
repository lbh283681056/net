package com.lbh.net.rxjava;

import io.reactivex.schedulers.Schedulers;

/**
 * description:切换线程
 */
public class IoScheduler<T> extends BaseScheduler<T> {
    public IoScheduler() {
        super(Schedulers.io(), Schedulers.io());
    }
}
