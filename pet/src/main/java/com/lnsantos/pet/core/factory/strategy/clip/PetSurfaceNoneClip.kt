package com.lnsantos.pet.core.factory.strategy.clip

import androidx.compose.foundation.shape.RoundedCornerShape
import com.lnsantos.pet.core.delegate.SimplePetWrapper

internal class PetSurfaceNoneClip : SimplePetWrapper<RoundedCornerShape> {
    override fun create(): RoundedCornerShape {
        return RoundedCornerShape(
            topStartPercent = 0,
            topEndPercent = 0,
            bottomEndPercent = 0,
            bottomStartPercent = 0
        )
    }
}
