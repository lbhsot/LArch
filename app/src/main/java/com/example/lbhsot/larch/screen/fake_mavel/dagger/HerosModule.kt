package com.example.lbhsot.larch.screen.fake_mavel.dagger

import com.example.lbhsot.larch.api.HeroApi
import com.example.lbhsot.larch.screen.fake_mavel.HeroesListActivity
import com.example.lbhsot.larch.screen.fake_mavel.core.HeroesModel
import com.example.lbhsot.larch.screen.fake_mavel.core.HeroesPresenter
import com.example.lbhsot.larch.screen.fake_mavel.core.HeroesView
import com.example.lbhsot.larch.utils.rx.RxSchedulers
import dagger.Module
import dagger.Provides
import rx.subscriptions.CompositeSubscription

/**
 * Created by lbhsot on 2017/7/27.
 */

@Module
class HerosModule(internal var heroesListContext: HeroesListActivity) {


    @HeroesScope
    @Provides
    fun provideView(): HeroesView {
        return HeroesView(heroesListContext)
    }

    @HeroesScope
    @Provides
    fun providePresenter(schedulers: RxSchedulers, view: HeroesView, model: HeroesModel): HeroesPresenter {
        val subscriptions = CompositeSubscription()
        return HeroesPresenter(schedulers, model, view, subscriptions)
    }


    @HeroesScope
    @Provides
    fun provideContext(): HeroesListActivity {
        return heroesListContext
    }

    @HeroesScope
    @Provides
    fun provideModel(api: HeroApi): HeroesModel {
        return HeroesModel(heroesListContext, api)
    }
}
