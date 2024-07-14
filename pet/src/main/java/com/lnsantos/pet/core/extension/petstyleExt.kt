package com.lnsantos.pet.core.extension

import com.lnsantos.pet.core.PetStyle

internal fun petStyleFilter(predicate: (PetStyle) -> Boolean) : Array<PetStyle> {
    return PetStyle.values().filter(predicate).toTypedArray()
}