package com.lnsantos.pet.text.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

internal data class TextStyleModel(
    val fontFamily: FontFamily,
    val fontWeight: FontWeight,
    val fontSize: TextUnit,
    val color: Color
)