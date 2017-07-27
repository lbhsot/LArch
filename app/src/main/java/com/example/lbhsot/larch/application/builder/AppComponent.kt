package com.example.lbhsot.larch.application.builder

import android.content.Context
import com.example.lbhsot.larch.api.GithubApi
import com.example.lbhsot.larch.api.HeroApi
import com.example.lbhsot.larch.application.LArchApp
import com.example.lbhsot.larch.utils.rx.RxSchedulers
import dagger.Component

/**
 * Created by lbhsot on 2017/7/25.
 */
@AppScope
@Component(modules = arrayOf(NetworkModule::class, AppContextModule::class, RxModule::class, ArchApiServiceModule::class))
interface AppComponent {
    fun getAppContext() : Context

    fun rxSchedulers() : RxSchedulers

    fun githubApiService() : GithubApi


    fun apiService(): HeroApi

    fun inject(app: LArchApp)
}