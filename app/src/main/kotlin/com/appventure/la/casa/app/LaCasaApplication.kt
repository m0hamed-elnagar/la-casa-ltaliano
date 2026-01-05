package com.appventure.la.casa.app

import android.app.Application
import androidx.work.WorkManager
import com.appventure.la.casa.app.init_app.AppInitializer
import com.appventure.la.casa.data.work_manager.WorkManagerConfig
import com.appventure.la.casa.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.factory.KoinWorkerFactory

class LaCasaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // App init orchestration
        AppInitializer.init(this)
        // DI
        initKoin { androidContext(this@LaCasaApplication) }
        val cfg = WorkManagerConfig.build(KoinWorkerFactory())
        WorkManager.initialize(this, cfg)

    }
}
