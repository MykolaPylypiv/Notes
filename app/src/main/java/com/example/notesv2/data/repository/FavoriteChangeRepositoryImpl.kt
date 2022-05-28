package com.example.notesv2.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesv2.DISLIKE_ICON
import com.example.notesv2.LIKE_ICON
import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.ChangeFavoriteRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteChangeRepositoryImpl @Inject constructor() : ViewModel(), ChangeFavoriteRepository {

    override fun likeShow(notes: Notes) =
        if (notes.isLike) LIKE_ICON
        else DISLIKE_ICON

    override fun like(notes: Notes, updateNoteUseCase: UpdateNoteUseCase): Int {
        notes.isLike = !notes.isLike

        viewModelScope.launch {
            updateNoteUseCase.invoke(notes)
        }

        return likeShow(notes)
    }
}