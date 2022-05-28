package com.example.notesv2.domain.interactor

import androidx.lifecycle.LiveData
import com.example.notesv2.core.Visibility
import com.example.notesv2.domain.interactor.usecases.DeleteNoteUseCase
import com.example.notesv2.domain.interactor.usecases.LikeNotesUseCase
import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.*
import javax.inject.Inject

interface FavoriteInteractor : ChangeVisibilityRepository, ChangeFavoriteRepository,
    GetLikeNotes, DeleteNote, UpdateNote {

    class Base @Inject constructor(
        private val favoriteChange: ChangeFavoriteRepository,
        private val visibility: ChangeVisibilityRepository,
        private val likeNotesUseCase: LikeNotesUseCase,
        private val deleteNoteUseCase: DeleteNoteUseCase,
        private val updateNoteUseCase: UpdateNoteUseCase,
    ) : FavoriteInteractor {

        override fun changeVisibility(list: List<Notes>): Visibility.Abstract =
            visibility.changeVisibility(list)

        override fun like(notes: Notes, updateNoteUseCase: UpdateNoteUseCase): Int =
            favoriteChange.like(notes, updateNoteUseCase)

        override fun likeShow(notes: Notes): Int =
            favoriteChange.likeShow(notes)

        override fun getLikeNotes(): LiveData<List<Notes>> =
            likeNotesUseCase.invoke()

        override suspend fun delete(notes: Notes) =
            deleteNoteUseCase.invoke(notes)

        override suspend fun update(notes: Notes) =
            updateNoteUseCase.invoke(notes)
    }
}