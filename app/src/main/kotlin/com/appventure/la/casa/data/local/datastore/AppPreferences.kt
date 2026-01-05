package com.appventure.la.casa.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_pref")

class AppPreferences(
    private val dataStore: DataStore<Preferences>
) {

    // -------- Versions --------

    val pizzaVersion: Flow<Long> =
        dataStore.data.map { prefs ->
            prefs[PreferenceKeys.PIZZA_VERSION] ?: 0L
        }

    suspend fun setPizzaVersion(version: Long) {
        dataStore.edit { prefs ->
            prefs[PreferenceKeys.PIZZA_VERSION] = version
        }
    }


    // -------- Utilities --------

    suspend fun clearAll() {
        dataStore.edit { it.clear() }
    }
}
