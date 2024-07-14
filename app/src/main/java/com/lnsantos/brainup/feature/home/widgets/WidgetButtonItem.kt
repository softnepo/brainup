package com.lnsantos.brainup.feature.home.widgets

interface WidgetParent {
    val deeplink: String
}

data class WidgetButtonItem(
    val title: String,
    override val deeplink: String
) : WidgetParent
