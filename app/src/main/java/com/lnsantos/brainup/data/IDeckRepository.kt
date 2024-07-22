package com.lnsantos.brainup.data

import com.lnsantos.brainup.frameworks.room.deck.DeckModel
import java.sql.Timestamp

interface IDeckRepository {

    suspend fun insert(deckName: String) : String

    suspend fun getAllDeckByProfileSelected() : List<DeckModel>

    suspend fun deleteDeckById(id: Long) : Int

    suspend fun getDeckByCreateAt(timestamp: String) : DeckModel

    suspend fun getDeckById(id: Long) : DeckModel

    suspend fun updateDeck(deck: DeckModel)
}