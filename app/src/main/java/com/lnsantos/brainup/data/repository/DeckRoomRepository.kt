package com.lnsantos.brainup.data.repository

import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.foundation.session.BrainUpSession
import com.lnsantos.brainup.frameworks.room.deck.DeckAPI
import com.lnsantos.brainup.frameworks.room.deck.DeckModel
import javax.inject.Inject

class DeckRoomRepository @Inject constructor(
    private val api: DeckAPI,
    private val session: BrainUpSession
) : IDeckRepository {

    override suspend fun insert(deckName: String) {
        val model = DeckModel(
            name = deckName,
            profileId = session.getProfileId()
        )

        api.insert(model)
    }

    override suspend fun getAllDeckByProfileSelected(): List<DeckModel> {
        return api.getAllDeckByProfile(session.getProfileId())
    }

    override suspend fun deleteDeckById(id: Long): Int {
        return api.deleteDeckById(id)
    }
}
