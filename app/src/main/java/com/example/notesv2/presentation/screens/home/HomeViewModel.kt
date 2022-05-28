package com.example.notesv2.presentation.screens.home

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.interactor.InteractorHome
import com.example.notesv2.domain.usecases.noteFunction.DeleteAllNoteUseCase
import com.example.notesv2.domain.usecases.noteFunction.DeleteNoteUseCase
import com.example.notesv2.domain.usecases.noteFunction.NotesUseCase
import com.example.notesv2.presentation.dialog.DeleteDialog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val notesUseCase: NotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val deleteAllNoteUseCase: DeleteAllNoteUseCase,
    private val interactor: InteractorHome,
    private val deleteDialog: DeleteDialog
) : BaseViewModel() {

    private lateinit var findNavController: NavController

    fun setNav(findNavController: NavController) {
        this.findNavController = findNavController
    }

    fun showDialog(activity: FragmentActivity, viewModel: HomeViewModel) =
        deleteDialog.showDialog(activity, viewModel)

    fun getAllNotes() = notesUseCase.invoke()

    fun delete(item: Notes) =
        viewModelScope.launch {
            deleteNoteUseCase.invoke(item)
        }

    fun deleteAll() =
        viewModelScope.launch {
            deleteAllNoteUseCase.invoke()
        }

    fun changeLayoutManager() = interactor.changeLayout.changeLayoutManager()
    fun backgroundLayout() = interactor.changeLayout.backgroundChangeLayout()
    val isLayout = interactor.changeLayout.isLayout
    val layoutWidth = interactor.changeLayout.layoutWidth

    fun visible(list: List<Notes>) = interactor.visibility.visible(list)

    fun like(notes: Notes) = interactor.favoriteChange.like(notes)
    fun likeShow(notes: Notes) = interactor.favoriteChange.likeShow(notes)

    fun themeClick(uid: Int, navigate: Boolean = true) {
        val bundle = bundleOf("uid" to uid, "navigate" to navigate)
        findNavController.navigate(R.id.navigation_details, bundle)
    }
}