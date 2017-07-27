package com.example.lbhsot.larch.base.rx

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by lbhsot on 2017/7/26.
 */
fun Subscription.addTo(compositeSubscription: CompositeSubscription) {
    compositeSubscription.add(this)
}