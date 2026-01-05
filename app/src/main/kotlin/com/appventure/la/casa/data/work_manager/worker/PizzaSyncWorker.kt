package com.appventure.la.casa.data.work_manager.worker

import PizzaSyncDelegate.KEY_REMOTE_VERSION
import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.appventure.la.casa.data.local.datastore.AppPreferences
import com.appventure.la.casa.domain.repo.PizzaRepository
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.io.IOException
import org.koin.java.KoinJavaComponent.getKoin
import kotlin.coroutines.cancellation.CancellationException

class PizzaSyncWorker(
    ctx: Context,
    params: WorkerParameters,
) : CoroutineWorker(ctx, params) {
    private val repo: PizzaRepository by lazy { getKoin().get<PizzaRepository>() }
    private val appPreferences: AppPreferences by lazy {
        getKoin().get<AppPreferences>()
    }

    override suspend fun doWork(): Result {
        Log.d("PizzaWorker", "Worker starting, isStopped=$isStopped")
        val remoteVersion = inputData.getLong(
            KEY_REMOTE_VERSION,
            -1L
        )

        if (remoteVersion <= 0) {
            return Result.failure()
        }
        return runCatching {
            repo.syncPizzas()
            appPreferences.setPizzaVersion(remoteVersion) // ✅ AFTER success
        }
            .onFailure { e -> Log.e("PizzaWorker", "Exception caught", e) }
            .fold(
                onSuccess = { Result.success() },
                onFailure = { e ->
                    Log.e("PizzaWorker", "Exception: ${e.message}")
                    FirebaseCrashlytics.getInstance().recordException(e)

                    when (e) {
                        is IOException -> Result.retry()
                        is CancellationException -> throw e                         // mandatory: do not swallow cancellation
                        else -> Result.failure(
                            workDataOf("error_message" to (e.message ?: "Sync error"))
                        )
                    }
                }
            )
    }
}
