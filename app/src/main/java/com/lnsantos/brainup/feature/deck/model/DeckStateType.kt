package com.lnsantos.brainup.feature.deck.model

sealed class DeckStateType {
    object Loading : DeckStateType()
    object EmptyList : DeckStateType()
    data class ListDeck(val decks: List<DeckUI>) : DeckStateType()
}
