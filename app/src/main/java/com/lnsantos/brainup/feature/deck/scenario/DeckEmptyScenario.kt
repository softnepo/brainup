package com.lnsantos.brainup.feature.deck.scenario

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lnsantos.brainup.R
import com.lnsantos.pet.button.PetTextButton
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun DeckEmptyScenario(
    onClickCreateDeck: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PetText(
            text = stringResource(id = R.string.deck_empty_description),
            type = PetTextStyle.TITLE,
            textAlign = TextAlign.Center
        )
        PetTextButton(
            text = stringResource(id = R.string.deck_empty_button),
            textStyle = PetTextStyle.DESCRIPTION,
            modifier = Modifier.padding(top = 16.dp),
            onClick = onClickCreateDeck
        )
    }
}
