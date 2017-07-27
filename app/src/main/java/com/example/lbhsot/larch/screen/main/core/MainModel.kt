package com.example.lbhsot.larch.screen.main.core

import android.content.Context
import com.example.lbhsot.larch.api.GithubApi
import com.example.lbhsot.larch.models.GithubUser
import com.example.lbhsot.larch.utils.NetworkUtils
import rx.Observable

/**
 * Created by lbhsot on 2017/7/26.
 */
class MainModel(val context: Context, val api: GithubApi) {
    fun getGitUserData() : Observable<GithubUser> {
        return api.getGithubUser("lbhsot")
    }

    val isNetworkAvailable: Observable<Boolean>
        get() = NetworkUtils.isNetworkAvailableObservable(context)

}