package com.lnsantos.brainup.feature.launcher

import com.lnsantos.brainup.feature.launcher.type.NextDirection
import com.lnsantos.brainup.frameworks.room.profile.ProfileModel
import javax.inject.Inject

internal class LauncherUIRule @Inject constructor() {

    operator fun invoke(list: Array<ProfileModel>): NextDirection {
        return if (list.isNotEmpty()) NextDirection.HOME else NextDirection.GATEWAY
    }
}
