package com.example.notesv2.presentation.view.screens.favorite

import androidx.core.os.bundleOf
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.interactor.InteractorFavorite
import com.example.notesv2.domain.interactor.usecases.noteFunction.DeleteNoteUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.LikeNotesUseCase
import com.example.notesv2.domain.interactor.usecases.noteFunction.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val likeNotesUseCase: LikeNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val interactor: InteractorFavorite
) : BaseViewModel() {

    private lateinit var findNavController: NavController

    fun setNav(findNavController: NavController) {
        this.findNavController = findNavController
    }

    fun getLikeNotes() = likeNotesUseCase.invoke()

    fun delete(item: Notes) =
        viewModelScope.launch {
            deleteNoteUseCase.invoke(item)
        }

    fun update(item: Notes) =
        viewModelScope.launch {
            updateNoteUseCase.invoke(item)
        }

    fun visibility(list: List<Notes>) = interactor.visibility.visible(list)

    fun like(notes: Notes) = interactor.favoriteChange.like(notes)
    fun likeShow(notes: Notes) = interactor.favoriteChange.likeShow(notes)

    fun themeClick(uid: Int, navigate: Boolean = false) {
        val bundle = bundleOf("uid" to uid, "navigate" to navigate)

        findNavController.navigate(R.id.navigation_details, bundle)
    }
}