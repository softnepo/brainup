package com.lnsantos.brainup.feature.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnsantos.brainup.data.IProfileRepository
import com.lnsantos.brainup.feature.launcher.type.NextDirection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class LauncherViewModel @Inject constructor(
    private val profileRepository: IProfileRepository,
    private val uiRule: LauncherUIRule
) : ViewModel() {

    private val _direction = MutableStateFlow<NextDirection?>(null)
    internal val direction = _direction.asStateFlow()

    init {
        viewModelScope.launch {
            _direction.update { uiRule(profileRepository.getAll()) }
        }
    }
}
