package com.example.notesv2.di

import com.example.notesv2.data.repository.ChangeLayoutRealization
import com.example.notesv2.data.repository.EmptyVisibilityRealization
import com.example.notesv2.data.repository.FavoriteChangeRealization
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule() {

    @Binds
    abstract fun provideEmptyVisibilityRealization(
        realization: EmptyVisibilityRealization
    ): EmptyVisibilityRepository

    @Binds
    abstract fun provideFavoriteChangeRealization(
        realization: FavoriteChangeRealization
    ): FavoriteChangeRepository


    @Binds
    abstract fun provideChangeLayoutRealization(
        realization: ChangeLayoutRealization
    ): ChangeLayoutRepository
}