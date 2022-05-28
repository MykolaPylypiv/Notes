package com.example.notesv2.di

import com.example.notesv2.data.repository.ChangeLayoutRepositoryImpl
import com.example.notesv2.data.repository.ChangeVisibilityRepositoryImpl
import com.example.notesv2.data.repository.FavoriteChangeRepositoryImpl
import com.example.notesv2.domain.repositories.ChangeFavoriteRepository
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.ChangeVisibilityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindEmptyVisibilityRealization(
        realization: ChangeVisibilityRepositoryImpl
    ): ChangeVisibilityRepository

    @Binds
    abstract fun bindFavoriteChangeRealization(
        realization: FavoriteChangeRepositoryImpl
    ): ChangeFavoriteRepository

    @Binds
    abstract fun bindChangeLayoutRealization(
        realization: ChangeLayoutRepositoryImpl
    ): ChangeLayoutRepository
}