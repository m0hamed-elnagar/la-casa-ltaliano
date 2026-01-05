package com.appventure.la.casa.data.work_manager

import android.util.Log
import androidx.work.Configuration
import androidx.work.WorkerFactory

object WorkManagerConfig {

    fun build(
        workerFactory: WorkerFactory
    ): Configuration =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)          // <- needed for DI
            .setMinimumLoggingLevel(Log.DEBUG)        // optional
            .build()
}