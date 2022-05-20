package com.example.notesv2.app

import android.app.Application
import com.example.notesv2.data.db.AppDatabase
import com.example.notesv2.data.repository.NoteRealization
import com.example.notesv2.domain.repositories.NoteRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application()
