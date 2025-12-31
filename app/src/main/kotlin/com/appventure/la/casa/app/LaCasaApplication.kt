package com.appventure.la.casa.app

import android.app.Application
import com.appventure.la.casa.app.init_app.AppInitializer
import com.appventure.la.casa.di.initKoin
import org.koin.android.ext.koin.androidContext

class LaCasaApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        // App init orchestration
        AppInitializer.init(this)
        // DI
        initKoin { androidContext(this@LaCasaApplication)}
    }
}