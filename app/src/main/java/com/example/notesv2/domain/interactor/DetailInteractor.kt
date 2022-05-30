package com.example.notesv2.domain.interactor

import android.content.Context
import android.widget.Toast
import com.example.notesv2.R
import com.example.notesv2.THEME_IS_EMPTY
import com.example.notesv2.core.DoToast
import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes
import javax.inject.Inject

interface DetailInteractor {

    suspend fun saveChange(item: Notes)

    fun navigateTo(navigate: Boolean): Int

    class Base @Inject constructor(
        private val updateNoteUseCase: UpdateNoteUseCase,
        private val toast: DoToast,
        private val context: Context,
    ) : DetailInteractor {

        override suspend fun saveChange(item: Notes) =
            if (item.theme?.isEmpty() == false) updateNoteUseCase.invoke(item)
            else toast.doToast(context, THEME_IS_EMPTY, Toast.LENGTH_LONG)

        override fun navigateTo(navigate: Boolean): Int =
            if (navigate) R.id.navigation_home
            else R.id.navigation_favorite
    }
}