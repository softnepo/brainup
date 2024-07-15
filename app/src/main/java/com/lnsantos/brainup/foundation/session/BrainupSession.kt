package com.lnsantos.brainup.foundation.session

interface BrainUpSession {

    fun getProfileId(): Long

    fun updateProfileId(id: Long)
}
