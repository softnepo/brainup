package com.lnsantos.brainup.data

import com.lnsantos.brainup.frameworks.room.card.CardModel

interface ICardRepository {

    suspend fun insert(card: CardModel)

    suspend fun getAllCardsByDeckOriginId(originId: Long) : List<CardModel>

    suspend fun getCardByCreatedAt(ownerId: Long, created: String) : CardModel

    suspend fun delete(vararg card: CardModel)

    suspend fun deleteAllCardsByDeckOriginId(originId: Long)

}