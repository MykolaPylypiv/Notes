package com.example.notesv2.data.repository.cachedatasource

import androidx.lifecycle.LiveData
import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.domain.repositories.FindByUidNote
import javax.inject.Inject

interface FindByUidNoteCacheDataSource : FindByUidNote {

    class Base @Inject constructor(private val notesDao: NotesDao) : FindByUidNoteCacheDataSource {
        override fun findByUid(uid: Int): LiveData<Notes> = notesDao.findByUid(uid)
    }
}