package com.example.lbhsot.larch.utils

import android.content.Context
import android.net.ConnectivityManager
import rx.Observable

//import io.reactivex.Observable

/**
 * Created by lbhsot on 2017/7/25.
 */
class NetworkUtils {
    companion object {
        private fun isNetWorkAvailable(context: Context) : Boolean{
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        fun isNetworkAvailableObservable(context: Context) : Observable<Boolean> {
            return Observable.just(isNetWorkAvailable(context))
        }
    }
}