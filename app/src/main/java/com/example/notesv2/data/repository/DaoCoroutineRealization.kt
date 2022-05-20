package com.example.notesv2.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.domain.repositories.DaoCoroutineRepository
import com.example.notesv2.domain.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DaoCoroutineRealization  @Inject constructor(private val repository: NoteRepository) : ViewModel(),
    DaoCoroutineRepository {

    override fun getAllNotes() = repository.getAllNotes()

    override fun getLikeNotes() = repository.getLikeNotes()

    override fun insert(notes: Notes) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(notes) {}
        }

    override fun delete(notes: Notes) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(notes) {}
        }

    override fun update(notes: Notes) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(notes) {}
        }

    override fun findByUid(uid: Int) = repository.findByUid(uid)

    override fun deleteAll() =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
}