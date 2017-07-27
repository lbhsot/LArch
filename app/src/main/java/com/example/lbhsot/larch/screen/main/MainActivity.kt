package com.example.lbhsot.larch.screen.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lbhsot.larch.application.LArchApp
import com.example.lbhsot.larch.screen.main.core.MainPresenter
import com.example.lbhsot.larch.screen.main.core.MainView
import com.example.lbhsot.larch.screen.main.dagger.DaggerMainComponent
import com.example.lbhsot.larch.screen.main.dagger.MainModule
import javax.inject.Inject

/**
 * Created by lbhsot on 2017/7/26.
 * 需要注入什么就@Inject什么，在kotlin中需要使用lateinit
 */
class MainActivity : AppCompatActivity() {

    @Inject lateinit var mPresenter: MainPresenter

    @Inject lateinit var mView: MainView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder().appComponent(LArchApp.instance().appComponent).mainModule(MainModule(this)).build().inject(this)
        setContentView(mView.view())
    }


    override fun onResume() {
        super.onResume()
        mPresenter.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

}