package com.example.lbhsot.larch.screen.main.core

import com.example.lbhsot.larch.base.core.presenter.IBasePresenter
import com.example.lbhsot.larch.base.core.view.IBaseView
import com.example.lbhsot.larch.models.GithubUser
import rx.Observable

/**
 * Created by lbhsot on 2017/7/26.
 */
interface MainContract {
    interface View : IBaseView{
        fun setText(str: String)
    }

    interface Presenter : IBasePresenter {

    }

    interface Model {
        fun provideData() : Observable<GithubUser>
    }
}