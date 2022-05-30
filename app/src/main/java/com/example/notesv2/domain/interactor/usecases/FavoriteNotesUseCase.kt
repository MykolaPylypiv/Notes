package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.repositories.FavoriteNote
import javax.inject.Inject

class FavoriteNotesUseCase @Inject constructor(
    private val repository: FavoriteNote
) {

    fun invoke() = repository.favoriteNotes()
}