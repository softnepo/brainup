package com.lnsantos.brainup.feature.gateway

import android.content.res.Resources
import com.lnsantos.brainup.R
import javax.inject.Inject

class GatewayUIRule @Inject constructor(
    private val resources: Resources
) {

    operator fun invoke(result: Result<Unit>) : GatewayState {

        val (description, next) = when(result.exceptionOrNull() != null) {
            true -> resources.getString(R.string.gateway_description_error) to false
            else -> null to true
        }

        return GatewayState(isLoading = false, failed = description, next = next)
    }
}
