package com.example.notesv2.di

import com.example.notesv2.data.repository.ChangeLayoutRealization
import com.example.notesv2.data.repository.DaoCoroutineRealization
import com.example.notesv2.data.repository.EmptyVisibilityRealization
import com.example.notesv2.data.repository.FavoriteChangeRealization
import com.example.notesv2.domain.repositories.*
import com.example.notesv2.domain.usecases.DaoRealizationUseCases
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
    fun provideFavoriteChangeRealization(daoRealizationUseCases: DaoRealizationUseCases): FavoriteChangeRepository =
        FavoriteChangeRealization(daoRealizationUseCases = daoRealizationUseCases)


    @Provides
    fun provideChangeLayoutRealization(): ChangeLayoutRepository = ChangeLayoutRealization()


    @Provides
    fun provideDaoCoroutineRealization(repository: NoteRepository):
            DaoCoroutineRepository = DaoCoroutineRealization(repository = repository)
}