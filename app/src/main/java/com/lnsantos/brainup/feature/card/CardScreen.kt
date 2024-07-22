package com.lnsantos.brainup.feature.card

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.focused
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lnsantos.brainup.R
import com.lnsantos.brainup.feature.card.modal.NewCardBottomSheet
import com.lnsantos.brainup.feature.card.model.CardUI
import com.lnsantos.brainup.foundation.ui.options.ModalOptions
import com.lnsantos.brainup.foundation.ui.scenario.EmptyScenario
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CardScreen(
    modifier: Modifier = Modifier,
    deckId: Long? = null,
    onExit: () -> Unit = { },
    viewModel: CardViewModel = hiltViewModel<CardViewModel>()
) {

    val cards = viewModel.state.collectAsState()
    var bottomSheetController by remember { mutableStateOf<ModalOptions<CardUI>>(ModalOptions.Hidden) }

    deckId?.let { viewModel.init(it) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PetValues.Colors.get().background)
            .animateContentSize()
    ) {

        Header(onExit) { bottomSheetController = ModalOptions.Create }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = PetValues.Colors.get().tertiary)
                .semantics { invisibleToUser() },
            content = { }
        )

        if (cards.value.isEmpty()) {
            EmptyScenario(
                description = R.string.cards_screen_empty_description,
                textButton = R.string.cards_screen_empty_button,
                onClick = {
                    bottomSheetController = ModalOptions.Create
                }
            )
        } else {
            ListCards(
                cards = cards.value,
                onClick = {
                    bottomSheetController = ModalOptions.Hidden
                },
                onLongClick = {
                    bottomSheetController = ModalOptions.Hidden
                }
            )
        }
    }

    when (val data = bottomSheetController) {
        is ModalOptions.Create -> NewCardBottomSheet(
            onDismiss = { bottomSheetController = ModalOptions.Hidden },
            onCreate = { front, hidden ->
                viewModel.createCard(front, hidden)
                bottomSheetController = ModalOptions.Hidden
            },
            descriptionFront = stringResource(id = R.string.cards_screen_card_front),
            descriptionHidden = stringResource(id = R.string.cards_screen_card_hidden),
            buttonText = stringResource(id = R.string.cards_screen_create_button),
            title = stringResource(id = R.string.cards_screen_empty_button)
        )

        else -> {}
    }

}

@Composable
@Preview(name = "Header main")
private fun Header(
    onExit: () -> Unit = { },
    onNewCard: () -> Unit = { }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = PetValues.Colors.get().background),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .background(color = PetValues.Colors.get().background)
                .padding(8.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDownward,
                contentDescription = stringResource(id = R.string.accessibility_toolbar_exit),
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .clickable(onClick = onExit)
            )
            PetText(
                text = stringResource(id = R.string.cards_screen_header),
                type = PetTextStyle.SUBTITLE,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    .semantics { heading() }
            )
        }
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.accessibility_toolbar_create_card),
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp, end = 16.dp)
                .clickable(onClick = onNewCard)
        )
    }
}

@Composable
@Preview
private fun ListCards(
    cards: List<CardUI> = listOf(),
    onClick: (CardUI) -> Unit = { },
    onLongClick: (CardUI) -> Unit = { }
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        cards.forEachIndexed { index, ui ->
            item(key = index, contentType = ui) {
                CardItem(card = ui, onClick = onClick, onLongClick = onLongClick)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CardItem(
    card: CardUI,
    onClick: (CardUI) -> Unit,
    onLongClick: (CardUI) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(
                color = PetValues.Colors.get().background,
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                width = 2.dp,
                color = PetValues.Colors.get().tertiary,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(16.dp)
            .combinedClickable(
                onClick = { onClick(card) },
                onLongClick = { onLongClick(card) }
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ChildrenGroupText(
                modifier = Modifier.weight(1f),
                title = stringResource(id = R.string.cards_screen_card_front),
                description = card.front
            )
            ChildrenGroupText(
                modifier = Modifier.weight(1f),
                title = stringResource(id = R.string.cards_screen_card_hidden),
                description = card.hidden
            )
        }
    }
}

@Composable
@Preview(name = "Group text - Information")
private fun ChildrenGroupText(
    modifier: Modifier = Modifier,
    title: String = String(),
    description: String = String()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .semantics(mergeDescendants = true) { focused = true },
    ) {
        PetText(text = title, type = PetTextStyle.SUBTITLE)
        PetText(text = description, type = PetTextStyle.DESCRIPTION)
    }
}
