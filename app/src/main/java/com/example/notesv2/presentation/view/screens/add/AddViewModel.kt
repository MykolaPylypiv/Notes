package com.example.notesv2.presentation.view.screens.add

import android.annotation.SuppressLint
import androidx.lifecycle.viewModelScope
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.interactor.usecases.noteFunction.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@SuppressLint("StaticFieldLeak")
class AddViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase
) : BaseViewModel() {

    fun insert(item: Notes) =
        viewModelScope.launch {
            insertNoteUseCase.invoke(item)
        }
}

