package com.appventure.la.casa.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appventure.la.casa.app.init_app.RemoteConfigManager
import com.appventure.la.casa.data.local.datastore.AppPreferences
import com.appventure.la.casa.domain.models.SyncState
import com.appventure.la.casa.domain.models.SyncTarget
import com.appventure.la.casa.domain.use_cases.sync.ObserveTargetUseCase
import com.appventure.la.casa.domain.use_cases.sync.SyncTargetIfNeededUseCase
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeVM(
    private val syncUseCase: SyncTargetIfNeededUseCase,
    private val observePizzasUseCase: ObserveTargetUseCase,
    private val appPreferences: AppPreferences
) : ViewModel() {

    init {
        // Trigger the syncIfNeeded (fire-and-forget)
        viewModelScope.launch {
                RemoteConfigManager.pizzaVersionRemote
                    .filterNotNull()
                    .distinctUntilChanged()
                    .collect { remoteVersion ->
                        val localVersion = appPreferences.pizzaVersion.first()
                        if (localVersion == 0L || localVersion < remoteVersion) {
                            syncUseCase(SyncTarget.PIZZAS, remoteVersion)
                        } else {
                            Log.d("HomeVM", "Versions match ($localVersion), nothing to do.")
                        }
                    }


//            syncUseCase(SyncTarget.PIZZAS)
//             writeSamplePizzasToFirestore()

        }

        // Observe state continuously
        observePizzasUseCase(SyncTarget.PIZZAS)
            .onEach { state ->
                when (state) {
                    is SyncState.Idle -> Log.d("HomeVM", "Nothing is happening")
                    is SyncState.Running -> Log.d("HomeVM", "Sync running...")
                    is SyncState.Success -> Log.d("HomeVM", "Sync finished ✅")
                    is SyncState.Failed -> Log.d("HomeVM", "Sync failed : ${state.msg}")
                }
            }.launchIn(viewModelScope) // non-blocking
    }
}