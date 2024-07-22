package com.lnsantos.brainup.feature.deck

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lnsantos.brainup.foundation.navigation.Router

fun NavGraphBuilder.deckNavigationHost(
    init : () -> Unit
) {
    composable(route = Router.DECKS.router) {
        init()
        DeckScreen()
    }
}
