package com.lnsantos.brainup.frameworks.room.profile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class ProfileModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo(name = "created", defaultValue = "CURRENT_TIMESTAMP")
    val created: String,

    @ColumnInfo(name = "last_updated", defaultValue = "CURRENT_TIMESTAMP")
    val update: String
)
