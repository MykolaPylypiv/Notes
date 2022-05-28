package com.example.notesv2.di

import com.example.notesv2.core.Dialog
import com.example.notesv2.presentation.view.dialog.DeleteDialog
import com.example.notesv2.presentation.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DialogModule {

    @Binds
    abstract fun bindDeleteDialog(
        deleteDialog: DeleteDialog
    ): Dialog<HomeViewModel>
}