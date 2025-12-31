package com.appventure.la.casa.app.init_app

import android.util.Log
import com.appventure.la.casa.BuildConfig
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object RemoteConfigManager {

    private val _isWorking = MutableStateFlow(true)
    val isWorking: StateFlow<Boolean> = _isWorking.asStateFlow()

    fun init() {
        val rc = Firebase.remoteConfig

        rc.setConfigSettingsAsync(
            remoteConfigSettings {
                minimumFetchIntervalInSeconds =
                    if (BuildConfig.DEBUG) 0 else 3600
            }
        )

        rc.setDefaultsAsync(
            mapOf("isWorking" to true)
        )

        // Real-time updates
        rc.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(update: ConfigUpdate) {
                if ("isWorking" in update.updatedKeys) {
                    rc.activate().addOnCompleteListener { publish() }
                }
            }

            override fun onError(e: FirebaseRemoteConfigException) {
                Log.e("RC", "Listener error", e)
            }
        })

        // Cold start fetch
        rc.fetchAndActivate().addOnCompleteListener { publish() }
    }

    private fun publish() {
        val value = Firebase.remoteConfig.getBoolean("isWorking")
        _isWorking.value = value
        Log.d("RC", "activated isWorking=$value")
    }
}
