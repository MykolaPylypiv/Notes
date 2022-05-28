package com.example.notesv2.domain.interactor.usecases

import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import javax.inject.Inject

class ChangeLayoutUseCase @Inject constructor(private val changeLayoutRepository: ChangeLayoutRepository) {

    fun changeLayoutManager() = changeLayoutRepository.changeLayoutManager()

    fun backgroundChangeLayout() = changeLayoutRepository.backgroundLayout()

    val isLayout = changeLayoutRepository.isLayout

    val layoutWidth = changeLayoutRepository.layoutWidth
}
