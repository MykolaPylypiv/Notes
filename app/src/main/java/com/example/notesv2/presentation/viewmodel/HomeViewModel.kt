package com.example.notesv2.presentation.viewmodel

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.interactor.HomeInteractor
import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.presentation.view.dialog.DeleteDialog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteDialog: DeleteDialog,
) : BaseViewModel() {

    private lateinit var findNavController: NavController

    fun setNav(findNavController: NavController) {
        this.findNavController = findNavController
    }

    fun showDialog(activity: FragmentActivity, viewModel: HomeViewModel) =
        deleteDialog.showDialog(activity, viewModel)

    fun getAllNotes() = interactor.getAllNotes()

    fun delete(item: Notes) =
        viewModelScope.launch {
            interactor.delete(item)
        }

    fun deleteAll() =
        viewModelScope.launch {
            interactor.deleteAll()
        }

    fun changeLayoutManager() = interactor.changeLayoutManager()

    fun backgroundLayout() = interactor.backgroundLayout()

    val isLayout = interactor.isLayout

    val layoutWidth = interactor.layoutWidth

    fun changeVisibility(list: List<Notes>) = interactor.changeVisibility(list)

    fun like(notes: Notes) = interactor.like(notes, updateNoteUseCase)

    fun likeShow(notes: Notes) = interactor.likeShow(notes)

    fun themeClick(uid: Int, navigate: Boolean = true) {
        val bundle = bundleOf("uid" to uid, "navigate" to navigate)
        findNavController.navigate(R.id.navigation_details, bundle)
    }
}