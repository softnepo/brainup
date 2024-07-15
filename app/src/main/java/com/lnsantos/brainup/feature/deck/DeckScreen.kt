package com.lnsantos.brainup.feature.deck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lnsantos.brainup.R
import com.lnsantos.brainup.feature.deck.scenario.DeckEmptyScenario
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetTextIndicator
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun DeckScreen(
    viewModel: DeckViewModel = hiltViewModel<DeckViewModel>()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PetValues.Colors.get().onPrimary)
    ) {
        PetTextIndicator(
            text = stringResource(id = R.string.deck_screen_header),
            type = PetTextStyle.TITLE,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
        )

        DeckEmptyScenario { }
    }
}
