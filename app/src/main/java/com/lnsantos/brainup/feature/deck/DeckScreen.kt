package com.lnsantos.brainup.feature.deck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lnsantos.brainup.R
import com.lnsantos.brainup.feature.deck.modal.SimpleModelBottomSheet
import com.lnsantos.brainup.feature.deck.modal.SimpleOption
import com.lnsantos.brainup.feature.deck.modal.SimpleOptionsBottomSheet
import com.lnsantos.brainup.feature.deck.model.DeckCardUI
import com.lnsantos.brainup.feature.deck.model.DeckStateType
import com.lnsantos.brainup.feature.deck.scenario.DeckEmptyScenario
import com.lnsantos.brainup.feature.deck.scenario.DeckListScenario
import com.lnsantos.pet.button.PetTextButton
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetTextIndicator
import com.lnsantos.pet.text.model.PetTextStyle

sealed class DeckModalOptions {
    object Hidden : DeckModalOptions()
    object FirstCreate: DeckModalOptions()
    object Create : DeckModalOptions()

    data class Options(val deck: DeckCardUI) : DeckModalOptions()
    data class Edit(val deck: DeckCardUI) : DeckModalOptions()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeckScreen(
    viewModel: DeckViewModel = hiltViewModel<DeckViewModel>()
) {
    val state = viewModel.state.collectAsState()
    var bottomSheetController by remember { mutableStateOf<DeckModalOptions>(DeckModalOptions.Hidden) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PetValues.Colors.get().primary)
    ) {
        PetTextIndicator(
            text = state.value.title,
            type = PetTextStyle.TITLE,
            isVisible = state.value.title.isNotEmpty(),
            modifier = Modifier.padding(
                horizontal = 32.dp,
                vertical = 16.dp
            ),
            textColor = PetValues.Colors.get().tertiary
        )

        when (val data = state.value.status) {
            is DeckStateType.Loading -> Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) { CircularProgressIndicator() }

            is DeckStateType.EmptyList -> DeckEmptyScenario {
                bottomSheetController = DeckModalOptions.Create
            }

            is DeckStateType.ListDeck -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 32.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    PetTextButton(
                        text = stringResource(id = R.string.deck_empty_button),
                        textStyle = PetTextStyle.DESCRIPTION,
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            bottomSheetController = DeckModalOptions.Create
                        },
                        textColor = PetValues.Colors.get().tertiary
                    )
                }
                DeckListScenario(
                    decks = data.decks,
                    onClickDeck = {
                        // go to screen list cards
                    },
                    onLongClick = {
                        bottomSheetController = DeckModalOptions.Hidden
                        bottomSheetController = DeckModalOptions.Options(it)
                    }
                )
            }
        }

        // create strategy in future to delete when in composable function
        when (val data = bottomSheetController) {
            is DeckModalOptions.FirstCreate -> SimpleModelBottomSheet(
                onDismiss = { bottomSheetController = DeckModalOptions.Hidden },
                onCreate = {
                    viewModel.createDeck(it)
                    bottomSheetController = DeckModalOptions.Hidden
                },
                description = "Crie seu primeiro deck",
                buttonText = "Criar"
            )

            is DeckModalOptions.Create -> SimpleModelBottomSheet(
                onDismiss = { bottomSheetController = DeckModalOptions.Hidden },
                onCreate = {
                    viewModel.createDeck(it)
                    bottomSheetController = DeckModalOptions.Hidden
                },
                description = "Crie um novo deck",
                buttonText = "Criar agora"
            )
            is DeckModalOptions.Edit -> SimpleModelBottomSheet(
                onDismiss = { bottomSheetController = DeckModalOptions.Hidden },
                onCreate = {
                    viewModel.updateDeckByName(data.deck.id, it)
                    bottomSheetController = DeckModalOptions.Hidden
                },
                textInit = data.deck.name,
                description = "Editando nome do deck",
                buttonText = "Confirmar edição"
            )
            is DeckModalOptions.Options -> SimpleOptionsBottomSheet(
                options = listOf(
                    SimpleOption(data = 0, title = "Excluir", icon = null),
                    SimpleOption(data = 1, title = "Editar", icon = null)
                ),
                onDismissRequest = { bottomSheetController = DeckModalOptions.Hidden },
                onClick = {
                    bottomSheetController = DeckModalOptions.Hidden

                    when(it) {
                        0 -> { viewModel.deleteDeck(data.deck.id) }
                        1 -> { bottomSheetController = DeckModalOptions.Edit(data.deck) }
                    }
                }
            )
            else -> { }
        }
    }
}
