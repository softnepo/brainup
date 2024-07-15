package com.lnsantos.brainup.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.lnsantos.brainup.foundation.session.BrainUpSession
import com.lnsantos.brainup.foundation.session.BrainUpSessionImpl
import com.lnsantos.brainup.frameworks.room.AppDatabase
import com.lnsantos.brainup.frameworks.room.DatabaseSettings
import com.lnsantos.brainup.frameworks.room.deck.DeckAPI
import com.lnsantos.brainup.frameworks.room.profile.ProfileAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LauncherModule {

    @Provides
    fun providerApplication(
        @ApplicationContext application: Application
    ): Application = application

    @Provides
    fun providerResource(
        @ApplicationContext context: Context
    ): Resources = context.resources

    @Provides
    @Singleton
    fun providerAppDatabase(
        @ApplicationContext context: Context,
        settings: DatabaseSettings
    ): AppDatabase = settings.create(context).build()

    @Provides
    fun providerProfileApi(
        database: AppDatabase
    ): ProfileAPI = database.profileApi()

    @Provides
    fun providerDeckApi(
        database: AppDatabase
    ): DeckAPI = database.deckApi()

    @Provides
    @Singleton
    fun providerBrainUpSession() : BrainUpSession = BrainUpSessionImpl()

}
