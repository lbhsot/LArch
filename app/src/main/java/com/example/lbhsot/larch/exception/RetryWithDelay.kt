package com.example.lbhsot.larch.exception

import com.example.lbhsot.larch.application.Config
import rx.Observable
import rx.functions.Func1
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by lbhsot on 2017/7/26.
 */

class RetryWithDelay(private val mMaxRetries: Int, private val mRetryMillis: Int) : Func1<Observable<out Throwable>, Observable<*>> {
    private var mRetryCount = 0

    override fun call(attempts: Observable<out Throwable>): Observable<*> {
        return attempts
                .flatMap(Func1<Throwable, Observable<*>> { throwable ->
                    if (mRetryCount < mMaxRetries) {
                        // When this Observable calls onNext, the original Observable will be retried (i.e. re-subscribed).
                        if (Config.DEBUG)
                            Timber.d("get error, it will try after " + mRetryMillis
                                    + " millisecond, retry count " + mRetryCount)
                        mRetryCount++
                        return@Func1 Observable.timer(mRetryMillis.toLong(),
                                TimeUnit.MILLISECONDS)
                    }
                    // Max retries hit. Just pass the error along.
                    Observable.error<Any>(throwable)
                })
    }
}
