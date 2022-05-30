package com.example.notesv2.presentation.view.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notesv2.R
import com.example.notesv2.core.BaseFragment
import com.example.notesv2.databinding.FragmentHomeBinding
import com.example.notesv2.presentation.view.adapter.decorations.FeedHorizontalDividerItemDecoration
import com.example.notesv2.presentation.view.adapter.decorations.GroupVerticalItemDecoration
import com.example.notesv2.presentation.view.adapter.home.HomeAdapter
import com.example.notesv2.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)

    private val viewModel: HomeViewModel by viewModels()

    override fun init() {
        viewModel.setNav(findNavController())
        binding.toolbarHome.textView.setText(R.string.your_notes)

        val recyclerView = binding.list
        val adapter = HomeAdapter(viewModel)
        recyclerView.adapter = adapter

        with(recyclerView) {
            addItemDecoration(FeedHorizontalDividerItemDecoration(0))
            addItemDecoration(GroupVerticalItemDecoration(R.layout.fragment_notes_item, 100, 100))
            addItemDecoration(GroupVerticalItemDecoration(R.layout.fragment_notes_item, 100, 100))
        }

        val animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha_bt)
        viewModel.notes().observe(viewLifecycleOwner) { list ->
            adapter.map(list.asReversed())
            viewModel.changeVisibility(list).apply(binding.empty)
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




