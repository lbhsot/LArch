package com.example.lbhsot.larch.screen.fake_mavel

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lbhsot.larch.application.LArchApp
import com.example.lbhsot.larch.models.Hero
import com.example.lbhsot.larch.screen.fake_mavel.core.HeroesPresenter
import com.example.lbhsot.larch.screen.fake_mavel.core.HeroesView
import com.example.lbhsot.larch.screen.fake_mavel.dagger.DaggerHeroesComponent
import com.example.lbhsot.larch.screen.fake_mavel.dagger.HerosModule
import com.example.lbhsot.larch.screen.main.MainActivity
import javax.inject.Inject

/**
 * Created by lbhsot on 2017/7/27.
 */

class HeroesListActivity: AppCompatActivity() {

    @Inject lateinit var view: HeroesView

    @Inject lateinit var presenter: HeroesPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerHeroesComponent.builder().appComponent(LArchApp.instance().appComponent).herosModule(HerosModule(this)).build().inject(this)
        setContentView(view.view())
        presenter.onCreate()
    }

    protected override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    fun goToHeroDetailsActivity(hero: Hero) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
