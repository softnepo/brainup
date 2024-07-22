package com.lnsantos.brainup.domain.usecase

import com.lnsantos.brainup.data.ICardRepository
import com.lnsantos.brainup.feature.card.model.CardUI
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCardsByDeckUseCase @Inject constructor(
    private val cardRepository: ICardRepository
) {

    operator fun invoke(deckId: Long?) = flow{

        if (deckId == null) {
            emit(emptyList())
            return@flow
        }

        val cards = cardRepository.getAllCardsByDeckOriginId(deckId)
            .map { CardUI(it.id, it.frontName, it.hiddenName) }

        emit(cards)
    }
}
