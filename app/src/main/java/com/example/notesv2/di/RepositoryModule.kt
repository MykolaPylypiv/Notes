package com.example.notesv2.di

import com.example.notesv2.data.db.AppDatabase
import com.example.notesv2.data.repository.RepositoryImpl
import com.example.notesv2.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(database: AppDatabase): Repository =
        RepositoryImpl(database.notesDao())
}