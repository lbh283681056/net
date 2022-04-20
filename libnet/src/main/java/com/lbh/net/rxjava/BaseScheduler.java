package com.lbh.net.rxjava;

import org.reactivestreams.Publisher;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;

/**
 * description:消息总线
 */
public abstract class BaseScheduler<T> implements ObservableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer, FlowableTransformer<T, T> {
    private Scheduler mSubscribeOnScheduler;
    private Scheduler mObserveOnScheduler;
    public BaseScheduler(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        this.mObserveOnScheduler=observeOnScheduler;
        this.mSubscribeOnScheduler=subscribeOnScheduler;
    }
    @Override
    public CompletableSource apply(Completable upstream) {
        return upstream.subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler);
    }

    @Override
    public MaybeSource<T> apply(Maybe<T> upstream) {
        return upstream.subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler);
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler);
    }

    @Override
    public Publisher<T> apply(Flowable<T> upstream) {
        return upstream.subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler);
    }

    @Override
    public SingleSource<T> apply(Single<T> upstream) {
        return upstream.subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler);
    }
}
