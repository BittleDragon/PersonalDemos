package com.rxt.retrofit;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * 出错重试
 * Created by raoxuting on 2017/9/21.
 */

public class RetryObservable implements Function<Observable<Throwable>, ObservableSource<?>>{

    public static final String TAG = "重试";

    private long retryDelayMills;

    private int maxRetryTimes;

    private int retrytimes = 1;

    public RetryObservable(long retryDelayMills, int maxRetryTimes) {
        this.retryDelayMills = retryDelayMills;
        this.maxRetryTimes = maxRetryTimes;
    }

    @Override
    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
        return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Throwable throwable) throws Exception {
                if (retrytimes++ <= maxRetryTimes) {
                    Log.e(TAG, "apply: 在" + retryDelayMills +"毫秒后执行重试");
                    return Observable.timer(retryDelayMills, TimeUnit.MILLISECONDS);
                }
                //重试次数已达上限，直接传递错误
                return Observable.error(throwable);
            }
        });
    }
}
