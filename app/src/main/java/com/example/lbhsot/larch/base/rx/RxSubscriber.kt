package com.example.lbhsot.larch.base.rx

import rx.Subscriber

/**
 * Created by lbhsot on 2017/7/26.
 */
abstract class RxSubscriber<T> : Subscriber<T>() {
    override fun onCompleted() {

    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }

    abstract override fun onNext(response: T)

    override fun onStart() {
        super.onStart()
    }
}