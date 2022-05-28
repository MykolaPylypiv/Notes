package com.example.notesv2.di

import com.example.notesv2.domain.interactor.InteractorFavorite
import com.example.notesv2.domain.interactor.InteractorHome
import com.example.notesv2.domain.usecases.ChangeLayoutUseCase
import com.example.notesv2.domain.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.usecases.FavoriteChangeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideInteractorHome(
        favoriteChangeUseCase: FavoriteChangeUseCase,
        changeLayoutUseCase: ChangeLayoutUseCase,
        visibilityUseCase: EmptyVisibilityUseCase,
    ): InteractorHome = InteractorHome(
        favoriteChangeUseCase,
        changeLayoutUseCase,
        visibilityUseCase,
    )

    @Provides
    fun provideInteractorFavorite(
        favoriteChangeUseCase: FavoriteChangeUseCase,
        visibilityUseCase: EmptyVisibilityUseCase,
    ): InteractorFavorite = InteractorFavorite(
        favoriteChangeUseCase,
        visibilityUseCase,
    )
}