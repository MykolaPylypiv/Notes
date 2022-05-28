package com.example.notesv2.domain.repositories

import androidx.lifecycle.LiveData
import com.example.notesv2.domain.model.Notes

interface Repository : GetAllNotes, GetLikeNotes, FindByUidNote,
    InsertNote, DeleteNote, UpdateNote, DeleteAllNotes

interface GetAllNotes {

    fun getAllNotes(): LiveData<List<Notes>>
}

interface GetLikeNotes {

    fun getLikeNotes(): LiveData<List<Notes>>
}

interface FindByUidNote {

    fun findByUid(uid: Int): LiveData<Notes>
}

interface InsertNote {

    suspend fun insert(notes: Notes)
}

interface DeleteNote {

    suspend fun delete(notes: Notes)
}

interface UpdateNote {

    suspend fun update(notes: Notes)
}

interface DeleteAllNotes {

    suspend fun deleteAll()
}