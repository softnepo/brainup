package com.lnsantos.brainup.feature.card

import com.lnsantos.brainup.feature.card.model.CardUI
import com.lnsantos.brainup.frameworks.room.card.CardModel
import javax.inject.Inject

class CardUIRule @Inject constructor() {

    fun converterToUI(
        newItem: CardModel
    ): CardUI {
        return CardUI(
            id = newItem.id,
            front = newItem.frontName,
            hidden = newItem.hiddenName
        )
    }
}
