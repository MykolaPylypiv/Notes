package com.example.notesv2.domain.repositories

import androidx.lifecycle.LiveData
import com.example.notesv2.domain.model.Notes

interface Repository {

    fun getLikeNotes(): LiveData<List<Notes>>
    fun getAllNotes(): LiveData<List<Notes>>

    suspend fun insert(notes: Notes)
    suspend fun delete(notes: Notes)
    suspend fun update(notes: Notes)

    fun findByUid(uid: Int): LiveData<Notes>

    suspend fun deleteAll()

}