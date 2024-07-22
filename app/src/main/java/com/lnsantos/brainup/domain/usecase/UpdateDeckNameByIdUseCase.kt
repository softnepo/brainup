package com.lnsantos.brainup.domain.usecase

import com.lnsantos.brainup.data.ICardRepository
import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.domain.entity.DeckDomain
import com.lnsantos.brainup.foundation.support.DateSupport
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UpdateDeckNameByIdUseCase @Inject constructor(
    private val repository: IDeckRepository,
    private val cardRepository: ICardRepository,
    private val dateSupport: DateSupport
) {

    operator fun invoke(
        id: Long,
        newName: String,
        recoveryWeight: Boolean = true
    ) = flow {
        val oldDeck = repository.getDeckById(id)
        val newDeck = oldDeck.copy(
            name = newName,
            update = dateSupport.createDateInISO8610()
        )

        repository.updateDeck(newDeck)

        val weight = takeIf { recoveryWeight }?.run {
            cardRepository.getAllCardsByDeckOriginId(id).size
        }

        val domain = DeckDomain(
            id = newDeck.id,
            name = newDeck.name,
            weight = weight
        )

        emit(domain)
    }.flowOn(Dispatchers.IO)
}
