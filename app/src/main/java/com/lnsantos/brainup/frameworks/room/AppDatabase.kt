package com.lnsantos.brainup.frameworks.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lnsantos.brainup.frameworks.room.card.CardAPI
import com.lnsantos.brainup.frameworks.room.card.CardModel
import com.lnsantos.brainup.frameworks.room.deck.DeckAPI
import com.lnsantos.brainup.frameworks.room.deck.DeckModel
import com.lnsantos.brainup.frameworks.room.profile.ProfileAPI
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel

@Database(
    entities = [
        ProfileModel::class,
        DeckModel::class,
        CardModel::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileApi() : ProfileAPI
    abstract fun deckApi() : DeckAPI
    abstract fun cardApi() : CardAPI
}
