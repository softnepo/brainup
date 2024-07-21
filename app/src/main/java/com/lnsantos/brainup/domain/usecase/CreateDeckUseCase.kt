package com.lnsantos.brainup.domain.usecase

import android.util.Log
import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.domain.entity.DeckDomain
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateDeckUseCase @Inject constructor(
    private val repositoryDeck: IDeckRepository,
) {

    suspend operator fun invoke(name: String) = flow {

        val timestamp = repositoryDeck.insert(name)
        val deck = repositoryDeck.getDeckByCreateAt(timestamp)
        val domain = DeckDomain(deck.id, deck.name, 0)

        emit(domain)
    }
}