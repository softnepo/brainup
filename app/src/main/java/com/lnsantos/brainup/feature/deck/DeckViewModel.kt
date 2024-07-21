package com.lnsantos.brainup.feature.deck

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.domain.usecase.CreateDeckUseCase
import com.lnsantos.brainup.domain.usecase.GetDeckWithWeightByProfileUseCase
import com.lnsantos.brainup.feature.deck.model.DeckState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeckViewModel @Inject constructor(
    private val uiRule: DeckUIRule,
    private val getDeckWithWeight: GetDeckWithWeightByProfileUseCase,
    private val createDeckUseCase: CreateDeckUseCase,
    private val deckRepository: IDeckRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DeckState())
    val state = _state.asStateFlow()

    init {
        searchAllDecks()
    }

    fun searchAllDecks() {
        viewModelScope.launch {
            getDeckWithWeight()
                .onEmpty { }
                .map { uiRule(_state.value, it) }
                .onEach { deck -> _state.update { deck } }
                .collect()
        }
    }

    fun deleteDeck(deckId: Long) {
        viewModelScope.launch {
            if (deckRepository.deleteDeckById(deckId) == 1) {
                _state.update { uiRule.removeDeck(it, deckId) }
            }
        }
    }

    fun createDeck(name: String) {
        viewModelScope.launch {
            createDeckUseCase(name)
                .catch { }
                .collectIndexed { index, result ->
                    Log.d("DeckViewModel", "$index::" + result.name)
                    _state.update { uiRule(it, result) }
                }
        }
    }
}
