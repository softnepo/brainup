package com.lnsantos.brainup.feature.home.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.lnsantos.brainup.R
import com.lnsantos.brainup.foundation.navigation.Router


object WidgetMemory {

    @Composable
    fun getWidget() = listOf(
        WidgetButtonItem(
            title = stringResource(id = R.string.home_widget_my_cards),
            deeplink = Router.MY_CARD.router
        )
    )
}