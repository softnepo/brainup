package com.lnsantos.brainup.domain.usecase

import com.lnsantos.brainup.data.ICardRepository
import com.lnsantos.brainup.foundation.support.DateSupport
import com.lnsantos.brainup.frameworks.room.card.CardModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateCardUseCase @Inject constructor(
    private val cardRepository: ICardRepository,
    private val dateSupport: DateSupport
) {

    operator fun invoke(
        front:String,
        hidden: String,
        deckId: Long?
    ) = flow{

        check(deckId != null) { "require deckID to register card" }

        val date = dateSupport.createDateInISO8610()
        val model = CardModel(
            frontName = front,
            hiddenName = hidden,
            deckOriginId = deckId,
            created = date,
            update = date
        )

        cardRepository.insert(model)
        val newCard = cardRepository.getCardByCreatedAt(deckId, date)

        emit(newCard)
    }
}