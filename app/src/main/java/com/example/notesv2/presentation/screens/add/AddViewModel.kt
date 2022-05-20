package com.example.notesv2.presentation.screens.add

import android.annotation.SuppressLint
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.entities.NotesDomain
import com.example.notesv2.domain.interactor.InteractorAdd
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
@SuppressLint("StaticFieldLeak")
class AddViewModel @Inject constructor(
    private val interactor: InteractorAdd
) : BaseViewModel() {

    fun choiceStrategy(theme: String, content: String) =
        interactor.addNote.choiceStrategy(
            NotesDomain(theme = theme, content = content), interactor.toastContext
        )
}

