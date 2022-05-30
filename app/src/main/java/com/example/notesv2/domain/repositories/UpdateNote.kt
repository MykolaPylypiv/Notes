package com.example.notesv2.domain.repositories

import com.example.notesv2.domain.model.Notes

interface UpdateNote {
    suspend fun update(notes: Notes)
}