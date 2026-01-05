package com.appventure.la.casa.domain.use_cases.sync

import com.appventure.la.casa.domain.models.SyncState
import com.appventure.la.casa.domain.models.SyncTarget
import com.appventure.la.casa.domain.repo.SyncRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class ObserveTargetUseCase(
    private val syncRepository: SyncRepository
) {
    operator fun invoke(target: SyncTarget): Flow<SyncState> =
        syncRepository.observe(target)
            .distinctUntilChanged()
}