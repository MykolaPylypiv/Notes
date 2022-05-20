package com.example.notesv2.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.notesv2.core.AbstractRecyclerAdapter
import com.example.notesv2.core.AbstractViewHolder
import com.example.notesv2.core.Mapper
import com.example.notesv2.data.entities.Notes
import com.example.notesv2.databinding.FragmentNotesItemBinding
import com.example.notesv2.presentation.screens.home.HomeViewModel
import com.example.notesv2.presentation.ui.HomeUi

class NotesAdapter(
    private val viewModel: HomeViewModel,
) : AbstractRecyclerAdapter<Notes, NotesViewHolder>(), Mapper.Unit<List<Notes>> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NotesViewHolder(
        viewModel,
        FragmentNotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
    )
}

class NotesViewHolder(
    private val viewModel: HomeViewModel, binding: FragmentNotesItemBinding,
) : AbstractViewHolder<Notes>(binding.root) {

    private val themeView: TextView = binding.content
    private val favoriteBT: Button = binding.favorite
    private val deleteBT: Button = binding.delete

    private val mapper = HomeUi.Mapper.Ui(HomeUi.Widgets(themeView, favoriteBT), viewModel)

    override fun bind(data: Notes) {
        mapper.map(data)

        themeView.setOnClickListener {
            HomeUi.Mapper.Theme(viewModel).map(data)
        }

        deleteBT.setOnClickListener {
            HomeUi.Mapper.Delete(viewModel).map(data)
        }

        favoriteBT.setOnClickListener {
            favoriteBT.setBackgroundResource(HomeUi.Mapper.Favorite(viewModel).map(data))
        }
    }
}