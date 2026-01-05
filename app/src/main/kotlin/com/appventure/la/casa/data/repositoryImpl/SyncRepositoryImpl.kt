package com.appventure.la.casa.data.repositoryImpl

import android.content.Context
import com.appventure.la.casa.data.mappers.toSyncState
import com.appventure.la.casa.data.work_manager.delegate.PizzaSyncDelegate
import com.appventure.la.casa.domain.models.SyncState
import com.appventure.la.casa.domain.models.SyncTarget
import com.appventure.la.casa.domain.repo.SyncRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SyncRepositoryImpl(val context: Context) : SyncRepository {
    override suspend fun sync(target: SyncTarget) {
        when (target) {
            SyncTarget.PIZZAS -> PizzaSyncDelegate.enqueue(context)
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