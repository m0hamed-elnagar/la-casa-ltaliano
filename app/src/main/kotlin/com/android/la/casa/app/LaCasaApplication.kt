package com.android.la.casa.app

import android.app.Application
import com.android.la.casa.di.initKoin
import org.koin.android.ext.koin.androidContext

class LaCasaApplication  : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin { androidContext(this@LaCasaApplication)}
    }
}