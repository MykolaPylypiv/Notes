package com.example.notesv2.data.repository.cachedatasource

import androidx.lifecycle.LiveData
import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.Repository
import javax.inject.Inject

class BaseRepository @Inject constructor(private val notesDao: NotesDao) : Repository {
    override fun notes(): LiveData<List<Notes>> = notesDao.getAll()
}



