package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.InsertNote
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(
    private val repository: InsertNote
) {

    suspend fun invoke(item: Notes) = repository.insert(item)
}