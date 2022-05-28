package com.example.notesv2.presentation.dialog

import android.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.example.notesv2.R
import com.example.notesv2.core.Dialog
import com.example.notesv2.presentation.screens.home.HomeViewModel
import javax.inject.Inject

class DeleteDialog @Inject constructor() : Dialog<HomeViewModel> {

    override fun createDeleteDialog(
        activity: FragmentActivity,
        viewModel: HomeViewModel
    ): AlertDialog.Builder =
        AlertDialog.Builder(activity)
            .setTitle(titleDialog)
            .setMessage(messageDialog)
            .setIcon(dialogIcon)
            .setPositiveButton(positiveDialog) { _, _ ->
                viewModel.deleteAll()
            }
            .setNegativeButton(negativeDialog) { dialog, _ ->
                dialog.cancel()
            }

    override fun showDialog(activity: FragmentActivity, viewModel: HomeViewModel):
            AlertDialog = createDeleteDialog(activity, viewModel).show()

    companion object {
        const val dialogIcon = R.drawable.ic_baseline_error_outline_24
        const val titleDialog = "Important message"
        const val messageDialog = "Are you sure you want to delete all notes?"
        const val positiveDialog = "Yes, I want"
        const val negativeDialog = "No, I don't want"
    }
}
