package com.lnsantos.brainup.feature.card

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


fun NavGraphBuilder.cardNavigationHost(
    init: () -> Unit,
    onBackScreen: () -> Unit,
) {
    composable(
        route = "cards/{deck_id}",
        arguments = listOf(navArgument("deck_id"){ type = NavType.LongType})
    ) {
        init()
        val deckId = it.arguments?.getLong("deck_id")

        if (deckId == null) {
            // show custom alert to user
            onBackScreen()
            return@composable
        }

        CardScreen(
            deckId = deckId,
            onExit = onBackScreen
        )
    }
}