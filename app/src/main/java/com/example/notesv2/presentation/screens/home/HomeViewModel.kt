package com.example.notesv2.presentation.screens.home

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.interactor.InteractorHome
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import com.example.notesv2.presentation.dialog.DeleteDialog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactor: InteractorHome,
    private val deleteDialog: DeleteDialog
) : BaseViewModel(), ChangeLayoutRepository, EmptyVisibilityRepository, FavoriteChangeRepository {

    private lateinit var findNavController: NavController

    fun setNav(findNavController: NavController) {
        this.findNavController = findNavController
    }

    fun showDialog(activity: FragmentActivity, viewModel: HomeViewModel) =
        deleteDialog.showDialog(activity, viewModel)

    fun getAllNotes() = interactor.daoRealization.getAllNotes()
    fun delete(notes: Notes) = interactor.daoRealization.delete(notes)
    fun update(notes: Notes) = interactor.daoRealization.update(notes)
    fun deleteAll() = interactor.daoRealization.deleteAll()

    override fun changeLayoutManager() = interactor.changeLayout.changeLayoutManager()
    override fun backgroundLayout() = interactor.changeLayout.backgroundChangeLayout()
    override val isLayout = interactor.changeLayout.isLayout
    override val layoutWidth = interactor.changeLayout.layoutWidth

    override fun visible(list: List<Notes>) = interactor.visibility.visible(list)

    override fun like(notes: Notes) = interactor.favoriteChange.like(notes)
    override fun likeShow(notes: Notes) = interactor.favoriteChange.likeShow(notes)

    fun themeClick(uid: Int, navigate: Boolean = true) {
        val bundle = bundleOf("uid" to uid, "navigate" to navigate)
        findNavController.navigate(R.id.navigation_details, bundle)
    }
}