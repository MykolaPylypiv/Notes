package com.example.notesv2.domain.repositories

import com.example.notesv2.domain.model.Notes

interface InsertNote {
    suspend fun insert(notes: Notes)
}