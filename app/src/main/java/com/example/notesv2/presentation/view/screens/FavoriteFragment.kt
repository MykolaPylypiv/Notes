package com.example.notesv2.presentation.view.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notesv2.R
import com.example.notesv2.core.BaseFragment
import com.example.notesv2.databinding.FragmentFavoriteBinding
import com.example.notesv2.presentation.view.adapter.FavoriteAdapter
import com.example.notesv2.presentation.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentFavoriteBinding.inflate(inflater, container, false)

    private val viewModel: FavoriteViewModel by viewModels()

    override fun init() {
        viewModel.setNav(findNavController())

        val recyclerView: RecyclerView = binding.list
        val adapter = FavoriteAdapter(viewModel)
        recyclerView.adapter = adapter

        viewModel.getLikeNotes().observe(viewLifecycleOwner) { list ->
            adapter.map(list.asReversed())
            viewModel.visibility(list).apply(binding.empty)
        }

        binding.toolbar.textView.setText(R.string.your_favorite_notes)
    }
}
