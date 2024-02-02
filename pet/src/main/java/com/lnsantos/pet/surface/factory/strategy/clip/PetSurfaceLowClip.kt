package com.lnsantos.pet.surface.factory.strategy.clip

import androidx.compose.foundation.shape.RoundedCornerShape
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.core.delegate.SimplePetWrapper

class PetSurfaceLowClip : SimplePetWrapper<RoundedCornerShape> {
    override fun create(): RoundedCornerShape {
        return RoundedCornerShape(size = PetValues.Spacing.x1)
    }
}