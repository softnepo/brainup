package com.lnsantos.pet.core

import androidx.compose.foundation.background
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Stable
internal fun Modifier.setupPetSurfaceBackground(color: Color?) = then(
    if (color == null) this else Modifier.background(color = color)
)


