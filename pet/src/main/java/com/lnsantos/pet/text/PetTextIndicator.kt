package com.lnsantos.pet.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.lnsantos.pet.circle.PetCircle
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun PetTextIndicator(
    modifier: Modifier = Modifier,
    type: PetTextStyle = PetTextStyle.TITLE,
    text: String,
    textColor: Color? = null,
    onClick: () -> Unit = {}
) {
    val sizeCircleByTypeText = when(type) {
        PetTextStyle.TITLE -> PetValues.Spacing.High.div(2)
        PetTextStyle.SUBTITLE -> PetValues.Spacing.Medium.div(1.5f)
        else -> PetValues.Spacing.Low.div(1.2f)
    }

    Row(
        modifier = modifier.clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PetCircle(size = sizeCircleByTypeText)
        PetText(text = text, type = type, textColor = textColor)
    }
}

@Composable
@Preview
private fun PreviewPetTextIndicator() {
    PetTextIndicator(
        text = "Abcde blasdasdasdasdasdasd",
        type = PetTextStyle.DESCRIPTION
    )
}