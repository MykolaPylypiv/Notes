package com.example.notesv2.presentation.screens.favorite

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.interactor.InteractorFavorite
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val interactor: InteractorFavorite
) : BaseViewModel() {

    private lateinit var findNavController: NavController

    fun setNav(findNavController: NavController) {
        this.findNavController = findNavController
    }

    fun getLikeNotes() = interactor.daoRealization.getLikeNotes()
    fun delete(notes: Notes) = interactor.daoRealization.delete(notes)
    fun update(notes: Notes) = interactor.daoRealization.update(notes)

    fun visibility(list: List<Notes>) = interactor.visibility.visible(list)

    fun like(notes: Notes) = interactor.favoriteChange.like(notes)
    fun likeShow(notes: Notes) = interactor.favoriteChange.likeShow(notes)

    fun themeClick(uid: Int, navigate: Boolean = false) {
        val bundle = bundleOf("uid" to uid, "navigate" to navigate)

        findNavController.navigate(R.id.navigation_details, bundle)
    }
}