package com.example.lbhsot.larch.screen.main.core

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

/**
 * Created by lbhsot on 2017/7/27.
 */
class MainViewModel(val app: Application) : AndroidViewModel(app) {
    var text = object: MutableLiveData<String>(){}
    var str = "init"
}