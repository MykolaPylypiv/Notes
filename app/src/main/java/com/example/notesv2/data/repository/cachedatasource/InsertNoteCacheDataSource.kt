package com.example.notesv2.data.repository.cachedatasource

import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.InsertNote
import javax.inject.Inject

interface InsertNoteCacheDataSource : InsertNote {

    class Base @Inject constructor(private val notesDao: NotesDao) : InsertNoteCacheDataSource {
        override suspend fun insert(notes: Notes) = notesDao.insert(notes)
    }
}