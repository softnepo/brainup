package com.lnsantos.brainup.feature.gateway

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnsantos.brainup.domain.usecase.CreateProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GatewayViewModel @Inject constructor(
    private val createProfile: CreateProfileUseCase,
    private val rule: GatewayUIRule
) : ViewModel() {

    private val _state = MutableStateFlow(GatewayState())
    val state = _state.asStateFlow()

    fun create(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createProfile(name)
                .onStart { applyLoading() }
                .map { data -> rule(data) }
                .collect { data -> _state.update { data } }
        }
    }

    private fun applyLoading() {
        _state.update { it.copy(isLoading = true) }
    }
}
