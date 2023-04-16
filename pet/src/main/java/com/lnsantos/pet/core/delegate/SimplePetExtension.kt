package com.lnsantos.pet.core.delegate

import androidx.compose.runtime.Composable

interface SimplePetExtension<T> {
    @Composable
    fun create(): T
}
