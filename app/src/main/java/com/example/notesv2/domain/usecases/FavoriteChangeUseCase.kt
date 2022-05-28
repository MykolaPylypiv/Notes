package com.example.notesv2.domain.usecases

import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import com.example.notesv2.domain.usecases.noteFunction.UpdateNoteUseCase
import javax.inject.Inject

class FavoriteChangeUseCase @Inject constructor(
    private val favoriteChangeRepository: FavoriteChangeRepository,
    private val updateNoteUseCase: UpdateNoteUseCase
) {

    fun like(notes: Notes) = favoriteChangeRepository.like(notes, updateNoteUseCase)

    fun likeShow(notes: Notes) = favoriteChangeRepository.likeShow(notes)
}