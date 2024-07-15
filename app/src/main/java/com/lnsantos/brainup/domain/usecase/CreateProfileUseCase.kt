package com.lnsantos.brainup.domain.usecase

import com.lnsantos.brainup.data.IProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
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
