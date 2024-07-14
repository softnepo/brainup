package com.lnsantos.brainup.domain.usecase

import com.lnsantos.brainup.data.IProfileRepository
import com.lnsantos.brainup.foundation.exceptions.FailedCreateUserException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

class CreateProfileUseCase @Inject constructor(
    private val profileRepository : IProfileRepository
) {

    operator fun invoke(
        nameProfile: String
    ) : Flow<Result<Unit>> = flow {
        profileRepository.create(nameProfile)
        emit(success(Unit))
    }
}
