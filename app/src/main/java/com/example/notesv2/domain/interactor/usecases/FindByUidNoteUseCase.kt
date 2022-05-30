package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.repositories.FindByUidNote
import javax.inject.Inject

class FindByUidNoteUseCase @Inject constructor(
    private val repository: FindByUidNote
) {

    fun invoke(uid: Int) = repository.findByUid(uid)
}