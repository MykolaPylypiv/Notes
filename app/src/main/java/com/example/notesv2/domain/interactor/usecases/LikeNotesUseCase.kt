package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.repositories.Repository
import javax.inject.Inject

class LikeNotesUseCase @Inject constructor(
    private val repository: Repository
) {

    fun invoke() = repository.getLikeNotes()
}