package com.lnsantos.pet.text.factory

import androidx.compose.runtime.Composable
import com.lnsantos.pet.text.model.PetTextStyle
import com.lnsantos.pet.text.model.TextStyleModel
import com.lnsantos.pet.text.factory.strategy.PetTextDescriptionStyle
import com.lnsantos.pet.text.factory.strategy.PetTextSubtitleStyle
import com.lnsantos.pet.text.factory.strategy.PetTextTitleStyle

internal class PetTextStyleFactory {
    @Composable
    operator fun invoke(type: PetTextStyle) : TextStyleModel = when(type) {
        PetTextStyle.TITLE -> PetTextTitleStyle.build()
        PetTextStyle.SUBTITLE -> PetTextSubtitleStyle.build()
        PetTextStyle.DESCRIPTION -> PetTextDescriptionStyle.build()
    }
}
