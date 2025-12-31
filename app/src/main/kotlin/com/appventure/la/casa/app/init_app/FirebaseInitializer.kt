package com.appventure.la.casa.app.init_app

import android.app.Application
import com.appventure.la.casa.BuildConfig
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.installations.FirebaseInstallations

object FirebaseInitializer {

    fun init(app: Application) {
        FirebaseApp.initializeApp(app)
        setupAnalytics()
        setupCrashlytics()
    }

    private fun setupAnalytics() {
        val analytics = Firebase.analytics
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, null)
        analytics.setUserProperty("build_type", BuildConfig.BUILD_TYPE)
    }

    private fun setupCrashlytics() {
        val crashlytics = FirebaseCrashlytics.getInstance()

        FirebaseInstallations.getInstance().id
            .addOnSuccessListener { fid ->
                crashlytics.setUserId(fid)
            }

        crashlytics.log("App started")
        crashlytics.setCustomKey("build_type", BuildConfig.BUILD_TYPE)
        crashlytics.setCustomKey("version", BuildConfig.VERSION_NAME)
    }
}
