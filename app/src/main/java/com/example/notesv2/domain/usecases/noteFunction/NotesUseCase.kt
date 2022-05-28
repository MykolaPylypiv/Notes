package com.example.notesv2.domain.usecases.noteFunction

import com.example.notesv2.domain.repositories.NoteRepository
import javax.inject.Inject

class NotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    fun invoke() = repository.getAllNotes()
}