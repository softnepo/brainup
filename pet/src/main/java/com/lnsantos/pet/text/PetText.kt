package com.lnsantos.pet.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lnsantos.pet.text.factory.PetTextStyleFactory
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun PetText(
    modifier: Modifier = Modifier,
    text: String,
    type: PetTextStyle,
    textColor: Color? = null
) {
    val factory = PetTextStyleFactory().invoke(type)

    Text(
        modifier = modifier,
        text = text,
        fontFamily = factory.fontFamily,
        fontSize = factory.fontSize,
        fontWeight = factory.fontWeight,
        color = textColor ?: factory.color
    )
}

@Preview(name = "Pet Text")
@Composable
fun PreviewPetTextTitle() {
    PetText(
        text = "Title",
        type = PetTextStyle.TITLE
    )
}

@Preview
@Composable
fun PreviewPetTextSubtitle() {
    PetText(
        text = "Subtitle",
        type = PetTextStyle.SUBTITLE
    )
}

@Preview
@Composable
fun PreviewPetTextDescription() {
    PetText(
        text = "Subtitle",
        type = PetTextStyle.DESCRIPTION
    )
}