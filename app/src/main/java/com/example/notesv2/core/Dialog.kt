package com.example.notesv2.core

import android.app.AlertDialog
import androidx.fragment.app.FragmentActivity

interface Dialog<T> {

    fun createDeleteDialog(activity: FragmentActivity, viewModel: T): AlertDialog.Builder

    fun showDialog(activity: FragmentActivity, viewModel: T): AlertDialog?
}