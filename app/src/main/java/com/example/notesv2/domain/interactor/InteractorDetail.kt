package com.example.notesv2.domain.interactor

import com.example.notesv2.domain.usecases.DaoRealizationUseCases
import javax.inject.Inject

class InteractorDetail @Inject constructor(
    daoRealizationUseCases: DaoRealizationUseCases,
) {
    val daoRealization = daoRealizationUseCases
}