package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.UpdateNote
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: UpdateNote
) {

    suspend fun invoke(item: Notes) = repository.update(item)
}