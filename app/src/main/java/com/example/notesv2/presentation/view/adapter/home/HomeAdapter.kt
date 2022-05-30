package com.example.notesv2.presentation.view.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.notesv2.core.AbstractRecyclerAdapter
import com.example.notesv2.core.Mapper
import com.example.notesv2.databinding.FragmentNotesItemBinding
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.presentation.viewmodel.HomeViewModel

class HomeAdapter(
    private val viewModel: HomeViewModel,
) : AbstractRecyclerAdapter<Notes, HomeViewHolder>(), Mapper.Unit<List<Notes>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder(
        viewModel,
        FragmentNotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    )
}