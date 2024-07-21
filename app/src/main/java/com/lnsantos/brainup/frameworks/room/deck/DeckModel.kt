package com.lnsantos.brainup.frameworks.room.deck

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel

@Entity(
    tableName = "deck",
    foreignKeys = [ForeignKey(
        entity = ProfileModel::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("profile_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class DeckModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "deck_name")
    val name: String,
    @ColumnInfo(name = "profile_id")
    val profileId: Long,
    @ColumnInfo(name = "created")
    val created: String,
    @ColumnInfo(name = "last_updated")
    val update: String
)
