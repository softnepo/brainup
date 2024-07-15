package com.lnsantos.brainup.feature.deck.scenario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lnsantos.brainup.domain.entity.DeckDomain
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun DeckListScenario(
    decks: List<DeckDomain> = listOf()
) {
    LazyColumn(

    ) {

    }
}

@Composable
@Preview
private fun PreviewCard(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                PetValues.Colors.get().onPrimary,
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalArrangement = Arrangement.Center
    ) {
        PetText(
            text = "XDZXCZXCZXCZXC",
            type = PetTextStyle.DESCRIPTION,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .weight(0.7f, fill = true),
        )
        PetText(
            text = "3",
            type = PetTextStyle.TITLE,
            textAlign = TextAlign.Center,
            textColor = PetValues.Colors.get().onPrimary,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    PetValues.Colors.get().tertiary,
                    shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                )
                .padding(16.dp)
                .weight(0.3f, fill = true)
        )
    }
}