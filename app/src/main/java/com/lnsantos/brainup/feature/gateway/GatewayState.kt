package com.lnsantos.brainup.feature.gateway

data class GatewayState(
    val isLoading : Boolean = false,
    val failed: String? = null,
    val next: Boolean = false
)
