package com.example.notesv2.domain.usecases.noteFunction

import com.example.notesv2.domain.repositories.NoteRepository
import javax.inject.Inject

class DeleteAllNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend fun invoke() = repository.deleteAll()
}