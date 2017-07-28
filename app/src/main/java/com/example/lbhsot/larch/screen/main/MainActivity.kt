package com.example.lbhsot.larch.screen.main

import android.arch.lifecycle.Observer
import android.database.Observable
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.lbhsot.larch.R
import com.example.lbhsot.larch.application.LArchApp
import com.example.lbhsot.larch.base.LArchBaseActivity
import com.example.lbhsot.larch.databinding.ActivityMainBinding
import com.example.lbhsot.larch.screen.main.core.MainPresenter
import com.example.lbhsot.larch.screen.main.core.MainView
import com.example.lbhsot.larch.screen.main.core.MainViewModel
import com.example.lbhsot.larch.screen.main.dagger.DaggerMainComponent
import com.example.lbhsot.larch.screen.main.dagger.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lbhsot on 2017/7/26.
 * 需要注入什么就@Inject什么，在kotlin中需要使用lateinit
 * databinding @={} 双向绑定不好用？why？
 * LiveData 监听数据
 */
class MainActivity : LArchBaseActivity() {

    @Inject lateinit var mPresenter: MainPresenter

    @Inject lateinit var mView: MainView

    @Inject lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
    }

    override fun initDagger() {
        DaggerMainComponent.builder().appComponent(LArchApp.instance().appComponent).mainModule(MainModule(this)).build().inject(this)
    }

    override fun bindView() {
        val binding = ActivityMainBinding.bind(mView.view())
        binding.viewModel = mViewModel
    }

    fun observeData() {
        mViewModel.text.observe(this, Observer {
            str -> mView.setText(str.toString())
        })
    }

    override fun getView(): View {
        return mView.view()
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