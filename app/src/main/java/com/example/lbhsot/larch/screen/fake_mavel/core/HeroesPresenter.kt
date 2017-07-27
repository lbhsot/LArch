package com.example.lbhsot.larch.screen.fake_mavel.core

import android.util.Log
import com.example.lbhsot.larch.models.Hero
import com.example.lbhsot.larch.models.Heroes
import com.example.lbhsot.larch.utils.rx.RxSchedulers
import rx.Subscription
import rx.subscriptions.CompositeSubscription
import java.util.ArrayList

/**
 * Created by lbhsot on 2017/7/27.
 */

class HeroesPresenter(internal var rxSchedulers: RxSchedulers, internal var model: HeroesModel, internal var view: HeroesView, internal var subscriptions: CompositeSubscription) {
    internal var heros = ArrayList<Hero>()

    fun onCreate() {

        Log.d("enter to presenter", "oki")
        subscriptions.add(heroesList)
        subscriptions.add(respondToClick())
    }

    fun onDestroy() {
        subscriptions.clear()
    }


    private fun respondToClick(): Subscription {
        return view.itemClicks().subscribe { integer -> model.gotoHeroDetailsActivity(heros[integer!!]) }
    }


    private // UiUtils.showSnackbar();
            // Show Snackbar can't use app
            //                    UiUtils.handleThrowable(throwable);
    val heroesList: Subscription
        get() = model.isNetworkAvailable.doOnNext { networkAvailable ->
            if (!networkAvailable) {
                Log.d("no conn", "no connexion")
            }
        }.filter { true }.flatMap<Heroes> { model.provideListHeroes() }.subscribeOn(rxSchedulers.internet()).observeOn(rxSchedulers.androidThread()).subscribe({ heroes ->
            Log.d("ok loaded", "cccc")
            view.swapAdapter(heroes.elements as ArrayList<Hero>)
            heros = heroes.elements as ArrayList<Hero>
        }
        ) { throwable -> }
}
