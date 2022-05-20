package com.example.notesv2.domain.interactor

import com.example.notesv2.domain.usecases.DaoRealizationUseCases
import com.example.notesv2.domain.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.usecases.FavoriteChangeUseCase
import javax.inject.Inject

class InteractorFavorite @Inject constructor(
    daoRealizationUseCases: DaoRealizationUseCases,
    favoriteChangeUseCase: FavoriteChangeUseCase,
    visibilityUseCase: EmptyVisibilityUseCase,
) {
    val daoRealization = daoRealizationUseCases
    val favoriteChange = favoriteChangeUseCase
    val visibility = visibilityUseCase
}