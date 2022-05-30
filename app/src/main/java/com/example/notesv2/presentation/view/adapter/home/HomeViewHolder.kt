package com.example.notesv2.presentation.view.adapter.home

import android.widget.Button
import android.widget.TextView
import com.example.notesv2.core.AbstractViewHolder
import com.example.notesv2.databinding.FragmentNotesItemBinding
import com.example.notesv2.domain.model.Notes
import com.example.notesv2.presentation.model.WidgetsNotes
import com.example.notesv2.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.Job

class HomeViewHolder(
    private val viewModel: HomeViewModel, binding: FragmentNotesItemBinding,
) : AbstractViewHolder<Notes>(binding.root) {

    private val themeView: TextView = binding.content
    private val favoriteBT: Button = binding.favorite
    private val deleteBT: Button = binding.delete

    private val mapper = HomeUi.Mapper.Ui(WidgetsNotes(themeView, favoriteBT), viewModel)

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