package com.lnsantos.brainup.feature.home.widgets

import androidx.compose.ui.graphics.vector.ImageVector

interface WidgetParent {
    val deeplink: String
}

data class WidgetButtonItem(
    val title: String,
    override val deeplink: String,
    val icon: ImageVector? = null
) : WidgetParent
