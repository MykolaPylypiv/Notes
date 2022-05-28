package com.example.notesv2.domain.usecases.noteFunction

import com.example.notesv2.domain.repositories.NoteRepository
import javax.inject.Inject

class FindByUidNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    fun invoke(uid: Int) = repository.findByUid(uid)
}