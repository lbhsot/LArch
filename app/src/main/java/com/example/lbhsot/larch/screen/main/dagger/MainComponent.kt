package com.example.lbhsot.larch.screen.main.dagger

import com.example.lbhsot.larch.application.builder.AppComponent
import com.example.lbhsot.larch.screen.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lbhsot on 2017/7/26.
 * 注入器
 * 相当于连接Module与注入对象
 */
@MainScope
@Component( dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}