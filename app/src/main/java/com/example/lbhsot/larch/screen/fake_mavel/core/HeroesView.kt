package com.example.lbhsot.larch.screen.fake_mavel.core

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.lbhsot.larch.R
import com.example.lbhsot.larch.models.Hero
import com.example.lbhsot.larch.screen.fake_mavel.HeroesListActivity
import com.example.lbhsot.larch.screen.fake_mavel.list.HeroesAdapter
import rx.Observable
import java.util.ArrayList

/**
 * Created by lbhsot on 2017/7/27.
 */

class HeroesView(context: HeroesListActivity) {

    //    @BindView(R.id.activity_heroes_list_recycleview)
    var list: RecyclerView

    var view: View

    var adapter: HeroesAdapter

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_heroes_list, parent, true)
        //        ButterKnife.bind(this, view);
        list = view.findViewById<View>(R.id.activity_heroes_list_recycleview) as RecyclerView

        adapter = HeroesAdapter()

        list.adapter = adapter
        val mLayoutManager = LinearLayoutManager(context)
        list.layoutManager = mLayoutManager
    }

    fun itemClicks(): Observable<Int> {
        return adapter.observeClicks()
    }

    fun view(): View {
        return view
    }

    fun swapAdapter(heroes: ArrayList<Hero>) {
        adapter.swapAdapter(heroes)
    }

}
