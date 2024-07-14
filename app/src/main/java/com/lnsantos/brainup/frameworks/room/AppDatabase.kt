package com.lnsantos.brainup.frameworks.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lnsantos.brainup.frameworks.room.profile.ProfileAPI
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel

@Database(
    entities = [ProfileModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileApi() : ProfileAPI
}
