package com.example.notesv2.data.repository.cachedatasource

import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.repositories.DeleteAllNotes
import javax.inject.Inject

interface DeleteAllNoteCacheDataSource : DeleteAllNotes {

    class Base @Inject constructor(private val notesDao: NotesDao) : DeleteAllNoteCacheDataSource {
        override suspend fun deleteAll() = notesDao.deleteAll()
    }
}