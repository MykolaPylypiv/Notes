package com.example.notesv2.di

import com.example.notesv2.data.repository.ChangeLayoutRealization
import com.example.notesv2.data.repository.EmptyVisibilityRealization
import com.example.notesv2.data.repository.FavoriteChangeRealization
import com.example.notesv2.domain.repositories.ChangeLayoutRepository
import com.example.notesv2.domain.repositories.EmptyVisibilityRepository
import com.example.notesv2.domain.repositories.FavoriteChangeRepository
import com.example.notesv2.domain.usecases.noteFunction.UpdateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun provideEmptyVisibilityRealization():
            EmptyVisibilityRepository = EmptyVisibilityRealization()


    @Provides
    fun provideFavoriteChangeRealization(updateNoteUseCase: UpdateNoteUseCase): FavoriteChangeRepository =
        FavoriteChangeRealization(updateNoteUseCase)


    @Provides
    fun provideChangeLayoutRealization(): ChangeLayoutRepository = ChangeLayoutRealization()

}