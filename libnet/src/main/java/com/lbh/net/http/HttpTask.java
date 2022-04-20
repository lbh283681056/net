package com.lbh.net.http;


import com.lbh.net.rxjava.IoMainScheduler;
import com.lbh.net.rxjava.IoScheduler;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class HttpTask {
    protected CompositeDisposable mCompositeDisposable;

    /**
     * 注册
     */
    public void subscribe() {
        mCompositeDisposable = new CompositeDisposable();
    }

    /**
     * 反注册
     */
    public void unsubscribe() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
    }

    /**
     * 开始网络任务
     *
     * @param single
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTask(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        mCompositeDisposable.add(single.compose(new IoMainScheduler<T>()).subscribe(onSuccess, onError));
    }


    /**
     * 开始网络任务
     *
     * @param single
     * @param onSuccess
     * @param onError
     * @param retry
     * @param <T>
     */
    public <T> void startTask(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError, int retry) {
        mCompositeDisposable.add(single.compose(new IoMainScheduler<T>()).retry(retry).subscribe(onSuccess, onError));
    }
    /**
     * 开始网络任务
     *
     * @param single
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTaskNoRetry(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        mCompositeDisposable.add(single.compose(new IoMainScheduler<T>()).subscribe(onSuccess, onError));
    }
    /**
     * 开始网络任务
     *
     * @param observable
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTaskNoRetry(Observable<T> observable, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        mCompositeDisposable.add(observable.compose(new IoMainScheduler<T>()).subscribe(onSuccess, onError));
    }

    /**
     * single
     *
     * @param observable
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTask(Observable<T> observable, final Consumer<? super T> onSuccess, final Consumer<? super Throwable> onError) {
        mCompositeDisposable.add(observable.compose(new IoMainScheduler<T>()).subscribe(onSuccess, onError));
    }

    /**
     * single
     *
     * @param observable
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTaskThred(Observable<T> observable, final Consumer<? super T> onSuccess, final Consumer<? super Throwable> onError) {
        mCompositeDisposable.add(observable.compose(new IoScheduler<T>()).subscribeOn(Schedulers.io()).subscribe(onSuccess, onError));
    }
    /**
     * 开始网络任务
     *
     * @param single
     * @param onSuccess
     * @param onError
     * @param retry
     * @param <T>
     */
    public <T> void startTaskThred(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError, int retry) {
        mCompositeDisposable.add(single.compose(new IoScheduler<T>()).retry(retry).subscribe(onSuccess, onError));
    }

    /**
     * 开始网络任务
     *
     * @param single
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTaskThred(Single<T> single, Consumer<? super T> onSuccess, Consumer<? super Throwable> onError) {
        mCompositeDisposable.add(single.compose(new IoScheduler<T>()).subscribe(onSuccess, onError));
    }
    /**
     * 开始网络任务
     *
     * @param observable
     * @param onSuccess
     * @param onError
     * @param <T>
     */
    public <T> void startTaskThred(Observable<T> observable, final Consumer<? super T> onSuccess, final Consumer<? super Throwable> onError, int retry) {
        mCompositeDisposable.add(observable.compose(new IoScheduler<T>()).retry(retry).subscribe(onSuccess, onError));
    }



    /**
     * 开始任务
     *
     * @param d
     * @param <T>
     */
    public <T> void startTask(Disposable d) {
        mCompositeDisposable.add(d);
    }
}
