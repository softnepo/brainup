package com.lnsantos.brainup.frameworks.room

import android.content.Context
import androidx.room.Room
import com.lnsantos.brainup.BuildConfig
import javax.inject.Inject

class DatabaseSettings @Inject constructor() {

    private val DATABASE_DB = "db-${BuildConfig.APPLICATION_ID}"

    fun create(
        app: Context
    ) = Room.databaseBuilder(
        context = app,
        klass = AppDatabase::class.java,
        name = DATABASE_DB
    )
}
