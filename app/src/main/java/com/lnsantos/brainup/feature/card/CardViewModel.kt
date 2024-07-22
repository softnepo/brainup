package com.lnsantos.brainup.feature.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnsantos.brainup.domain.usecase.CreateCardUseCase
import com.lnsantos.brainup.domain.usecase.GetCardsByDeckUseCase
import com.lnsantos.brainup.feature.card.model.CardUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getCardsByDeckUseCase: GetCardsByDeckUseCase,
    private val createCardUseCase: CreateCardUseCase,
    private val ruleUI: CardUIRule
) : ViewModel() {

    private val _state = MutableStateFlow(mutableListOf<CardUI>())
    val state = _state.asStateFlow()

    private var deckId: Long? = null

    fun init(
        id: Long
    ) {
        if (deckId == null) {
            deckId = id

            fetchCards()
        }
    }

    fun createCard(front: String, hidden: String) {
        viewModelScope.launch {
            createCardUseCase(front, hidden, deckId)
                .catch {
                    // to-do
                }
                .collect { card ->
                  _state.update { it.apply { add(ruleUI.converterToUI(card)) } }
                }
        }
    }

    private fun fetchCards() {
        viewModelScope.launch {
            getCardsByDeckUseCase(deckId)
                .catch {
                    // to-do
                }
                .collect { list ->
                    _state.update { it.apply { addAll(list) } }
                }
        }
    }
}
