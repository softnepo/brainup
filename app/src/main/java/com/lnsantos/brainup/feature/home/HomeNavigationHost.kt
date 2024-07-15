package com.lnsantos.brainup.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lnsantos.brainup.feature.home.widgets.WidgetMemory
import com.lnsantos.brainup.feature.home.widgets.WidgetParent
import com.lnsantos.brainup.foundation.navigation.Router

fun NavGraphBuilder.homeNavigationHost(
    init : () -> Unit,
    onClickWidget: (WidgetParent) -> Unit,
    onClickMain: () -> Unit = {},
) {
    composable(route = Router.HOME.router) {
        init()
        HomeScreen(
            widgets = WidgetMemory.getWidget(),
            onClickWidget = onClickWidget,
            onClickMain = onClickMain
        )
    }
}