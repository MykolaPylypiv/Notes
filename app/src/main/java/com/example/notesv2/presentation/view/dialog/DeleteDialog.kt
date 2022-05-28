package com.example.notesv2.presentation.view.dialog

import android.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.example.notesv2.*
import com.example.notesv2.core.Dialog
import com.example.notesv2.presentation.viewmodel.HomeViewModel
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
}
