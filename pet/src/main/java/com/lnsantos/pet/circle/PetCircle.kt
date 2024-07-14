package com.lnsantos.pet.circle

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.lnsantos.pet.core.PetValues

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PetCircle(
    modifier: Modifier = Modifier,
    color: Color? = null,
    size: Dp = PetValues.Spacing.High
) {
    val defaultColor = MaterialTheme.colorScheme.primary
    Canvas(
        modifier = modifier
            .size(size)
            .padding(size.div(size.value/2))
            .semantics { invisibleToUser() },
        onDraw = {
            drawCircle(
                color = color ?: defaultColor,
                alpha = 1f
            )
        }
    )
}

@Preview
@Composable
private fun PreviewPetCircle() {
    PetCircle()
}