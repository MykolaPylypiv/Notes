package com.example.notesv2.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.notesv2.ARROW_VIEW
import com.example.notesv2.GRID_VIEW
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import javax.inject.Inject

class ChangeLayoutRepositoryImpl @Inject constructor() : ChangeLayoutRepository {

    override val isLayout = MutableLiveData<Boolean>()

    override val layoutWidth = MutableLiveData<Int>()

    init {
        isLayout.value = false
        layoutWidth.value = 850
    }

    override fun changeLayoutManager() {
        if (isLayout.value == true) layoutWidth.value = 600 else layoutWidth.value = 1000
        isLayout.value = !isLayout.value!!
    }

    override fun backgroundLayout() =
        if (isLayout.value == true) ARROW_VIEW else GRID_VIEW
}
