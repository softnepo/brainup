package com.lnsantos.brainup.feature.deck.model

data class DeckState(
    val title: String = "",
    val status : DeckStateType = DeckStateType.Loading
)
