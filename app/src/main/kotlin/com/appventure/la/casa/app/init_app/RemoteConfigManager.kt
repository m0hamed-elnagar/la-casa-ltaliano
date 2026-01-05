package com.appventure.la.casa.app.init_app

import android.util.Log
import com.google.firebase.BuildConfig
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
    private const val KEY_PIZZA_VERSION = "pizza_v"
    private const val KEY_IS_WORKING = "isWorking"
    private val _isWorking = MutableStateFlow(true)
    val isWorking: StateFlow<Boolean> = _isWorking.asStateFlow()
    private val _pizzaVersion = MutableStateFlow<Long?>(null)
    val pizzaVersionRemote: StateFlow<Long?> = _pizzaVersion.asStateFlow()

    fun init() {
        val rc = Firebase.remoteConfig

        rc.setConfigSettingsAsync(
            remoteConfigSettings {
                minimumFetchIntervalInSeconds = if (BuildConfig.DEBUG) 0 else 3600
            }
        )

        rc.setDefaultsAsync(
            mapOf(KEY_IS_WORKING to true)
        )

        // Real-time updates
        rc.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(update: ConfigUpdate) {
                if (KEY_PIZZA_VERSION in update.updatedKeys || KEY_IS_WORKING in update.updatedKeys) {
                    rc.activate().addOnCompleteListener {
                        publish()
                    }
                }
            }

            override fun onError(e: FirebaseRemoteConfigException) {
                Log.e("RC", "Listener error", e)
            }
        })

        // Cold start fetch
        rc.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                publish()
            } else {
                Log.e("RC", "Fetch failed", task.exception)
            }
        }
    }

    private fun publish() {
        val rc = Firebase.remoteConfig

        // Always update isWorking (can use default)
        _isWorking.value = rc.getBoolean(KEY_IS_WORKING)

        // Only update pizzaVersion if remote fetch succeeded
        if (rc.getString(KEY_PIZZA_VERSION).isNotEmpty()) {
            _pizzaVersion.value = rc.getLong(KEY_PIZZA_VERSION)
        }

        Log.d("RC", "published isWorking=${_isWorking.value}, pizzaVersion=${_pizzaVersion.value}")
    }
}