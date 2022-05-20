package com.example.notesv2.presentation.screens.detail

import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.interactor.InteractorDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val interactor: InteractorDetail,
) : BaseViewModel() {

    fun update(notes: Notes) = interactor.daoRealization.update(notes)
    fun findByUid(uid: Int) = interactor.daoRealization.findByUid(uid)

    fun saveCLick(item: Notes, findNavController: NavController, navigate: Boolean) {
        navigateTo(findNavController, navigate)
        update(Notes(uid = item.uid, theme = item.theme, content = item.content))
    }

    fun navigateTo(findNavController: NavController, navigate: Boolean) {
        if (navigate) findNavController.navigate(R.id.navigation_home)
        else findNavController.navigate(R.id.navigation_favorite)
    }
}
