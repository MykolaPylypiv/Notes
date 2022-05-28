package com.example.notesv2.data.repository

import androidx.lifecycle.LiveData
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.domain.repositories.NoteRepository
import javax.inject.Inject

class NoteRealization  @Inject constructor(private val notesDao: NotesDao) : NoteRepository {

    override fun getAllNotes(): LiveData<List<Notes>> = notesDao.getAll()
    override fun getLikeNotes(): LiveData<List<Notes>> = notesDao.getLikeNotes()

    override suspend fun insert(notes: Notes) = notesDao.insert(notes)
    override suspend fun delete(notes: Notes) = notesDao.delete(notes)
    override suspend fun update(notes: Notes) = notesDao.update(notes)

    override fun findByUid(uid: Int): LiveData<Notes> = notesDao.findByUid(uid)

    override suspend fun deleteAll() = notesDao.deleteAll()
}
