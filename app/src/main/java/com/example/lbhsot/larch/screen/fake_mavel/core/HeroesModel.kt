package com.example.lbhsot.larch.screen.fake_mavel.core

import com.example.lbhsot.larch.api.HeroApi
import com.example.lbhsot.larch.models.Hero
import com.example.lbhsot.larch.models.Heroes
import com.example.lbhsot.larch.screen.fake_mavel.HeroesListActivity
import com.example.lbhsot.larch.utils.NetworkUtils
import rx.Observable

/**
 * Created by lbhsot on 2017/7/27.
 */

class HeroesModel(internal var context: HeroesListActivity, internal var api: HeroApi) {


    fun provideListHeroes(): Observable<Heroes> {
        return api.heroes
    }

    val isNetworkAvailable: Observable<Boolean>
        get() = NetworkUtils.isNetworkAvailableObservable(context)


    fun gotoHeroDetailsActivity(hero: Hero) {
        context.goToHeroDetailsActivity(hero)
    }


}
