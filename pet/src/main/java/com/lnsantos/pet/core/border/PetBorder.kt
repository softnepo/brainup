package com.lnsantos.pet.core.border

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color

sealed interface PetBorder

data class Enabled(
    val shape: RoundedCornerShape? = null,
    val color: Color? = null
) : PetBorder

object Disabled : PetBorder
