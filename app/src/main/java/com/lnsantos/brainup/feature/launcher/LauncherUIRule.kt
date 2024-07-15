package com.lnsantos.brainup.feature.launcher

import com.lnsantos.brainup.feature.launcher.type.NextDirection
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel
import javax.inject.Inject

class LauncherUIRule @Inject constructor() {

    operator fun invoke(list: Array<ProfileModel>): Pair<NextDirection, Long?> {
        return list.firstOrNull()?.let { NextDirection.HOME to it.id } ?: (NextDirection.GATEWAY to null)
    }
}
