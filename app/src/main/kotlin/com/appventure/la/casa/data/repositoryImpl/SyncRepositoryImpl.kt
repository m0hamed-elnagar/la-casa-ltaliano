package com.appventure.la.casa.data.repositoryImpl

import PizzaSyncDelegate
import android.content.Context
import com.appventure.la.casa.data.local.datastore.AppPreferences
import com.appventure.la.casa.data.mappers.toSyncState
import com.appventure.la.casa.domain.models.SyncState
import com.appventure.la.casa.domain.models.SyncTarget
import com.appventure.la.casa.domain.repo.SyncRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SyncRepositoryImpl(val context: Context,val appPreferences: AppPreferences) : SyncRepository {
    // get the local version and  compare to choose the one to syncIfNeeded if any

    override suspend fun syncIfNeeded(target: SyncTarget, remoteVersion: Long) {
        when (target) {
            SyncTarget.PIZZAS -> {
                val localVersion = appPreferences.pizzaVersion.first()

                if (localVersion == 0L || localVersion < remoteVersion) {
                    PizzaSyncDelegate.enqueue(context, remoteVersion)
                }
            }
//            SyncTarget.SIZES -> SizeSyncDelegate.enqueue(context)
//            SyncTarget.TOPPINGS -> ToppingSyncDelegate.enqueue(context)
            else -> {}
        }
    }

    override fun observe(target: SyncTarget): Flow<SyncState> {
        when (target) {
            SyncTarget.PIZZAS -> return PizzaSyncDelegate.workInfo(context).map { infos ->
                    infos.firstOrNull()?.toSyncState() ?: SyncState.Idle
                }

            else -> {return flowOf(SyncState.Idle)}
        }

    }
}