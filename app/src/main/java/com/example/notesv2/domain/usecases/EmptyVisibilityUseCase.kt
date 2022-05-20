package com.example.notesv2.domain.usecases

import com.example.notesv2.data.entities.Notes
import com.example.notesv2.data.repository.EmptyVisibilityRealization
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import javax.inject.Inject

class EmptyVisibilityUseCase @Inject constructor(private val emptyVisibilityRealization: EmptyVisibilityRepository) {

    fun visible(list: List<Notes>) = emptyVisibilityRealization.visible(list)
}