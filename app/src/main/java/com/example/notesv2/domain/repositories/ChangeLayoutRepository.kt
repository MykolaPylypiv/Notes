package com.example.notesv2.domain.repositories

import androidx.lifecycle.MutableLiveData

interface ChangeLayoutRepository {

    fun changeLayoutManager()

    fun backgroundLayout(): Int

    val isLayout: MutableLiveData<Boolean>

    val layoutWidth: MutableLiveData<Int>
}