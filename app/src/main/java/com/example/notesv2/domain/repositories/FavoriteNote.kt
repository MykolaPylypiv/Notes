package com.example.notesv2.domain.repositories

import androidx.lifecycle.LiveData
import com.example.notesv2.domain.model.Notes

interface FavoriteNote {
    fun favoriteNotes(): LiveData<List<Notes>>
}