package com.lnsantos.brainup.foundation.navigation

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import com.lnsantos.brainup.feature.gateway.GatewayActivity
import com.lnsantos.brainup.feature.home.HomeActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

const val KEY_PROFILE_ID = "KEY_EXTRA_PROFILE_ID"

class RouterIntent @Inject constructor(
    @ApplicationContext val application: Context
) {

    fun startGatewayActivity() {
        val intent = Intent(application, GatewayActivity::class.java).applySettings()
        application.startActivity(intent)
    }

    fun startHomeActivity(
        profileId: Long?
    ) {
        val intent = Intent(application, HomeActivity::class.java)
            .apply { putExtra(KEY_PROFILE_ID, profileId) }
            .applySettings()

        application.startActivity(intent)
    }

    private fun Intent.applySettings() = apply {
        flags = FLAG_ACTIVITY_CLEAR_TOP or FLAG_ACTIVITY_NEW_TASK
        setPackage(application.packageName)
    }
}