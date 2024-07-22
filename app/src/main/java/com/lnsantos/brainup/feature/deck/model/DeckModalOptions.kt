package com.lnsantos.brainup.feature.deck.model

sealed class DeckModalOptions {
    object Hidden : DeckModalOptions()
    object FirstCreate: DeckModalOptions()
    object Create : DeckModalOptions()

    data class Options(val deck: DeckCardUI) : DeckModalOptions()
    data class Edit(val deck: DeckCardUI) : DeckModalOptions()
}