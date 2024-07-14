package com.lnsantos.brainup.frameworks.room.profile

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.ABORT
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProfileAPI {

    @Query("SELECT * FROM profile")
    suspend fun getAll() : Array<ProfileModel>

    @Insert(onConflict = ABORT)
    suspend fun record(profile: ProfileModel)

    @Update(onConflict = REPLACE )
    suspend fun update(profile: ProfileModel) : Int
}
