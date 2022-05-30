package com.example.notesv2.data.repository

import com.example.notesv2.DISLIKE_ICON
import com.example.notesv2.LIKE_ICON
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.ChangeFavoriteRepository
import javax.inject.Inject

class ChangeFavoriteRepositoryImpl @Inject constructor() : ChangeFavoriteRepository {

    override fun likeShow(notes: Notes): Int =
        if (notes.isLike) LIKE_ICON
        else DISLIKE_ICON

    override fun like(notes: Notes): Int {
        notes.isLike = !notes.isLike

        return likeShow(notes)
    }
}