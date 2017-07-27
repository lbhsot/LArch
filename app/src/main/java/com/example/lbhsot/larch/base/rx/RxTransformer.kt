package com.example.lbhsot.larch.base.rx

import com.example.lbhsot.larch.application.Config
import com.example.lbhsot.larch.exception.RetryWithDelay
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lbhsot on 2017/7/26.
 */
class RxTransformer {

    companion object {
        fun <T> swichSchedulers(): Observable.Transformer<T, T> {
            return Observable.Transformer<T, T> { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
        }

        /**
         * 需要重试时compse(retryTransformer())
         * @param mMaxRetries 重试次数
         * @param mRetryDelay 重试延迟
         * @param <T>
         * @return</T>
         * */
        fun <T> retryTransformer(mMaxRetries: Int, mRetryDelay: Int): Observable.Transformer<T, T> {
            return Observable.Transformer<T, T> { tObservable -> tObservable.retryWhen(RetryWithDelay(mMaxRetries, mRetryDelay)) }
        }

        fun <T> observeTransformer(onErrorResumeNext: () -> Unit, doOnNext: () -> Unit, doOnSubscribe: () -> Unit, doWhenException : (e: Throwable) -> Unit, addSubscriber : (sub: Subscription) -> Unit): Observable.Transformer<T, T> {
            return Observable.Transformer<T, T> { observable ->
                observable
                        .compose(swichSchedulers<T>())
                        .onErrorResumeNext { throwable ->
                            if (Config.DEBUG)
                                throwable.printStackTrace()
                            onErrorResumeNext()
                            Observable.error<T>(throwable)
                        }
                        .doOnNext { doOnNext() }
                        .doOnSubscribe { doOnSubscribe() }
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .lift { subscriber ->
                            val sub = object : RxSubscriber<T>() {
                                override fun onNext(response: T) {
                                    subscriber.onNext(response)
                                }

                                override fun onError(e: Throwable) {
                                    super.onError(e)
                                    subscriber.onError(e)
                                    doWhenException(e)
                                }

                                override fun onCompleted() {
                                    super.onCompleted()
                                    subscriber.onCompleted()
                                }
                            }
                            addSubscriber(sub)
                            return@lift sub
                        }
            }
        }
    }
}