package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import javax.inject.Inject

class EmptyVisibilityUseCase @Inject constructor(private val emptyVisibilityRealization: EmptyVisibilityRepository) {

    fun visible(list: List<Notes>) = emptyVisibilityRealization.visible(list)
}