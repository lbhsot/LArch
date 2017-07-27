package com.example.lbhsot.larch.screen.main.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.lbhsot.larch.R
import com.example.lbhsot.larch.models.GithubUser
import com.example.lbhsot.larch.screen.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by lbhsot on 2017/7/26.
 */
class MainView(val context: MainActivity) : MainContract.View{

    override fun setResult(user: GithubUser) {
        text.text = "name: " + user.name + " avatar: " + user.avatar_url
    }

    private var view: View
    private var text: TextView

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, true)
        text = view.findViewById(R.id.tv_main)
    }

    override fun view(): View {
        return view
    }
}