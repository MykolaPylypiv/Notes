package com.example.notesv2.domain.interactor.usecases

import androidx.lifecycle.LiveData
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.Repository
import javax.inject.Inject

class NotesUseCase @Inject constructor(
    private val repository: Repository,
) {

    fun invoke(): LiveData<List<Notes>> = repository.notes()
}