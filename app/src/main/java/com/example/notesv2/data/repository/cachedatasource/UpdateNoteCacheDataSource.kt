package com.example.notesv2.data.repository.cachedatasource

import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.UpdateNote
import javax.inject.Inject

interface UpdateNoteCacheDataSource : UpdateNote {

    class Base @Inject constructor(private val notesDao: NotesDao) : UpdateNoteCacheDataSource {
        override suspend fun update(notes: Notes) = notesDao.update(notes)
    }
}
