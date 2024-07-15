package com.lnsantos.brainup.data

import com.lnsantos.brainup.frameworks.room.deck.DeckModel

interface IDeckRepository {

    suspend fun insert(deckName: String)

    suspend fun getAllDeckByProfileSelected() : List<DeckModel>

    suspend fun deleteDeckById(id: Long) : Int

}