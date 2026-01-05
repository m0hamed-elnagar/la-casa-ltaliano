package com.appventure.la.casa.domain.use_cases.sync

import com.appventure.la.casa.domain.models.SyncTarget
import com.appventure.la.casa.domain.repo.SyncRepository

class SyncTargetIfNeededUseCase (
    private val syncRepository: SyncRepository
){
    suspend operator fun invoke(target: SyncTarget,remoteVersion: Long) =
        syncRepository.syncIfNeeded(target,remoteVersion)

}