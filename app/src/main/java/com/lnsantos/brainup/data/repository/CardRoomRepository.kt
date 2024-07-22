package com.lnsantos.brainup.data.repository

import com.lnsantos.brainup.data.ICardRepository
import com.lnsantos.brainup.frameworks.room.card.CardAPI
import com.lnsantos.brainup.frameworks.room.card.CardModel
import javax.inject.Inject

class CardRoomRepository @Inject constructor(
    private val api: CardAPI
) : ICardRepository {

    override suspend fun insert(card: CardModel) {
        api.insert(card)
    }

    override suspend fun getAllCardsByDeckOriginId(originId: Long): List<CardModel> {
        return api.getAllCardsByDeckOriginId(originId)
    }

    override suspend fun getCardByCreatedAt(ownerId: Long, created: String): CardModel {
        return api.getCardByCreateAt(ownerId, created)
    }

    override suspend fun delete(vararg card: CardModel) {
        return api.delete(*card)
    }

    override suspend fun deleteAllCardsByDeckOriginId(originId: Long) {
        return api.deleteAllCardsByDeckOriginId(originId)
    }

}