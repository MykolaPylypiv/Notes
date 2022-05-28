package com.example.notesv2.domain.interactor

import androidx.fragment.app.FragmentActivity
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.interactor.usecases.ChangeLayoutUseCase
import com.example.notesv2.domain.interactor.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.interactor.usecases.FavoriteChangeUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.DeleteAllNoteUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.DeleteNoteUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.NotesUseCase
import com.example.notesv2.presentation.view.dialog.DeleteDialog
import com.example.notesv2.presentation.view.screens.home.HomeViewModel
import javax.inject.Inject

class InteractorHome @Inject constructor(
    private val favoriteChangeUseCase: FavoriteChangeUseCase,
    private val changeLayoutUseCase: ChangeLayoutUseCase,
    private val visibilityUseCase: EmptyVisibilityUseCase,
    private val notesUseCase: NotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val deleteAllNoteUseCase: DeleteAllNoteUseCase,
    private val deleteDialog: DeleteDialog
) {
    fun favoriteChange() = favoriteChangeUseCase
    fun changeLayout() = changeLayoutUseCase
    fun visibility() = visibilityUseCase

    fun getNotes() = notesUseCase.invoke()

    suspend fun delete(item: Notes) = deleteNoteUseCase.invoke(item)

    suspend fun deleteAll() = deleteAllNoteUseCase.invoke()

    fun showDialog(activity: FragmentActivity, viewModel: HomeViewModel) =
        deleteDialog.showDialog(activity, viewModel)
}