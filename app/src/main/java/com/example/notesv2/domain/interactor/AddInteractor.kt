package com.example.notesv2.domain.interactor

import android.content.Context
import android.widget.Toast
import com.example.notesv2.THEME_IS_EMPTY
import com.example.notesv2.THEME_IS_LONG
import com.example.notesv2.UNKNOWN_ERROR
import com.example.notesv2.core.DoToast
import com.example.notesv2.domain.interactor.usecases.InsertNoteUseCase
import com.example.notesv2.domain.model.Notes
import javax.inject.Inject

interface AddInteractor {

    suspend fun addNote(theme: String, content: String)

    class Base @Inject constructor(
        private val insertNoteUseCase: InsertNoteUseCase,
        private val toast: DoToast,
        private val context: Context
    ) : AddInteractor {

        override suspend fun addNote(theme: String, content: String) {
            val notes = Notes(theme = theme, content = content)

            if (theme.isNotEmpty() && theme.length < 24) insertNoteUseCase.invoke(notes)
            else if (theme.isEmpty()) toast.doToast(context, THEME_IS_EMPTY, Toast.LENGTH_LONG)
            else if (theme.length >= 24) toast.doToast(context, THEME_IS_LONG, Toast.LENGTH_LONG)
            else toast.doToast(context, UNKNOWN_ERROR, Toast.LENGTH_LONG)
        }
    }
}