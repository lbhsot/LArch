package com.example.lbhsot.larch.screen.main.core

import android.util.Log
import com.example.lbhsot.larch.base.core.presenter.BasePresenterImpl
import com.example.lbhsot.larch.base.rx.addTo
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lbhsot on 2017/7/26.
 */
class MainPresenter(val model: MainModel, val view: MainView) : BasePresenterImpl(), MainContract.Presenter{

    override fun onStart() {
        dataSub.addTo(subscriptions)
    }

    val dataSub: Subscription
        get() = model.isNetworkAvailable.doOnNext { networkAvailable ->
            if (!networkAvailable) {
                Log.d("no conn", "no connexion")
            }
        }.filter { true }.flatMap { model.getGitUserData() }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ user ->
            Log.d("ok loaded", "cccc")
            view.setResult(user)
        }
        ) { throwable -> }

}