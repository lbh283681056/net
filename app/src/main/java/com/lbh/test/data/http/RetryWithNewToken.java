package com.lbh.test.data.http;



import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * @Author: 林炳煌
 * @CreateDate: 2020/6/16 16:19
 * @Description: java类作用描述
 */
public class RetryWithNewToken implements Function<Observable<Throwable>, Observable<?>> {
    @Override
    public Observable<?> apply(Observable<Throwable> throwableObservable) {
        return throwableObservable.flatMap(new Function<Throwable, Observable<?>>() {
            @Override
            public Observable<?> apply(Throwable throwable) throws Exception {
                if (throwable instanceof HttpError) {
                    if (((HttpError) throwable).wrapper.code == 10010) {


                    }
                }
                return Observable.error(throwable);
            }
        });
    }


}
