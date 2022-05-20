package com.example.notesv2.domain.interactor

import com.example.notesv2.domain.usecases.ChangeLayoutUseCase
import com.example.notesv2.domain.usecases.DaoRealizationUseCases
import com.example.notesv2.domain.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.usecases.FavoriteChangeUseCase
import javax.inject.Inject

class InteractorHome @Inject constructor(
    daoRealizationUseCases: DaoRealizationUseCases,
    favoriteChangeUseCase: FavoriteChangeUseCase,
    changeLayoutUseCase: ChangeLayoutUseCase,
    visibilityUseCase: EmptyVisibilityUseCase,
) {
    val daoRealization = daoRealizationUseCases
    val favoriteChange = favoriteChangeUseCase
    val changeLayout = changeLayoutUseCase
    val visibility = visibilityUseCase
}