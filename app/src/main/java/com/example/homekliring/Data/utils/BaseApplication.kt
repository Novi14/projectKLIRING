package com.example.homekliring.Data.utils

import android.app.Application
import com.example.homekliring.Data.di.appModule
import org.koin.android.ext.koin.androidContext
import com.example.homekliring.Data.di.viewModelModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    appModule,
                    viewModelModule,
                )
            )
        }
    }
}