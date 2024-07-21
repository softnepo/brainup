package com.lnsantos.brainup.data.repository

import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.foundation.session.BrainUpSession
import com.lnsantos.brainup.foundation.support.DateSupport
import com.lnsantos.brainup.frameworks.room.deck.DeckAPI
import com.lnsantos.brainup.frameworks.room.deck.DeckModel
import javax.inject.Inject

class DeckRoomRepository @Inject constructor(
    private val api: DeckAPI,
    private val session: BrainUpSession,
    private val dateSupport: DateSupport
) : IDeckRepository {

    override suspend fun insert(deckName: String) : String {
        val timestamp = dateSupport.createDateInISO8610()
        val model = DeckModel(
            name = deckName,
            profileId = session.getProfileId(),
            created = timestamp,
            update = timestamp
        )

        api.insert(model)
        return timestamp
    }

    override suspend fun getAllDeckByProfileSelected(): List<DeckModel> {
        return api.getAllDeckByProfile(session.getProfileId())
    }

    override suspend fun deleteDeckById(id: Long): Int {
        return api.deleteDeckById(id)
    }

    override suspend fun getDeckByCreateAt(timestamp: String): DeckModel {
        return api.getDeckByCreateAt(session.getProfileId(), timestamp)
    }
}
