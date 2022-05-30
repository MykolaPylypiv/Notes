package com.example.notesv2.data.repository.cachedatasource

import androidx.lifecycle.LiveData
import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.FavoriteNote
import javax.inject.Inject

interface FavoriteListCacheDataSource : FavoriteNote {

    class Base @Inject constructor(private val notesDao: NotesDao) : FavoriteListCacheDataSource {
        override fun favoriteNotes(): LiveData<List<Notes>> = notesDao.getLikeNotes()
    }
}