package com.example.lbhsot.larch.utils.rx

import rx.Scheduler

/**
 * Created by lbhsot on 2017/7/25.
 */
interface RxSchedulers {

    fun runOnBackground(): Scheduler

    fun io(): Scheduler

    fun compute(): Scheduler

    fun androidThread(): Scheduler

    fun internet(): Scheduler

}
