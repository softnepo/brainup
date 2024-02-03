package com.lnsantos.pet.core.factory.strategy.clip

import androidx.compose.foundation.shape.RoundedCornerShape
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.core.delegate.SimplePetWrapper

class PetSurfaceMediumClip : SimplePetWrapper<RoundedCornerShape> {
    override fun create(): RoundedCornerShape {
        return RoundedCornerShape(size = PetValues.Spacing.x2)
    }
}