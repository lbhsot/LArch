package com.example.lbhsot.larch.screen.main.dagger

import com.example.lbhsot.larch.api.GithubApi
import com.example.lbhsot.larch.application.LArchApp
import com.example.lbhsot.larch.screen.main.MainActivity
import com.example.lbhsot.larch.screen.main.core.MainModel
import com.example.lbhsot.larch.screen.main.core.MainPresenter
import com.example.lbhsot.larch.screen.main.core.MainView
import com.example.lbhsot.larch.screen.main.core.MainViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by lbhsot on 2017/7/26.
 * 在Module中  需要什么就provides什么
 * Scope管理作用域
 */
@Module
class MainModule(internal val mContext: MainActivity) {

    @MainScope
    @Provides
    fun provideView(): MainView{
        return MainView(mContext)
    }

    @MainScope
    @Provides
    fun providePresenter(viewModel: MainViewModel, model: MainModel): MainPresenter {
        return MainPresenter(model, viewModel)
    }

    @MainScope
    @Provides
    fun provideContext(): MainActivity {
        return mContext
    }

    @MainScope
    @Provides
    fun provideModel(api: GithubApi): MainModel {
        return MainModel(mContext, api)
    }

    @MainScope
    @Provides
    fun provideViewModel(): MainViewModel{
        return MainViewModel(LArchApp.instance())
    }
}