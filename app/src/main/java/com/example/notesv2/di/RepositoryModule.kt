package com.example.notesv2.di

import com.example.notesv2.data.db.AppDatabase
import com.example.notesv2.data.repository.cachedatasource.*
import com.example.notesv2.domain.repositories.*
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
        BaseRepository(database.notesDao())

    @Singleton
    @Provides
    fun provideFavoriteList(database: AppDatabase): FavoriteNote =
        FavoriteListCacheDataSource.Base(database.notesDao())

    @Singleton
    @Provides
    fun provideFindByUid(database: AppDatabase): FindByUidNote =
        FindByUidNoteCacheDataSource.Base(database.notesDao())

    @Singleton
    @Provides
    fun provideInsertNote(database: AppDatabase): InsertNote =
        InsertNoteCacheDataSource.Base(database.notesDao())

    @Singleton
    @Provides
    fun provideDeleteNote(database: AppDatabase): DeleteNote =
        DeleteNoteCacheDataSource.Base(database.notesDao())

    @Singleton
    @Provides
    fun provideUpdateNote(database: AppDatabase): UpdateNote =
        UpdateNoteCacheDataSource.Base(database.notesDao())

    @Singleton
    @Provides
    fun provideDeleteAllNote(database: AppDatabase): DeleteAllNotes =
        DeleteAllNoteCacheDataSource.Base(database.notesDao())
}