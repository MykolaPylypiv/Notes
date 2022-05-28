package com.example.notesv2.domain.interactor.usecases.noteFunction

import com.example.notesv2.domain.repositories.Repository
import javax.inject.Inject

class DeleteAllNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun invoke() = repository.deleteAll()
}