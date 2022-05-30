package com.example.notesv2.presentation.viewmodel

import androidx.core.os.bundleOf
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.interactor.FavoriteInteractor
import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val interactor: FavoriteInteractor,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val dispatchers: CoroutineContext
) : BaseViewModel() {

    private lateinit var findNavController: NavController

    fun setNav(findNavController: NavController) {
        this.findNavController = findNavController
    }

    fun favoriteNotes() = interactor.favoriteNotes()

    fun delete(item: Notes) =
        viewModelScope.launch(dispatchers) {
            interactor.delete(item)
        }

    fun visibility(list: List<Notes>) = interactor.changeVisibility(list)

    fun like(notes: Notes): Int {
        viewModelScope.launch(dispatchers) {
            updateNoteUseCase.invoke(notes)
        }

        return interactor.like(notes)
    }

    fun likeShow(notes: Notes) = interactor.likeShow(notes)

    fun themeClick(uid: Int, navigate: Boolean = false) {
        val bundle = bundleOf("uid" to uid, "navigate" to navigate)

        findNavController.navigate(R.id.navigation_details, bundle)
    }
}