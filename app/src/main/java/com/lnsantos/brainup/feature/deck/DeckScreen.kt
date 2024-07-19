package com.lnsantos.brainup.feature.deck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lnsantos.brainup.feature.deck.model.DeckStateType
import com.lnsantos.brainup.feature.deck.scenario.DeckEmptyScenario
import com.lnsantos.brainup.feature.deck.scenario.DeckListScenario
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetTextIndicator
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun DeckScreen(
    viewModel: DeckViewModel = hiltViewModel<DeckViewModel>()
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PetValues.Colors.get().onPrimary)
    ) {
        PetTextIndicator(
            text = state.value.title,
            type = PetTextStyle.TITLE,
            isVisible = state.value.title.isNotEmpty(),
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 16.dp)
        )

        when(val data = state.value.status) {
            is DeckStateType.Loading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
            is DeckStateType.EmptyList -> DeckEmptyScenario {  }
            is DeckStateType.ListDeck -> DeckListScenario(
                decks = data.decks,
                onClickDeck = { }
            )
        }
    }
}
