package com.example.lbhsot.larch.application.builder

import com.example.lbhsot.larch.api.GithubApi
import com.example.lbhsot.larch.api.HeroApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by lbhsot on 2017/7/25.
 */
@Module
class ArchApiServiceModule {


    @AppScope
    @Provides
    internal fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJavaCallAdapterFactory): HeroApi {
        val retrofit = Retrofit.Builder().client(client)
                .baseUrl(MAVEL_BASE_URL).addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()

        return retrofit.create(HeroApi::class.java)
    }

    @AppScope
    @Provides
    internal fun provideGithubApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJavaCallAdapterFactory): GithubApi {
        val retrofit = Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()

        return retrofit.create<GithubApi>(GithubApi::class.java)
    }

    companion object {
        private val BASE_URL = "https://api.github.com/"
        private val MAVEL_BASE_URL = "http://coemygroup.fr/"
    }


}
