package com.lnsantos.brainup.domain.usecase

import com.lnsantos.brainup.data.ICardRepository
import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.domain.entity.DeckDomain
import com.lnsantos.brainup.frameworks.room.deck.DeckModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetDeckWithWeightByProfileUseCase @Inject constructor(
    private val repositoryDeck: IDeckRepository,
    private val repositoryCard: ICardRepository
) {

    operator fun invoke(): Flow<DeckDomain?> = channelFlow {
        repositoryDeck
            .getAllDeckByProfileSelected()
            .takeIf { it.isNotEmpty() }
            ?.forEach { deck -> findCardByDeckAsync(deck) { send(it) } }
            ?: send(null)
    }

    private suspend fun findCardByDeckAsync(
        deck: DeckModel,
        onFinish: suspend (DeckDomain) -> Unit
    ) = withContext(Dispatchers.IO) {
        launch {
            val cards = repositoryCard.getAllCardsByDeckOriginId(deck.id)
            val domain = DeckDomain(
                id = deck.id,
                name = deck.name,
                weight = cards.size
            )
            delay(200)
            onFinish(domain)
        }
    }
}
