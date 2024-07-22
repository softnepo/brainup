package com.lnsantos.brainup.frameworks.room.card

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lnsantos.brainup.frameworks.room.deck.DeckModel

@Dao
interface CardAPI {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: CardModel)

    @Query("SELECT * FROM card_table WHERE deck_origin_id = :originId")
    suspend fun getAllCardsByDeckOriginId(originId: Long) : List<CardModel>

    @Delete
    suspend fun delete(vararg card: CardModel)

    @Query("DELETE FROM card_table WHERE deck_origin_id = :originId")
    suspend fun deleteAllCardsByDeckOriginId(originId: Long)

    @Query("SELECT * FROM card_table WHERE deck_origin_id = :ownerId AND created = :created")
    suspend fun getCardByCreateAt(ownerId: Long, created: String) : CardModel

}