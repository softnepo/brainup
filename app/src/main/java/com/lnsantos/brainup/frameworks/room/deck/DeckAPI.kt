package com.lnsantos.brainup.frameworks.room.deck

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeckAPI {

    @Query("SELECT * FROM deck WHERE profile_id = :ownerId")
    suspend fun getAllDeckByProfile(ownerId: Long) : List<DeckModel>

    @Query("DELETE FROM deck WHERE id = :id")
    suspend fun deleteDeckById(id: Long) : Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(deck: DeckModel)

    @Query("SELECT * FROM deck WHERE profile_id = :ownerId AND created = :created")
    suspend fun getDeckByCreateAt(ownerId: Long, created: String) : DeckModel
}