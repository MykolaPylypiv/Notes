package com.example.notesv2.domain.repositories

import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.usecases.noteFunction.UpdateNoteUseCase

interface FavoriteChangeRepository {

    fun like(notes: Notes, updateNoteUseCase: UpdateNoteUseCase): Int

    fun likeShow(notes: Notes): Int
}