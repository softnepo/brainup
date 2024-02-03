package com.lnsantos.pet.core.factory

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.core.delegate.SimplePetWrapper
import com.lnsantos.pet.core.exceptions.PetStyleNotImplementedException
import com.lnsantos.pet.core.factory.strategy.clip.PetSurfaceHighClip
import com.lnsantos.pet.core.factory.strategy.clip.PetSurfaceHighXClip
import com.lnsantos.pet.core.factory.strategy.clip.PetSurfaceLowClip
import com.lnsantos.pet.core.factory.strategy.clip.PetSurfaceMediumClip
import com.lnsantos.pet.core.factory.strategy.clip.PetSurfaceNoneClip

internal class PetSurfaceFactory {

    fun clip(style: PetStyle) = when(style) {
        PetStyle.NONE -> PetSurfaceNoneClip().create()
        PetStyle.LOW -> PetSurfaceLowClip().create()
        PetStyle.MEDIUM -> PetSurfaceMediumClip().create()
        PetStyle.HIGH -> PetSurfaceHighClip().create()
        PetStyle.HIGH_X -> PetSurfaceHighXClip().create()
    }

    fun size(style: PetStyle) = when (style) {
        PetStyle.NONE -> Dp(0f)
        PetStyle.LOW -> Dp(PetValues.SizeValues.x1.toFloat())
        PetStyle.MEDIUM -> Dp(PetValues.SizeValues.x2.toFloat())
        PetStyle.HIGH -> Dp(PetValues.SizeValues.x3.toFloat())
        else -> throw PetStyleNotImplementedException(
            origin = this::class.simpleName?.plus("::size"),
            supporters = PetStyle.values().filter {
                it != PetStyle.HIGH_X
            }.toTypedArray()
        )
    }
}

@Composable
fun rememberPetStyleClip(
   context : () -> PetStyle = { PetStyle.NONE }
) : RoundedCornerShape {
    return remember { PetSurfaceFactory().clip(context()) }
}

@Composable
fun rememberPetStyleSize(
    context : () -> PetStyle = { PetStyle.NONE }
) : Dp {
    return remember { PetSurfaceFactory().size(context()) }
}