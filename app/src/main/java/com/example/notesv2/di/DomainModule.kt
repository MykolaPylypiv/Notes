package com.example.notesv2.di

import android.content.Context
import com.example.notesv2.core.DoToast
import com.example.notesv2.domain.interactor.AddInteractor
import com.example.notesv2.domain.interactor.DetailInteractor
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
        favoriteNotesUseCase: FavoriteNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        updateNoteUseCase: UpdateNoteUseCase,
    ): FavoriteInteractor = FavoriteInteractor.Base(
        favoriteChange, visibility, favoriteNotesUseCase,
        deleteNoteUseCase, updateNoteUseCase
    )

    @Provides
    fun provideInteractorAdd(
        insertNoteUseCase: InsertNoteUseCase,
        toast: DoToast,
        context: Context
    ): AddInteractor = AddInteractor.Base(
        insertNoteUseCase, toast, context
    )

    @Provides
    fun provideInteractorDetail(
        updateNoteUseCase: UpdateNoteUseCase,
        toast: DoToast,
        context: Context
    ): DetailInteractor = DetailInteractor.Base(
        updateNoteUseCase, toast, context
    )
}