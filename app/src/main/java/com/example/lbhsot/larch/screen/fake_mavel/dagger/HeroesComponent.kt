package com.example.lbhsot.larch.screen.fake_mavel.dagger

import com.example.lbhsot.larch.application.builder.AppComponent
import com.example.lbhsot.larch.screen.fake_mavel.HeroesListActivity
import dagger.Component

/**
 * Created by lbhsot on 2017/7/27.
 */

@HeroesScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(HerosModule::class))
interface HeroesComponent {
    fun inject(heroesActivity: HeroesListActivity)
}
