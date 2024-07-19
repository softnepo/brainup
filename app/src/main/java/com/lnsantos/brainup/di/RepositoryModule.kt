package com.lnsantos.brainup.di

import com.lnsantos.brainup.data.ICardRepository
import com.lnsantos.brainup.data.IDeckRepository
import com.lnsantos.brainup.data.IProfileRepository
import com.lnsantos.brainup.data.repository.CardRoomRepository
import com.lnsantos.brainup.data.repository.DeckRoomRepository
import com.lnsantos.brainup.data.repository.ProfileRoomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProfileRoomRepository(
        repository: ProfileRoomRepository
    ): IProfileRepository

    @Binds
    abstract fun bindDeckRoomRepository(
        repository: DeckRoomRepository
    ): IDeckRepository

    @Binds
    abstract fun bindCardRoomRepository(
        repository: CardRoomRepository
    ) : ICardRepository

}
