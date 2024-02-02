package com.lnsantos.pet.surface.factory

import com.lnsantos.pet.core.PetStyle
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
}
