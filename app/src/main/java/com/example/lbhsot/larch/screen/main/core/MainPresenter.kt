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
class MainPresenter(val model: MainModel, val viewModel: MainViewModel) : BasePresenterImpl(), MainContract.Presenter{

    override fun onStart() {
        dataSub.addTo(subscriptions)
    }

    val dataSub: Subscription
        get() = model.getGitUserData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ user ->
            Log.d("ok loaded", "cccc")
            viewModel.text.value = "name: " + user.name + " avatar: " + user.avatar_url
//            viewModel.str = "i am growt!"
        }
        ) { throwable -> }

}