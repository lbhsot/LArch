package com.example.lbhsot.larch.base.core.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.lbhsot.larch.R

/**
 * Created by lbhsot on 2017/7/28.
 */
open class BaseViewImpl(val context: Activity) : IBaseView{
    protected var root: View = LayoutInflater.from(context).inflate(R.layout.activity_base, null)
    protected var parent: FrameLayout
    init {
        parent = root.findViewById(R.id.frame_root)
    }

    fun root() : View{
        return root
    }

    fun parent() : FrameLayout {
        return parent
    }
}