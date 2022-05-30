package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.repositories.DeleteAllNotes
import javax.inject.Inject

class DeleteAllNoteUseCase @Inject constructor(
    private val repository: DeleteAllNotes
)  {

    suspend fun invoke() = repository.deleteAll()
}