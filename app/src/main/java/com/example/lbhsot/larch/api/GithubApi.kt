package com.example.lbhsot.larch.api

//import io.reactivex.Observable
import com.example.lbhsot.larch.models.GithubUser
import retrofit2.http.GET
import rx.Observable

/**
 * Created by lbhsot on 2017/7/25.
 */
interface GithubApi {
    @GET("users/{nickname}")
    fun getGithubUser(@retrofit2.http.Path("nickname") nickname: String) : Observable<GithubUser>
}