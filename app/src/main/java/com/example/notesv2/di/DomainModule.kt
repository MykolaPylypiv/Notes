package com.example.notesv2.di

import com.example.notesv2.domain.interactor.InteractorFavorite
import com.example.notesv2.domain.interactor.InteractorHome
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import com.example.notesv2.domain.usecases.ChangeLayoutUseCase
import com.example.notesv2.domain.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.usecases.FavoriteChangeUseCase
import com.example.notesv2.presentation.dialog.DeleteDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideChangeLayoutUseCase(changeLayoutRealization: ChangeLayoutRepository)
            : ChangeLayoutUseCase = ChangeLayoutUseCase(changeLayoutRealization)

    @Provides
    fun provideFavoriteChangeUseCase(favoriteChangeRealization: FavoriteChangeRepository):
            FavoriteChangeUseCase = FavoriteChangeUseCase(favoriteChangeRealization)

    @Provides
    fun provideEmptyVisibilityUseCase(emptyVisibilityRealization: EmptyVisibilityRepository):
            EmptyVisibilityUseCase = EmptyVisibilityUseCase(emptyVisibilityRealization)


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


    @Provides
    fun provideDeleteDialog(): DeleteDialog = DeleteDialog()
}