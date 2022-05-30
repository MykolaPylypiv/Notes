package com.example.notesv2.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.interactor.DetailInteractor
import com.example.notesv2.domain.interactor.usecases.FindByUidNoteUseCase
import com.example.notesv2.domain.model.Notes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val interactor: DetailInteractor,
    private val findByUidNoteUseCase: FindByUidNoteUseCase,
    private val dispatchers: CoroutineContext
) : BaseViewModel() {

    fun saveChange(item: Notes) =
        viewModelScope.launch(dispatchers) {
            interactor.saveChange(item)
        }

    fun findByUid(uid: Int) = findByUidNoteUseCase.invoke(uid)

    fun navigateTo(findNavController: NavController, navigate: Boolean) =
        findNavController.navigate(interactor.navigateTo(navigate))
}
