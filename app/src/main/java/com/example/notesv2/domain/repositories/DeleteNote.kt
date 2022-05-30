package com.example.notesv2.domain.repositories

import com.example.notesv2.domain.model.Notes

interface DeleteNote {
    suspend fun delete(notes: Notes)
}