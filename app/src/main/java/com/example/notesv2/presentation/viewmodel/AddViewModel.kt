package com.example.notesv2.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.viewModelScope
import com.example.notesv2.core.BaseViewModel
import com.example.notesv2.domain.interactor.AddInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
@SuppressLint("StaticFieldLeak")
class AddViewModel @Inject constructor(
    private val interactor: AddInteractor,
    private val dispatchers: CoroutineContext
) : BaseViewModel() {

    fun addNote(theme: String, content: String) =
        viewModelScope.launch(dispatchers) {
            interactor.addNote(theme, content)
        }
}

