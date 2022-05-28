package com.example.notesv2.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.notesv2.R
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import javax.inject.Inject

class ChangeLayoutRealization @Inject constructor() : ChangeLayoutRepository {

    override val isLayout = MutableLiveData<Boolean>()

    override val layoutWidth = MutableLiveData<Int>()

    init {
        isLayout.value = false
        layoutWidth.value = 850
    }

    override fun changeLayoutManager() {
        if (isLayout.value == true) layoutWidth.value = 850 else layoutWidth.value = 1000
        isLayout.value = !isLayout.value!!
    }

    override fun backgroundLayout() =
        if (isLayout.value == true) ARROW_VIEW else GRID_VIEW

    companion object {
        const val GRID_VIEW = R.drawable.ic_outline_grid_view_24
        const val ARROW_VIEW = R.drawable.ic_round_view_list_24
    }
}
