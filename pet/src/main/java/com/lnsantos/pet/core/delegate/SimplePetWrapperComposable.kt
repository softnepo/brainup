package com.lnsantos.pet.core.delegate

import androidx.compose.runtime.Composable

interface SimplePetWrapperComposable<T> {
   @Composable
    fun create(): T
}

interface SimplePetWrapper<T> {
    fun create(): T
}
