package com.lnsantos.brainup.feature.deck

import android.content.res.Resources
import com.lnsantos.brainup.R
import com.lnsantos.brainup.domain.entity.DeckDomain
import com.lnsantos.brainup.feature.deck.model.DeckCardUI
import com.lnsantos.brainup.feature.deck.model.DeckState
import com.lnsantos.brainup.feature.deck.model.DeckStateType.ListDeck
import com.lnsantos.brainup.feature.deck.model.DeckStateType.Loading
import com.lnsantos.brainup.feature.deck.model.DeckStateType.EmptyList
import javax.inject.Inject

class DeckUIRule @Inject constructor(
    private val resource: Resources
) {

    private fun DeckDomain.toUI() : DeckCardUI {
        return DeckCardUI(id, name, weight ?: 0)
    }

    operator fun invoke(
        state: DeckState,
        deck: DeckDomain?
    ) : DeckState {

        if (deck == null) {
            return state.copy(status = EmptyList)
        }

        if (state.status is Loading) {
            return DeckState(
                title = resource.getString(R.string.deck_screen_header),
                status = ListDeck(
                    listOf(deck.toUI())
                )
            )
        }

        val deckStatus = state.status as ListDeck
        val currentDecks = deckStatus.decks + deck.toUI()

        return state.copy(status = ListDeck(currentDecks))
    }
}
