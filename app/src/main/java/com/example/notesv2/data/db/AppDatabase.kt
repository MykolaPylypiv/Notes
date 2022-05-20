package com.example.notesv2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesv2.data.db.room.NotesDao
import com.example.notesv2.data.entities.Notes

@Database(entities = [Notes::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}
