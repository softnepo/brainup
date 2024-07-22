package com.lnsantos.brainup.feature.deck.scenario

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lnsantos.brainup.feature.deck.model.DeckUI
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun DeckListScenario(
    modifier: Modifier = Modifier,
    decks: List<DeckUI> = listOf(),
    onClickDeck: (DeckUI) -> Unit,
    onLongClick: (DeckUI) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        decks.forEachIndexed { index, deckCardUI ->
            item(key = index, contentType = deckCardUI) {
                PreviewCard(deckCardUI, onClickDeck, onLongClick)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PreviewCard(
    cardUI: DeckUI,
    onClick: (DeckUI) -> Unit,
    onLongClick: (DeckUI) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .background(
                    color = PetValues.Colors.getNegative().tertiary,
                    shape = RoundedCornerShape(8.dp)
                )
                .combinedClickable(
                    onClick = { onClick(cardUI) },
                    onLongClick = { onLongClick(cardUI) }
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            PetText(
                text = cardUI.name,
                type = PetTextStyle.DESCRIPTION,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .weight(0.7f, fill = true),
                textColor = PetValues.Colors.get().tertiary
            )
            PetText(
                text = cardUI.totalCards.toString(),
                type = PetTextStyle.TITLE,
                textAlign = TextAlign.Center,
                textColor = PetValues.Colors.get().onPrimary,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = PetValues.Colors.get().tertiary,
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                    )
                    .padding(24.dp)
                    .weight(0.3f, fill = true)
            )
        }
    }
}