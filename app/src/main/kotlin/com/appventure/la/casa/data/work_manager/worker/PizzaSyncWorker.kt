package com.appventure.la.casa.data.work_manager.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
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

    override suspend fun doWork(): Result {
        Log.d("PizzaWorker", "Worker starting, isStopped=$isStopped")

        return runCatching { repo.syncPizzas() }
            .onFailure { e -> Log.e("PizzaWorker", "Exception caught", e) }
            .fold(
                onSuccess = { Result.success() },
                onFailure = { e ->
                    Log.e("PizzaWorker", "Exception: ${e.message}")
                    FirebaseCrashlytics.getInstance().recordException(e)
                    val errorData = workDataOf(
                        "error_message" to (e.message ?: "Unknown sync error")
                    )
                    when (e) {
                        is IOException -> Result.retry()
                        is CancellationException ->            throw e                         // mandatory: do not swallow cancellation
                        else -> Result.failure(errorData)
                    }
                }
            )
    }
}
