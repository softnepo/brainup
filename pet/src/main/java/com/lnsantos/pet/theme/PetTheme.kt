package com.lnsantos.pet.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.lnsantos.pet.core.PetValues

@Composable
fun PetTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
        colorScheme = PetValues.Colors.getColorsByScheme(isDarkMode),
        typography = PetValues.Typographies.typography
    )
}