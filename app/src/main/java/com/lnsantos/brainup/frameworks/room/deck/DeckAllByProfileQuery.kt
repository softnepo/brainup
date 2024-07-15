package com.lnsantos.brainup.frameworks.room.deck

import androidx.room.Embedded
import androidx.room.Relation
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel

data class DeckAllByProfileQuery(
    @Embedded
    val profile: ProfileModel,

    @Relation(
        parentColumn = "id",
        entityColumn = "profile_id",
        entity = DeckModel::class,
        projection = ["id"]
    )
    val decksIDs: List<Long>
)
