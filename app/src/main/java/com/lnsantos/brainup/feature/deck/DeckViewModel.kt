package com.lnsantos.brainup.feature.deck

import androidx.lifecycle.ViewModel
import com.lnsantos.brainup.feature.launcher.LauncherUIRule
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DeckViewModel @Inject constructor(
    private val uiRule: LauncherUIRule
) : ViewModel() {

}
