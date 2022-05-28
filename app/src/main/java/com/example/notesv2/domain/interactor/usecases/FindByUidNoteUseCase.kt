package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.repositories.Repository
import javax.inject.Inject

class FindByUidNoteUseCase @Inject constructor(
    private val repository: Repository
) {

    fun invoke(uid: Int) = repository.findByUid(uid)
}