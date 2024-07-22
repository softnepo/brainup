package com.lnsantos.brainup.frameworks.room.card

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.lnsantos.brainup.frameworks.room.deck.DeckModel

@Entity(
    tableName = "card_table",
    foreignKeys = [
        ForeignKey(
            parentColumns = ["id"],
            childColumns = ["deck_origin_id"],
            entity = DeckModel::class,
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class CardModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "front_name")
    val frontName: String,

    @ColumnInfo(name = "hidden_name")
    val hiddenName: String,

    @ColumnInfo(name = "deck_origin_id")
    val deckOriginId: Long,

    @ColumnInfo(name = "created")
    val created: String,

    @ColumnInfo(name = "last_updated")
    val update: String
)
