package com.lnsantos.pet.surface

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.PetValues.Colors.getColorsByScheme
import com.lnsantos.pet.core.border.Disabled
import com.lnsantos.pet.core.border.Enabled
import com.lnsantos.pet.core.border.PetBorder
import com.lnsantos.pet.surface.factory.PetSurfaceFactory

@Composable
fun PetSurface(
    modifier: Modifier = Modifier,
    style: PetStyle = PetStyle.NONE,
    background: Color? = null,
    border: PetBorder = Disabled,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .setupPetBorder(
                setting = border,
                style = style,
                defaultColor = getColorsByScheme(isDarkTheme).secondary
            )
            .setupPetSurfaceStyleByType(style)
            .setupPaddingByContentInsideBorder(style, border),
        color = background ?: getColorsByScheme(isDarkTheme).background,
        content = content
    )
}

@Stable
private fun Modifier.setupPaddingByContentInsideBorder(
    style: PetStyle,
    border: PetBorder
) : Modifier {
    val factory = PetSurfaceFactory()
    return then(if (border == Disabled) this else Modifier.padding(factory.size(style)))
}

@Stable
private fun Modifier.setupPetSurfaceStyleByType(style: PetStyle) =
    then(PetSurfaceFactory().run { clip(clip(style = style)) })

@Stable
private fun Modifier.setupPetBorder(
    setting: PetBorder, style: PetStyle, defaultColor: Color
) = then(
    other = setting.createSetting(style, defaultColor) ?: this
)

private fun PetBorder.createSetting(
    style: PetStyle, defaultColor: Color
): Modifier? = run {

    val factoryClip = PetSurfaceFactory()

    when (this) {
        is Enabled -> {
            Modifier
                .border(
                    border = BorderStroke(
                        width = factoryClip.size(style),
                        color = color ?: defaultColor
                    ),
                    shape = shape ?: factoryClip.clip(style = style)
                )
        }

        is Disabled -> null
    }
}

@Composable
@Preview(
    showBackground = false
)
private fun PreviewPetSurface() {
    PetSurface(
        style = PetStyle.NONE,
        border = Enabled(),
        background = Color.White
    ) {
        Text(text = "Teste")
    }
}
