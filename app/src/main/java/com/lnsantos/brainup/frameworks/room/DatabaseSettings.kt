package com.lnsantos.brainup.frameworks.room

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class DatabaseSettings @Inject constructor() {

    private val DATABASE_DB = "brainup-db.2024"

    fun create(
        app: Context
    ) = Room.databaseBuilder(
        context = app,
        klass = AppDatabase::class.java,
        name = DATABASE_DB
    )
}
