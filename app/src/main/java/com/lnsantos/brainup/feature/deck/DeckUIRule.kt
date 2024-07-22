package com.lnsantos.brainup.feature.deck

import android.content.res.Resources
import com.lnsantos.brainup.R
import com.lnsantos.brainup.domain.entity.DeckDomain
import com.lnsantos.brainup.feature.deck.model.DeckUI
import com.lnsantos.brainup.feature.deck.model.DeckState
import com.lnsantos.brainup.feature.deck.model.DeckStateType.ListDeck
import com.lnsantos.brainup.feature.deck.model.DeckStateType.EmptyList
import javax.inject.Inject

class DeckUIRule @Inject constructor(
    private val resource: Resources
) {

    private fun DeckDomain.toUI() : DeckUI {
        return DeckUI(id, name, weight ?: 0)
    }

    operator fun invoke(
        state: DeckState,
        deck: DeckDomain?
    ) : DeckState {

        if (deck == null) {
            return state.copy(status = EmptyList)
        }

        if (state.status !is ListDeck) {
            return DeckState(
                title = resource.getString(R.string.deck_screen_header),
                status = ListDeck(
                    listOf(deck.toUI())
                )
            )
        }

        val deckStatus = state.status
        val currentDecks = listOf(deck.toUI()) + deckStatus.decks

        return state.copy(status = ListDeck(currentDecks.sortedByDescending { it.id }))
    }

    fun removeDeck(state: DeckState, deckId: Long) : DeckState {
        if (state.status !is ListDeck) return state

        val listDeck = state.status
        val newList = listDeck.decks.filterNot {
            it.id == deckId
        }

        if (newList.isEmpty()) {
            return state.copy(status = EmptyList)
        }

        return state.copy(status = ListDeck(newList.sortedByDescending { it.id }))
    }

    fun updateDeck(state: DeckState, deck: DeckDomain) : DeckState {
        if (state.status !is ListDeck) return state

        val listNoneOldDeck = state.status.decks.filterNot { it.id == deck.id }
        val newList = listNoneOldDeck + deck.toUI()

        return state.copy(status = ListDeck(newList.sortedByDescending { it.id }))
    }
}
