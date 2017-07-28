package com.example.lbhsot.larch.screen.main.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.lbhsot.larch.R
import com.example.lbhsot.larch.base.core.view.BaseViewImpl
import com.example.lbhsot.larch.models.GithubUser
import com.example.lbhsot.larch.screen.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by lbhsot on 2017/7/26.
 */
class MainView(context: MainActivity) :BaseViewImpl(context),  MainContract.View{

    override fun setText(str: String) {
        context.tv_main.text = str
    }

    private var view: View = LayoutInflater.from(context).inflate(R.layout.activity_main, null)

    fun view(): View {
        view.findViewById<TextView>(R.id.tv_main).text = "view()"
        return view
    }
}