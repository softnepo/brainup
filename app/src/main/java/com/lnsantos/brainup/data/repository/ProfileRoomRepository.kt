package com.lnsantos.brainup.data.repository

import com.lnsantos.brainup.data.IProfileRepository
import com.lnsantos.brainup.foundation.support.DateSupport
import com.lnsantos.brainup.frameworks.room.profile.ProfileAPI
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel
import javax.inject.Inject

class ProfileRoomRepository @Inject constructor(
    private val api: ProfileAPI,
    private val dateSupport: DateSupport
) : IProfileRepository {

    override suspend fun create(
        profileName: String
    )  {
        val timestamp = dateSupport.createDateInISO8610()
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
