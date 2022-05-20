package com.example.notesv2.di

import android.content.Context
import androidx.room.Room
import com.example.notesv2.data.db.AppDatabase
import com.example.notesv2.data.repository.NoteRealization
import com.example.notesv2.domain.repositories.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRepository(database: AppDatabase): NoteRepository =
        NoteRealization(database.notesDao())


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context = context
}