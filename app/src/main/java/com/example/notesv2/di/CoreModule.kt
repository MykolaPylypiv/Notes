package com.example.notesv2.di

import com.example.notesv2.core.DoToast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class CoreModule {

    @Provides
    fun provideToast(): DoToast = DoToast.Base()
}