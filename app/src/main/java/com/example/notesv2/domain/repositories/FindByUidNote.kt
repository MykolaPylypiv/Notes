package com.example.notesv2.domain.repositories

import androidx.lifecycle.LiveData
import com.example.notesv2.domain.model.Notes

interface FindByUidNote {
    fun findByUid(uid: Int): LiveData<Notes>
}