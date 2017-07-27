package com.example.lbhsot.larch.application.builder

import android.content.Context
import com.example.lbhsot.larch.utils.rx.AppRxSchedulers
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by lbhsot on 2017/7/25.
 */
@Module
class NetworkModule {

    @AppScope
    @Provides
    internal fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {

        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(logger)
        builder.cache(cache)
        return builder.build()
    }

    @AppScope
    @Provides
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideCache(file: File): Cache {
        return Cache(file, (10 * 10 * 1000).toLong())
    }

    @AppScope
    @Provides
    internal fun provideCacheFile(context: Context): File {
        return context.filesDir
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS)
    }


    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}