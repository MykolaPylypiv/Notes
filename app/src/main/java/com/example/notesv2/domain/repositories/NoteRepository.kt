package com.example.notesv2.domain.repositories

import androidx.lifecycle.LiveData
import com.example.notesv2.data.entities.Notes

interface NoteRepository {

    fun getLikeNotes(): LiveData<List<Notes>>
    fun getAllNotes(): LiveData<List<Notes>>

    suspend fun insert(notes: Notes, onSuccess: () -> Unit)
    suspend fun delete(notes: Notes, onSuccess: () -> Unit)
    suspend fun update(notes: Notes, onSuccess: () -> Unit)

    fun findByUid(uid: Int): LiveData<Notes>

    suspend fun deleteAll()

}