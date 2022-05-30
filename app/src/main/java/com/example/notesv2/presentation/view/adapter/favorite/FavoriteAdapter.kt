package com.example.notesv2.presentation.view.adapter.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.notesv2.core.AbstractRecyclerAdapter
import com.example.notesv2.core.Mapper
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.databinding.FragmentNotesItemBinding
import com.example.notesv2.presentation.viewmodel.FavoriteViewModel

class FavoriteAdapter(
    private val viewModel: FavoriteViewModel,
) : AbstractRecyclerAdapter<Notes, FavoriteViewHolder>(), Mapper.Unit<List<Notes>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoriteViewHolder(
        viewModel,
        FragmentNotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    )
}