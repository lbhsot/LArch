package com.example.lbhsot.larch.application.builder

import com.example.lbhsot.larch.utils.rx.AppRxSchedulers
import com.example.lbhsot.larch.utils.rx.RxSchedulers
import dagger.Module
import dagger.Provides

/**
 * Created by lbhsot on 2017/7/25.
 */
@Module
class RxModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers {
        return AppRxSchedulers()
    }
}
