package com.lnsantos.brainup.di

import android.content.Context
import com.lnsantos.brainup.frameworks.room.AppDatabase
import com.lnsantos.brainup.frameworks.room.DatabaseSettings
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
    fun providerResource(
        @ApplicationContext context: Context
    ) = context.resources

    @Provides
    @Singleton
    fun providerAppDatabase(
        @ApplicationContext context: Context,
        settings: DatabaseSettings
    ) = settings.create(context).build()

    @Provides
    fun providerProfileApi(
        database: AppDatabase
    ) = database.profileApi()
}
