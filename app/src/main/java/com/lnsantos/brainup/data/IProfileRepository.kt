package com.lnsantos.brainup.data

import com.lnsantos.brainup.frameworks.room.profile.ProfileModel

interface IProfileRepository {

    suspend fun create(profileName: String)

    suspend fun getAll() : Array<ProfileModel>

}
