package com.lnsantos.pet.surface

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.setupPetSurfaceBackground
import com.lnsantos.pet.surface.factory.PetSurfaceFactory

@Composable
fun PetSurface(
    modifier: Modifier = Modifier,
    style: PetStyle = PetStyle.NONE,
    background: Color? = null,
    border: Boolean = false,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .setupPetSurfaceBackground(background)
            .setupPetSurfaceStyleByType(style),
        content = content
    )
}

@Stable
private fun Modifier.setupPetSurfaceStyleByType(style: PetStyle) = then(
    PetSurfaceFactory().run { clip(clip(style = style)) }
)

@Composable
@Preview
private fun PreviewPetSurface() {
    PetSurface(
        style = PetStyle.HIGH
    ) {

    }
}
