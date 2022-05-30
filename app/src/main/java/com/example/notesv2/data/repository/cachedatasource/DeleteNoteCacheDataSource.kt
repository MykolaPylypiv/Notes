package com.example.notesv2.data.repository.cachedatasource

import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.DeleteNote
import javax.inject.Inject

interface DeleteNoteCacheDataSource : DeleteNote {

    class Base @Inject constructor(private val notesDao: NotesDao) : DeleteNoteCacheDataSource {
        override suspend fun delete(notes: Notes) = notesDao.delete(notes)
    }
}