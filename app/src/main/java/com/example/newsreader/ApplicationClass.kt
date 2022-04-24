package com.example.newsreader

import android.app.Application
import com.example.newsreader.di.networkingModule
import com.example.newsreader.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ApplicationClass)
            androidLogger(Level.ERROR)

            modules(networkingModule + viewModelModule)
        }
    }
}