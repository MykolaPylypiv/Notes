package com.example.notesv2.di

import com.example.notesv2.core.Dialog
import com.example.notesv2.presentation.dialog.DeleteDialog
import com.example.notesv2.presentation.screens.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DialogModule {

    @Binds
    abstract fun provideDeleteDialog(
        deleteDialog: DeleteDialog
    ): Dialog<HomeViewModel>
}