package com.example.notesv2.domain.usecases

import androidx.lifecycle.LiveData
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.DaoCoroutineRepository
import javax.inject.Inject

class DaoRealizationUseCases @Inject constructor(
    private val daoCoroutineRealization: DaoCoroutineRepository,
) {

    fun getLikeNotes(): LiveData<List<Notes>> =
        daoCoroutineRealization.getLikeNotes()

    fun getAllNotes(): LiveData<List<Notes>> =
        daoCoroutineRealization.getAllNotes()

    fun insert(notes: Notes) =
        daoCoroutineRealization.insert(notes)

    fun delete(notes: Notes) =
        daoCoroutineRealization.delete(notes)

    fun update(notes: Notes) =
        daoCoroutineRealization.update(notes)

    fun findByUid(uid: Int): LiveData<Notes> =
        daoCoroutineRealization.findByUid(uid)

    fun deleteAll() =
        daoCoroutineRealization.deleteAll()
}
