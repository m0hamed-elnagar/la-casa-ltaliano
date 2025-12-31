package com.appventure.la.casa.app.init_app

import android.app.Application

object AppInitializer {
    fun init(app: Application) {
        FirebaseInitializer.init(app)
        RemoteConfigManager.init()
    }
}