package com.lnsantos.pet.surface.factory

import androidx.compose.ui.unit.Dp
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.surface.factory.strategy.clip.PetSurfaceHighClip
import com.lnsantos.pet.surface.factory.strategy.clip.PetSurfaceLowClip
import com.lnsantos.pet.surface.factory.strategy.clip.PetSurfaceMediumClip
import com.lnsantos.pet.surface.factory.strategy.clip.PetSurfaceNoneClip

internal class PetSurfaceFactory {

    fun clip(style: PetStyle) = when(style) {
        PetStyle.NONE -> PetSurfaceNoneClip().create()
        PetStyle.LOW -> PetSurfaceLowClip().create()
        PetStyle.MEDIUM -> PetSurfaceMediumClip().create()
        PetStyle.HIGH -> PetSurfaceHighClip().create()
    }

    fun size(style: PetStyle) = when (style) {
        PetStyle.NONE -> Dp(0f)
        PetStyle.LOW -> Dp(PetValues.SizeValues.x1.toFloat())
        PetStyle.MEDIUM -> Dp(PetValues.SizeValues.x2.toFloat())
        PetStyle.HIGH -> Dp(PetValues.SizeValues.x3.toFloat())
    }
}
