package com.example.notesv2.di

import com.example.notesv2.core.ChoiceStrategy
import com.example.notesv2.core.DoToast
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.data.repository.AddNotesStrategy
import com.example.notesv2.domain.usecases.AddNoteUseCases
import com.example.notesv2.domain.usecases.DaoRealizationUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AddNotesModule {

    @Provides
    fun provideAddNotesStrategy(): ChoiceStrategy<Notes, AddNotesStrategy> = ChoiceStrategy.Base()


    @Provides
    fun provideAddNotesUseCase(
        daoRealizationUseCases: DaoRealizationUseCases,
        editNotes: ChoiceStrategy<Notes, AddNotesStrategy>,
        toast: DoToast,
    ): AddNoteUseCases = AddNoteUseCases(daoRealizationUseCases, editNotes, toast)
}