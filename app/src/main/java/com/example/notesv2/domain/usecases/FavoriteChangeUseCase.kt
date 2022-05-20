package com.example.notesv2.domain.usecases

import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import javax.inject.Inject

class FavoriteChangeUseCase @Inject constructor(private val favoriteChangeRepository: FavoriteChangeRepository) {

    fun like(notes: Notes) = favoriteChangeRepository.like(notes)

    fun likeShow(notes: Notes) = favoriteChangeRepository.likeShow(notes)
}