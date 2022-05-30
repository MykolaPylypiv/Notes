package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.DeleteNote
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: DeleteNote
) {

    suspend fun invoke(item: Notes) = repository.delete(item)
}