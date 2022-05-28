package com.example.notesv2.presentation.screens.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.notesv2.R
import com.example.notesv2.core.BaseFragment
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAddBinding.inflate(inflater, container, false)

    private val viewModel: AddViewModel by viewModels()

    override fun init() {
        binding.saveButton.setOnClickListener {
            val theme = binding.themeAddInputEditText.text.toString()
            val content = binding.contentAddInputEditText.text.toString()
            viewModel.insert(Notes(theme = theme, content = content))
        }

        binding.toolbarAdd.textView.setText(R.string.add_notes)
    }
}
