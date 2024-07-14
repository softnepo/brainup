package com.lnsantos.brainup.data.repository

import com.lnsantos.brainup.data.IProfileRepository
import com.lnsantos.brainup.frameworks.room.profile.ProfileAPI
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel
import java.util.Date
import javax.inject.Inject

class ProfileRoomRepository @Inject constructor(
    private val api: ProfileAPI
) : IProfileRepository {

    override suspend fun create(
        profileName: String
    )  {
        val timestamp = Date().toString()
        val profile = ProfileModel(
            name = profileName,
            created = timestamp,
            update = timestamp
        )

        api.record(profile)
    }

    override suspend fun getAll() : Array<ProfileModel> {
        return api.getAll()
    }
}
