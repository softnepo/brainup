package com.lnsantos.brainup.feature.deck

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.domain.entity.DeckDomain
import com.lnsantos.brainup.domain.usecase.GetDeckWithWeightByProfileUseCase
import com.lnsantos.brainup.feature.deck.model.DeckState
import com.lnsantos.brainup.feature.deck.model.DeckStateType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeckViewModel @Inject constructor(
    private val uiRule: DeckUIRule,
    private val getDeckWithWeight: GetDeckWithWeightByProfileUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DeckState())
    val state = _state.asStateFlow()

    init {
        searchAllDecks()
    }

    fun searchAllDecks() {
        viewModelScope.launch {
            getDeckWithWeight()
                .onEach { deck -> _state.update { uiRule(it, deck) } }
                .onCompletion { }
                .collect()
        }
    }
}
