package com.example.lbhsot.larch.utils.rx

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by lbhsot on 2017/7/25.
 */
class AppRxSchedulers : RxSchedulers {

    override fun runOnBackground(): Scheduler {
        return BACKGROUND_SCHEDULERS
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun compute(): Scheduler {
        return Schedulers.computation()
    }

    override fun androidThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun internet(): Scheduler {
        return INTERNET_SCHEDULERS
    }

    companion object {

        var backgroundExecutor: Executor = Executors.newCachedThreadPool()
        var BACKGROUND_SCHEDULERS = Schedulers.from(backgroundExecutor)
        var internetExecutor: Executor = Executors.newCachedThreadPool()
        var INTERNET_SCHEDULERS = Schedulers.from(internetExecutor)
    }
}
