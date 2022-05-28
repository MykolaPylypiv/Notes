package com.example.notesv2.domain.repositories

import com.example.notesv2.domain.interactor.usecases.noteFunction.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes

interface FavoriteChangeRepository {

    fun like(notes: Notes, updateNoteUseCase: UpdateNoteUseCase): Int

    fun likeShow(notes: Notes): Int
}