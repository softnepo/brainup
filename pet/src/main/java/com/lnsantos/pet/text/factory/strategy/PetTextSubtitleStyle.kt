package com.lnsantos.pet.text.factory.strategy

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.core.delegate.SimplePetExtension
import com.lnsantos.pet.text.model.TextStyleModel

internal class PetTextSubtitleStyle  : SimplePetExtension<TextStyleModel> {
    @Composable
    override fun create() = TextStyleModel(
        fontWeight = FontWeight.SemiBold,
        fontSize = TextUnit(
            value = PetValues.SizeValues.x5.toFloat(),
            type = TextUnitType.Sp
        ),
        fontFamily = PetValues.FontFamily.default,
        color = MaterialTheme.colorScheme.primary
    )

    companion object {
        @Composable
        fun build() = PetTextSubtitleStyle().create()
    }
}
