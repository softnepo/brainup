package com.lnsantos.brainup.foundation.session


// Migrate future to saved local
class BrainUpSessionImpl : BrainUpSession {

    private var profileId: Long = 1

    override fun getProfileId(): Long = profileId

    override fun updateProfileId(id: Long) {
        profileId = id
    }
}
