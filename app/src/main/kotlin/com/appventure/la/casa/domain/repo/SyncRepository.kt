package com.appventure.la.casa.domain.repo

import com.appventure.la.casa.domain.models.SyncState
import com.appventure.la.casa.domain.models.SyncTarget
import kotlinx.coroutines.flow.Flow

interface SyncRepository {
    suspend fun syncIfNeeded(target: SyncTarget, remoteVersion: Long)
    fun observe(target: SyncTarget): Flow<SyncState>
}