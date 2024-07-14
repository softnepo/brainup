package com.lnsantos.brainup.foundation.exceptions

class FailedCreateUserException(
    override val message: String? = "fail on create an new profile"
) : RuntimeException()