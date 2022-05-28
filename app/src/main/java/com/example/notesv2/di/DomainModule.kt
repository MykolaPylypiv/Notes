package com.example.notesv2.di

import com.example.notesv2.domain.interactor.FavoriteInteractor
import com.example.notesv2.domain.interactor.HomeInteractor
import com.example.notesv2.domain.interactor.usecases.*
import com.example.notesv2.domain.repositories.ChangeFavoriteRepository
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.ChangeVisibilityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideInteractorHome(
        favoriteChange: ChangeFavoriteRepository,
        changeLayout: ChangeLayoutRepository,
        visibility: ChangeVisibilityRepository,
        notesUseCase: NotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        deleteAllNoteUseCase: DeleteAllNoteUseCase,
    ): HomeInteractor = HomeInteractor.Base(
        favoriteChange, changeLayout, visibility, notesUseCase,
        deleteNoteUseCase, deleteAllNoteUseCase,
    )

    @Provides
    fun provideInteractorFavorite(
        favoriteChange: ChangeFavoriteRepository,
        visibility: ChangeVisibilityRepository,
        likeNotesUseCase: LikeNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        updateNoteUseCase: UpdateNoteUseCase,
    ): FavoriteInteractor = FavoriteInteractor.Base(
        favoriteChange, visibility, likeNotesUseCase,
        deleteNoteUseCase, updateNoteUseCase
    )
}