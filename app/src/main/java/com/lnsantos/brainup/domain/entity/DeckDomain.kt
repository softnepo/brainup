package com.lnsantos.brainup.domain.entity

data class DeckDomain(
    val id: Long,
    val name: String,
    val weight: Int? = null
)
