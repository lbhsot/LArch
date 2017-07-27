package com.example.lbhsot.larch.base.core.presenter

import com.example.lbhsot.larch.base.core.view.IBaseView
import com.example.lbhsot.larch.base.rx.RxTransformer
import rx.Observable
import rx.subscriptions.CompositeSubscription

/**
 * Created by lbhsot on 2017/7/26.
 */
open abstract class BasePresenterImpl: IBasePresenter {

    protected var subscriptions: CompositeSubscription = CompositeSubscription()

    override abstract fun onStart()

    override fun onDestroy() {
        subscriptions.clear()
    }
}