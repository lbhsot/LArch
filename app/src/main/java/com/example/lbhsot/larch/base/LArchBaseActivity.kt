package com.example.lbhsot.larch.base

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.view.View
import com.example.lbhsot.larch.base.core.view.BaseViewImpl

/**
 * Created by lbhsot on 2017/7/28.
 */
open abstract class LArchBaseActivity: LifecycleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBaseView = BaseViewImpl(this)
        setContentView(mBaseView.root())
        initDagger()
        bindView()
        mBaseView.parent().addView(getView())
    }

    abstract fun initDagger()

    abstract fun bindView()

    abstract fun getView() : View
}