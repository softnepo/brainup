package com.lnsantos.brainup.feature.card.model

data class CardUI(
    val id: Long,
    val front: String,
    val hidden: String,
    val nps: Int = 0
)
