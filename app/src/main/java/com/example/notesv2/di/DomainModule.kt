package com.example.notesv2.di

import com.example.notesv2.domain.interactor.InteractorFavorite
import com.example.notesv2.domain.interactor.InteractorHome
import com.example.notesv2.domain.interactor.usecases.ChangeLayoutUseCase
import com.example.notesv2.domain.interactor.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.interactor.usecases.FavoriteChangeUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.DeleteAllNoteUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.DeleteNoteUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.NotesUseCase
import com.example.notesv2.presentation.view.dialog.DeleteDialog
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
        notesUseCase: NotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        deleteAllNoteUseCase: DeleteAllNoteUseCase,
        deleteDialog: DeleteDialog
    ): InteractorHome = InteractorHome(
        favoriteChangeUseCase,
        changeLayoutUseCase,
        visibilityUseCase,
        notesUseCase,
        deleteNoteUseCase,
        deleteAllNoteUseCase,
        deleteDialog
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