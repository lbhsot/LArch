package com.example.lbhsot.larch.application.builder

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by lbhsot on 2017/7/25.
 */
@Module
class AppContextModule(val context: Context) {

    @Provides
    @AppScope
    fun provideAppContext() : Context {
        return context
    }
}