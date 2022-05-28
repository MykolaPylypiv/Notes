package com.example.notesv2.domain.usecases.noteFunction

import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend fun invoke(item: Notes) = repository.update(item)
}