package com.example.notesv2.domain.repositories

import com.example.notesv2.domain.interactor.usecases.UpdateNoteUseCase
import com.example.notesv2.domain.model.Notes

interface ChangeFavoriteRepository {

    fun like(notes: Notes, updateNoteUseCase: UpdateNoteUseCase): Int

    fun likeShow(notes: Notes): Int
}