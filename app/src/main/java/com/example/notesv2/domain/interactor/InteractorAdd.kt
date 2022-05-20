package com.example.notesv2.domain.interactor

import android.content.Context
import com.example.notesv2.domain.usecases.AddNoteUseCases
import javax.inject.Inject

class InteractorAdd @Inject constructor(
    addNoteUseCase: AddNoteUseCases,
    context: Context
) {
    val addNote = addNoteUseCase
    val toastContext = context
}