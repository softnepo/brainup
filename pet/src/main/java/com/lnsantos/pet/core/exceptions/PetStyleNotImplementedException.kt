package com.lnsantos.pet.core.exceptions

import com.lnsantos.pet.core.PetStyle

internal fun Array<PetStyle>.createExceptionMessage(): String {
    val supporters = joinToString(separator = " | ") { it.name }
    return "Supporters style is [${supporters}]"
}

internal class PetStyleNotImplementedException(
    origin: String? = null,
    supporters: Array<PetStyle> = arrayOf(),
    description: String? = "this pet style not implemented, please use other."
) : RuntimeException("""
    Origin: [$origin]
    Cause: $description 
    
    Helper: ${supporters.createExceptionMessage()}
       
 """.trimIndent()
)

