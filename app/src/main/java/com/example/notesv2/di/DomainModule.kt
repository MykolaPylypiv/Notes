package com.example.notesv2.di

import android.content.Context
import com.example.notesv2.domain.interactor.InteractorDetail
import com.example.notesv2.domain.interactor.InteractorFavorite
import com.example.notesv2.domain.interactor.InteractorHome
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.DaoCoroutineRepository
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import com.example.notesv2.domain.usecases.*
import com.example.notesv2.presentation.dialog.DeleteDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideDaoRealizationUseCase(daoCoroutineRealization: DaoCoroutineRepository)
            : DaoRealizationUseCases = DaoRealizationUseCases(daoCoroutineRealization)

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
        daoRealizationUseCases: DaoRealizationUseCases,
        favoriteChangeUseCase: FavoriteChangeUseCase,
        changeLayoutUseCase: ChangeLayoutUseCase,
        visibilityUseCase: EmptyVisibilityUseCase,
    ): InteractorHome = InteractorHome(
        daoRealizationUseCases,
        favoriteChangeUseCase,
        changeLayoutUseCase,
        visibilityUseCase,
    )

    @Provides
    fun provideInteractorFavorite(
        daoRealizationUseCases: DaoRealizationUseCases,
        favoriteChangeUseCase: FavoriteChangeUseCase,
        visibilityUseCase: EmptyVisibilityUseCase,
    ): InteractorFavorite = InteractorFavorite(
        daoRealizationUseCases,
        favoriteChangeUseCase,
        visibilityUseCase,
    )

    @Provides
    fun provideInteractorDetail(
        daoRealizationUseCases: DaoRealizationUseCases,
    ): InteractorDetail = InteractorDetail(daoRealizationUseCases)


    @Provides
    fun provideDeleteDialog(): DeleteDialog = DeleteDialog()
}