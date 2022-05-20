package com.example.notesv2.domain.repositories

import androidx.lifecycle.LiveData
import com.example.notesv2.data.entities.Notes
import kotlinx.coroutines.Job

interface DaoCoroutineRepository {

    fun getAllNotes(): LiveData<List<Notes>>

    fun getLikeNotes(): LiveData<List<Notes>>

    fun insert(notes: Notes): Job

    fun delete(notes: Notes): Job

    fun update(notes: Notes): Job

    fun findByUid(uid: Int): LiveData<Notes>

    fun deleteAll(): Job
}