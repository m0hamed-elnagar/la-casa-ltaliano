package com.appventure.la.casa.data.mappers

import androidx.work.WorkInfo
import com.appventure.la.casa.domain.models.SyncState

 fun WorkInfo.toSyncState(): SyncState =
    when (state) {
        WorkInfo.State.ENQUEUED,
        WorkInfo.State.RUNNING -> SyncState.Running

        WorkInfo.State.SUCCEEDED -> SyncState.Success

        WorkInfo.State.FAILED ->
            SyncState.Failed(this.outputData.getString("error_message"))

        WorkInfo.State.CANCELLED -> SyncState.Idle
        else -> SyncState.Idle
    }
