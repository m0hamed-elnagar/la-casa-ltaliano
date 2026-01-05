package com.appventure.la.casa.data.work_manager.delegate

import android.content.Context
import androidx.lifecycle.asFlow
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.appventure.la.casa.data.work_manager.worker.PizzaSyncWorker
import kotlinx.coroutines.flow.Flow

// data/src/main/java/data/PizzaSyncDelegate.kt
internal object PizzaSyncDelegate {          // INTERNAL -> invisible outside data
    private const val PIZZA_WORK_NAME = "pizza_sync"

    fun enqueue(context: Context) {
        val req = OneTimeWorkRequestBuilder<PizzaSyncWorker>()
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()
        WorkManager.getInstance(context)
            .enqueueUniqueWork(PIZZA_WORK_NAME, ExistingWorkPolicy.KEEP, req)
    }

    fun workInfo(context: Context): Flow<List<WorkInfo>> =
        WorkManager.getInstance(context)
            .getWorkInfosForUniqueWorkLiveData(PIZZA_WORK_NAME)
            .asFlow()
}