package com.example.notesv2.domain.interactor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.notesv2.core.Visibility
import com.example.notesv2.domain.interactor.usecases.DeleteAllNoteUseCase
import com.example.notesv2.domain.interactor.usecases.DeleteNoteUseCase
import com.example.notesv2.domain.interactor.usecases.NotesUseCase
import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.*
import javax.inject.Inject

interface HomeInteractor : ChangeFavoriteRepository, ChangeLayoutRepository,
    ChangeVisibilityRepository, Repository, DeleteNote, DeleteAllNotes {

    class Base @Inject constructor(
        private val changeFavorite: ChangeFavoriteRepository,
        private val changeLayout: ChangeLayoutRepository,
        private val changeVisibility: ChangeVisibilityRepository,
        private val notesUseCase: NotesUseCase,
        private val deleteNoteUseCase: DeleteNoteUseCase,
        private val deleteAllNoteUseCase: DeleteAllNoteUseCase,
    ) : HomeInteractor {

        override fun changeVisibility(list: List<Notes>): Visibility.Abstract =
            changeVisibility.changeVisibility(list)

        override fun changeLayoutManager() = changeLayout.changeLayoutManager()

        override fun backgroundLayout(): Int = changeLayout.backgroundLayout()

        override val isLayout: MutableLiveData<Boolean> = changeLayout.isLayout

        override val layoutWidth: MutableLiveData<Int> = changeLayout.layoutWidth

        override fun notes(): LiveData<List<Notes>> = notesUseCase.invoke()

        override suspend fun delete(notes: Notes) = deleteNoteUseCase.invoke(notes)

        override suspend fun deleteAll() = deleteAllNoteUseCase.invoke()

        override fun like(notes: Notes): Int =
            changeFavorite.like(notes)

        override fun likeShow(notes: Notes): Int = changeFavorite.likeShow(notes)
    }
}
