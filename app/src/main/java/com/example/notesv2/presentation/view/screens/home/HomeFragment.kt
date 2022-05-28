package com.example.notesv2.presentation.view.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseFragment
import com.example.notesv2.databinding.FragmentHomeBinding
import com.example.notesv2.presentation.view.adapter.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)

    private val viewModel: HomeViewModel by viewModels()

    override fun init() {
        viewModel.setNav(findNavController())
        binding.toolbarHome2.textView.setText(R.string.your_notes)

        val recyclerView = binding.list
        val adapter = NotesAdapter(viewModel)
        recyclerView.adapter = adapter

        val animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_bt)

        viewModel.getAllNotes().observe(viewLifecycleOwner) { list ->
            adapter.map(list.asReversed())
            viewModel.visible(list)
        }

        viewModel.isLayout.observe(viewLifecycleOwner) {
            binding.changeLayoutManager.setBackgroundResource(viewModel.backgroundLayout())
        }

        viewModel.layoutWidth.observe(viewLifecycleOwner) {
            recyclerView.layoutParams.width = viewModel.layoutWidth.value!!
        }

        binding.changeLayoutManager.setOnClickListener {
            it.startAnimation(animAlpha)
            viewModel.changeLayoutManager()
            adapter.notifyItemRangeChanged(0, adapter.itemCount)
        }

        binding.deleteAll.setOnClickListener {
            it.startAnimation(animAlpha)
            viewModel.showDialog(requireActivity(), viewModel)
        }
    }
}




