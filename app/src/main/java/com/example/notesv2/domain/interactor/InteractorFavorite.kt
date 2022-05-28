package com.example.notesv2.domain.interactor

import com.example.notesv2.domain.interactor.usecases.EmptyVisibilityUseCase
import com.example.notesv2.domain.interactor.usecases.FavoriteChangeUseCase
import javax.inject.Inject

class InteractorFavorite @Inject constructor(
    favoriteChangeUseCase: FavoriteChangeUseCase,
    visibilityUseCase: EmptyVisibilityUseCase,
) {
    val favoriteChange = favoriteChangeUseCase
    val visibility = visibilityUseCase
}