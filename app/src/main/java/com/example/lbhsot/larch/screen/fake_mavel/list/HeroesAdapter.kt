package com.example.lbhsot.larch.screen.fake_mavel.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lbhsot.larch.R
import com.example.lbhsot.larch.models.Hero
import rx.Observable
import rx.subjects.PublishSubject
import java.util.ArrayList

/**
 * Created by lbhsot on 2017/7/27.
 */

class HeroesAdapter : RecyclerView.Adapter<HeroViewHolder>() {

    private val itemClicks = PublishSubject.create<Int>()
    internal var listHeroes: ArrayList<Hero>? = ArrayList()


    fun swapAdapter(heroes: ArrayList<Hero>) {
        this.listHeroes!!.clear()
        this.listHeroes!!.addAll(heroes)
        notifyDataSetChanged()
    }

    fun observeClicks(): Observable<Int> {
        return itemClicks
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view, itemClicks)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {

        val hero = listHeroes!![position]
        holder.bind(hero)

    }


    override fun getItemCount(): Int {
        if (listHeroes != null && listHeroes!!.size > 0) {
            return listHeroes!!.size
        } else {
            return 0
        }
    }
}
