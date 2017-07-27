package com.example.lbhsot.larch.screen.fake_mavel.list

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.lbhsot.larch.R
import com.example.lbhsot.larch.models.Hero
import rx.subjects.PublishSubject

/**
 * Created by lbhsot on 2017/7/27.
 */

class HeroViewHolder(internal var view: View, clickSubject: PublishSubject<Int>) : RecyclerView.ViewHolder(view) {

    internal var imageHero: ImageView = view.findViewById<View>(R.id.item_hero_image) as ImageView
    internal var nameHero: TextView = view.findViewById<View>(R.id.item_hero_name) as TextView
    internal var dateReleaseHero: TextView = view.findViewById<View>(R.id.item_hero_year) as TextView
    internal var separatorHero: View = view.findViewById<View>(R.id.item_hero_separator)
    internal var descriptionHero: TextView = view.findViewById<View>(R.id.item_hero_text) as TextView

    init {
        //        ButterKnife.bind(this, view);
        view.setOnClickListener { v -> clickSubject.onNext(adapterPosition) }
    }

    internal fun bind(hero: Hero) {
        nameHero.text = if (TextUtils.isEmpty(hero.title)) "missing title" else hero.title
        dateReleaseHero.text = if (TextUtils.isEmpty(hero.year)) "missing year" else hero.year
        descriptionHero.text = if (TextUtils.isEmpty(hero.intro)) "missing text" else hero.intro
        separatorHero.setBackgroundColor(Color.parseColor(hero.color))
    }

}
