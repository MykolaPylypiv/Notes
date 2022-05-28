package com.example.notesv2.presentation.view.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseFragment
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.databinding.FragmentDetailBinding
import com.example.notesv2.presentation.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentDetailBinding.inflate(inflater, container, false)

    private val viewModel: DetailViewModel by viewModels()

    override fun init() {

        val uid = arguments?.get("uid") as Int
        val navigate = arguments?.get("navigate") as Boolean

        viewModel.findByUid(uid).observe(viewLifecycleOwner) {
            binding.themeDetailInputEditText.setText(it.theme)
            binding.contentDetailInputEditText.setText(it.content)
        }

        binding.back.setOnClickListener {
            viewModel.navigateTo(findNavController(), navigate)
        }

        binding.saveDetailButton.setOnClickListener {
            val theme = binding.themeDetailInputEditText.text.toString()
            val content = binding.contentDetailInputEditText.text.toString()

            viewModel.saveCLick(
                Notes(uid = uid, theme = theme, content = content),
                findNavController(), navigate)
        }

        binding.toolbar.textView.setText(R.string.notes_details)
    }
}