package com.example.lbhsot.larch.application

import android.support.multidex.MultiDexApplication
import com.example.lbhsot.larch.application.builder.AppComponent
import com.example.lbhsot.larch.application.builder.AppContextModule
import com.example.lbhsot.larch.application.builder.DaggerAppComponent
import timber.log.BuildConfig
import timber.log.Timber

/**
 * Created by lbhsot on 2017/7/25.
 */
class LArchApp : MultiDexApplication() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }

    companion object {
        private var instance: LArchApp? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initTimber()
        appComponent.inject(this)
    }

    /**
     * init log
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String, message: String, t: Throwable) {
                    //TODO  decide what to log in release version
                }
            })
        }
    }
}
